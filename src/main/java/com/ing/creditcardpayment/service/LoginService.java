package com.ing.creditcardpayment.service;

import com.ing.creditcardpayment.dto.LoginDto;
import com.ing.creditcardpayment.dto.LoginDetailsDto;

public interface LoginService {

	public LoginDetailsDto login(LoginDto loginDto);

}
