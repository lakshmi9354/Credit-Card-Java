package com.ing.creditcardpayment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.creditcardpayment.dto.ResponseDto;
import com.ing.creditcardpayment.dto.StatementDto;
import com.ing.creditcardpayment.entity.Otp;
import com.ing.creditcardpayment.service.PayService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
@RequestMapping("/api")
public class PayController {
	
	
	@Autowired
	PayService payService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);
	
	@PostMapping("/paymentMaster")
	public ResponseEntity<ResponseDto> addPayment(@RequestBody StatementDto statementDto)
	{
		LOGGER.info("enntered into add payment controller");
		return new ResponseEntity<ResponseDto>(payService.addTransaction(statementDto),HttpStatus.OK);
	}
	
	@PostMapping("/otpVerification")
	public ResponseEntity<ResponseDto> verifyOtp(@RequestParam(value = "otpNo") int otpNo)
	{
		return new ResponseEntity<ResponseDto>(HttpStatus.OK);
	}

}
