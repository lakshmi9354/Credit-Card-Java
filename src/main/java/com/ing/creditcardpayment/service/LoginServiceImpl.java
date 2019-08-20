package com.ing.creditcardpayment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.creditcardpayment.dto.LoginDto;
import com.ing.creditcardpayment.dto.LoginDetailsDto;
import com.ing.creditcardpayment.entity.User;
import com.ing.creditcardpayment.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository customerRepository;

	@Override
	public LoginDetailsDto login(LoginDto loginDto) {
		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		User user = customerRepository.findByMobileNoAndPassword(loginDto.getMobileNo(), loginDto.getPassword());
		
		if (user != null) {
			LOGGER.info("user fetched");
			loginResponseDto.setUserId(user.getUserId());
			loginResponseDto.setMessage("LoggedIn Successfully..");
			loginResponseDto.setStatus("SUCCESS");
			return loginResponseDto;
		} else {
			loginResponseDto.setMessage("Login Failed...");
			loginResponseDto.setStatus("FAILURE");
			return loginResponseDto;
		}

	}

}
