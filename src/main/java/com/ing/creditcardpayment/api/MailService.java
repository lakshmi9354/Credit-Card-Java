package com.ing.creditcardpayment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	

	/**
	 * This function is used to send mail without attachment.
	 * @param otp 
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(String otp, String email){

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("Credit Card Otp");
		mail.setTo(email);
		mail.setText("OTP for Login is" +otp);

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}



}
