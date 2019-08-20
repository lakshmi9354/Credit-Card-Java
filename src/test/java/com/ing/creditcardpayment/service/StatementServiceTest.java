package com.ing.creditcardpayment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;
import com.ing.creditcardpayment.entity.CreditCard;
import com.ing.creditcardpayment.entity.Statement;
import com.ing.creditcardpayment.repository.CreditCardRepository;
import com.ing.creditcardpayment.repository.StatementRepository;

@RunWith(MockitoJUnitRunner.class)
public class StatementServiceTest {
	@Mock
	StatementRepository statementRepository;
	@Mock
	CreditCardRepository creditCardRepository;
	@InjectMocks
	StatementServiceImpl statementService;

	@Test
	public void testHistory() {
		List<StatementDetailsDto> d = new ArrayList<StatementDetailsDto>();
		StatementDetailsDto detailDto = new StatementDetailsDto();
		detailDto.setCreditCardNumber(1l);
		detailDto.setAmount(2100);
		detailDto.setMessage("success");
		detailDto.setTransactionType("credit");
		d.add(detailDto);
		List<Statement> statement = new ArrayList<Statement>();
		Statement state = new Statement();
		state.setCreditCardNumber(1l);
		statement.add(state);
		StatementsDto dto = new StatementsDto();
		dto.setCreditCardNumber(1l);
		dto.setFromDate(new Date());
		dto.setToDate(new Date());
		dto.setUserId(1);
		List<CreditCard> creditCards = new ArrayList<CreditCard>();
		CreditCard card = new CreditCard();
		card.setBankName("hdfc");
		creditCards.add(card);
		String bankType = null;
		List<CreditCard> creditCard = creditCardRepository.findByUserIdAndCreditCardNumber(dto.getUserId(),
				dto.getCreditCardNumber());
		for (CreditCard creditCards1 : creditCard) {
			bankType = creditCards1.getBankName();
		}
		if (bankType != null) {
			Mockito.when(statementRepository.findHistory(dto.getFromDate(), dto.getToDate(), dto.getCreditCardNumber()))
					.thenReturn(statement);
			List<StatementDetailsDto> detailsDto = statementService.history(dto);
			assertNotNull(detailsDto);
			assertEquals(1, detailsDto.size());
		}
	}
}