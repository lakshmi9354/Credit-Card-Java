package com.ing.creditcardpayment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
	
	@PostMapping("/payment")
	public String addPayment()
	{
		return null;
	}

}
