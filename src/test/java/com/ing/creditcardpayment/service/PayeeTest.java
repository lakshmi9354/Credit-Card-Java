package com.ing.creditcardpayment.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.creditcardpayment.dto.ResponseDto;
import com.ing.creditcardpayment.entity.Otp;
import com.ing.creditcardpayment.entity.Statement;
import com.ing.creditcardpayment.repository.OtpRepository;
import com.ing.creditcardpayment.repository.StatementRepository;



@RunWith(MockitoJUnitRunner.class)
public class PayeeTest {
	
	@InjectMocks
	PayServiceImpl payService;
	
	@Mock
	OtpRepository otpRepository;
	
	@Mock
	StatementRepository statementRepository;
	
	public Otp getOtp() {
		Otp otp = new Otp();
		otp.setCreditCardId(1);
		otp.setOtpId(1);
		otp.setOtpNo(536789);
		otp.setStatus("pending");
		return otp;
	}
	
	
	public Statement getStatement()
	{
		Statement statement = new Statement();
		statement.setAmount((double) 20000);
		statement.setCreditCardNumber(456789341256L);
		statement.setReason("test for this purpose");
		statement.setStatementId(1);
		statement.setTransactionStatus("pending");
		statement.setTransactionType("Debit");
		return statement;
	}
	
	@Test
	public void otpTestPositive()
	{
		Otp otpDetails = getOtp();
		Statement statement = getStatement();
		Mockito.when(otpRepository.findByotpNo(536789)).thenReturn(otpDetails);
		Mockito.when(statementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(statement));
		ResponseDto responseDto = payService.verifyOtp(536789);
		Assert.assertEquals("OTP verified successfully", responseDto.getMessage());
	}
	
	@Test
	public void otpTestNegative()
	{
		Otp otpDetails = getOtp();
		Statement statement = getStatement();
		Mockito.when(otpRepository.findByotpNo(536780)).thenReturn(otpDetails);
		Mockito.when(statementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(statement));
		ResponseDto responseDto = payService.verifyOtp(536780);
		Assert.assertEquals("OTP Is Wrong", responseDto.getMessage());
	}

}
