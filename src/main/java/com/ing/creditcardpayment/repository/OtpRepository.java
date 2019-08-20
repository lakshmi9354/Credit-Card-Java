package com.ing.creditcardpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.creditcardpayment.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {

	public Otp findByotpNo(int otpNo);
	
}
