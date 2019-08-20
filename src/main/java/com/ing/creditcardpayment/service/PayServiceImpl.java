package com.ing.creditcardpayment.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.creditcardpayment.api.MailService;
import com.ing.creditcardpayment.api.OtpApi;
import com.ing.creditcardpayment.dto.ResponseDto;
import com.ing.creditcardpayment.dto.StatementDto;
import com.ing.creditcardpayment.entity.CreditCard;
import com.ing.creditcardpayment.entity.Otp;
import com.ing.creditcardpayment.entity.Statement;
import com.ing.creditcardpayment.entity.User;
import com.ing.creditcardpayment.repository.CreditCardRepository;
import com.ing.creditcardpayment.repository.OtpRepository;
import com.ing.creditcardpayment.repository.StatementRepository;
import com.ing.creditcardpayment.repository.UserRepository;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	CreditCardRepository creditRepository;

	@Autowired
	OtpRepository otpRepository;

	@Autowired
	StatementRepository statementRepository;

	@Autowired
	MailService emailService;

	@Autowired
	UserRepository userRepository;

	public ResponseDto addTransaction(StatementDto statementDto) {

		OtpApi optapi = new OtpApi();
		String otp = String.valueOf(optapi.OTP(6));
		Date date = new Date();
		Statement statement = new Statement();
		statement.setTransactionDate(date);
		BeanUtils.copyProperties(statementDto, statement);
		statement.setTransactionStatus("Pending");

		CreditCard creditCardDetails = creditRepository.findBycreditCardNumber(statementDto.getCreditCardNumber());
		Optional<User> userDetails = userRepository.findById(creditCardDetails.getUserId());
		if (userDetails.get().getUserId() == creditCardDetails.getUserId()) {
			if (creditCardDetails.getCreditCardNumber().equals(statementDto.getCreditCardNumber()) ){
				if (statementDto.getCardType().equalsIgnoreCase("visa")) {
					emailService.sendEmail(otp, userDetails.get().getEmail());
					Otp otpData = new Otp();
					otpData.setDate(date);
					otpData.setCreditCardId(creditCardDetails.getCreditCardId());
					otpData.setOtpNo(Integer.parseInt(otp));
					otpData.setStatus("pending");
					otpRepository.save(otpData);
					statementRepository.save(statement);
				} else if (statementDto.getCardType().equalsIgnoreCase("master")) {
					emailService.sendEmail(otp, userDetails.get().getEmail());
					Otp otpData = new Otp();
					otpData.setDate(date);
					otpData.setCreditCardId(creditCardDetails.getCreditCardId());
					otpData.setOtpNo(Integer.parseInt(otp));
					otpData.setStatus("pending");
					otpRepository.save(otpData);
					statementRepository.save(statement);
				}

			} else {
				return new ResponseDto("Enter Valid Credit Card...");
			}
			return new ResponseDto("payment added successfully");
		} else {
			return new ResponseDto("User Not For this Credit Card");
		}

	}

}
