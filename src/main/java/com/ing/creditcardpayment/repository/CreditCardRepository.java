package com.ing.creditcardpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.creditcardpayment.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

	public CreditCard findBycreditCardNumber(Long creditCardNumber);

	List<CreditCard> findByUserIdAndCreditCardNumber(int userId, Long creditCardNumber);
	
}
