package com.ing.creditcardpayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;
import com.ing.creditcardpayment.service.StatementService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class StatementController {
	@Autowired
	StatementService statementService;

	@PostMapping("/statement")
	public ResponseEntity<List<StatementDetailsDto>> transactionHistory(@RequestBody StatementsDto statementDto) {
		List<StatementDetailsDto> response = statementService.history(statementDto);
		return new ResponseEntity<List<StatementDetailsDto>>(response, HttpStatus.OK);
	}

}
