package com.ing.creditcardpayment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.creditcardpayment.dto.StatementDto;

@RestController
public class PayController {
	
	@PostMapping("/payment")
	public String addPayment(@RequestBody StatementDto statementDto)
	{
		return null;
	}

}
