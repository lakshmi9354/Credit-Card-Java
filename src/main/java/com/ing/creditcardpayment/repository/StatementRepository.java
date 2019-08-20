package com.ing.creditcardpayment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.creditcardpayment.entity.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
	@Query("select  c from Statement c where c.transactionDate>=:fromdate and c.transactionDate<=:todate and creditCardNumber=:creditCardNumber")

	List<Statement> findHistory(@Param("fromdate")Date fromDate,@Param("todate") Date toDate, Long creditCardNumber);

	List<Statement> findHistory(Date fromDate, Date toDate, Long creditCardNumber);

}
