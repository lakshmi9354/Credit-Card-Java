package com.ing.creditcardpayment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;
import com.ing.creditcardpayment.entity.Statement;
import com.ing.creditcardpayment.repository.StatementRepository;
@Service
public class StatementServiceImpl implements StatementService{
@Autowired
StatementRepository statementRepository;
	@Override
	public List<StatementDetailsDto> history(StatementsDto statementDto) {
		List<StatementDetailsDto> statementDetailsDtos = new ArrayList<>();
			List<Statement> statements=statementRepository.findHistory(statementDto.getFromDate(),statementDto.getToDate(),statementDto.getCreditCardNumber());
			for(Statement statement : statements) {
				StatementDetailsDto details=new StatementDetailsDto ();
				BeanUtils.copyProperties(statement, details);
				statementDetailsDtos.add(details);
			}
		return statementDetailsDtos;
	}

}
