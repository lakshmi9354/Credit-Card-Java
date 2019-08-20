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
import org.springframework.web.bind.annotation.RestController;

import com.ing.creditcardpayment.dto.LoginDto;
import com.ing.creditcardpayment.dto.LoginDetailsDto;
import com.ing.creditcardpayment.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
@RequestMapping("/api")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginDetailsDto> login(@RequestBody LoginDto loginDto)
	{
		LOGGER.info("inside modelbank");
		LoginDetailsDto loginResponseDto=loginService.login(loginDto);
		return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
	}
		
	 
	

}
