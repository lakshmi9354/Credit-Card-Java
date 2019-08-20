package com.ing.creditcardpayment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.creditcardpayment.entity.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {

	List<Statement> findHistory(Date fromDate, Date toDate, Long creditCardNumber);

}
