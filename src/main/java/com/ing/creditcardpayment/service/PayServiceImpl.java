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
		
		CreditCard creditCardDetails = creditRepository.findBycreditCardNumber(statementDto.getCreditCardNumber());
		Optional<User> userDetails = userRepository.findById(creditCardDetails.getUserId());
		
		if(statementRepository.save(statement) != null)
		{
			emailService.sendEmail(otp, userDetails.get().getEmail());
			Otp otpData = new Otp();
			otpData.setDate(date);
			otpData.setCreditCardId(creditCardDetails.getCreditCardId());
			otpData.setOtpNo(Integer.parseInt(otp));
			otpData.setStatus("pending");
			otpRepository.save(otpData);
			return new ResponseDto("payment added successfully");
		}
		
		return new ResponseDto("payment not added successfully");
	}



	public ResponseDto verifyOtp(int otpNo) {
		Otp otpDetails = otpRepository.findByotpNo(otpNo);
		Optional<Statement> statementDetails = statementRepository.findById(otpDetails.getCreditCardId());
		//creditCardId
		if(otpDetails.getOtpNo() == otpNo)
		{
			Otp otp = new Otp();
			otp.setOtpId(otpDetails.getOtpId());
			otp.setStatus("success");
			otpRepository.save(otp);
			
			Statement statement = new Statement();
			statement.setTransactionStatus("success");
			statement.setStatementId(statementDetails.get().getStatementId());
			statementRepository.save(statement);
			return new ResponseDto("OTP verified successfully");
		}else
		{
			return new ResponseDto("OTP Is Wrong");
		}
	}

}
