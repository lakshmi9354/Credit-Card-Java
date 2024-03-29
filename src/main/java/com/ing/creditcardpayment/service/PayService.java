package com.ing.creditcardpayment.service;

import org.springframework.stereotype.Service;

import com.ing.creditcardpayment.dto.ResponseDto;
import com.ing.creditcardpayment.dto.StatementDto;

@Service
public interface PayService {
	
	public ResponseDto addTransaction(StatementDto statementDto);
	
	public ResponseDto verifyOtp(int otp);

}
