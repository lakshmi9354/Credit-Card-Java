package com.ing.creditcardpayment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;
import com.ing.creditcardpayment.entity.CreditCard;
import com.ing.creditcardpayment.entity.Statement;
import com.ing.creditcardpayment.exception.CreditCardNotFound;
import com.ing.creditcardpayment.repository.CreditCardRepository;
import com.ing.creditcardpayment.repository.StatementRepository;

@Service
public class StatementServiceImpl implements StatementService {
	@Autowired
	StatementRepository statementRepository;

	@Autowired
	CreditCardRepository creditCardRepository;

	@Override
	public List<StatementDetailsDto> history(StatementsDto statementDto) throws CreditCardNotFound {
		List<StatementDetailsDto> statementDetailsDtos = new ArrayList<>();
		CreditCard creditCard = creditCardRepository.findByUserIdAndCreditCardNumber(statementDto.getUserId(),
				statementDto.getCreditCardNumber());
		if (creditCard.getUserId() != 0) {
			List<Statement> statements = statementRepository.findHistory(statementDto.getFromDate(),
					statementDto.getToDate(), statementDto.getCreditCardNumber());
			for (Statement statement : statements) {
				StatementDetailsDto details = new StatementDetailsDto();
				BeanUtils.copyProperties(statement, details);
				statementDetailsDtos.add(details);
			}
			return statementDetailsDtos;
		}
		else {
			StatementDetailsDto details = new StatementDetailsDto();
			details.setMessage("Credit Card Number Not For this User");
			statementDetailsDtos.add(details);
			return statementDetailsDtos;
		}
		
	}

}
