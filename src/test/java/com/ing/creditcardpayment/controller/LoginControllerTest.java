package com.ing.creditcardpayment.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.creditcardpayment.dto.LoginDetailsDto;
import com.ing.creditcardpayment.dto.LoginDto;
import com.ing.creditcardpayment.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	@Mock
	LoginService loginService;
	
	@InjectMocks
	LoginController loginController;
	
	LoginDto loginDto = null;
	LoginDetailsDto loginDetailsDto = null;
	
	@Before
	public void setup() {
		loginDto = new LoginDto();
		loginDto.setMobileNo("961833");
		loginDetailsDto = new LoginDetailsDto();
		loginDetailsDto.setMessage("MS");
	}
	
	@Test
	public void loginTest() {
		Mockito.when(loginService.login(loginDto)).thenReturn(loginDetailsDto);
		ResponseEntity<LoginDetailsDto> responseEntity = loginController.login(loginDto);
		LoginDetailsDto loginDetailsDtos = responseEntity.getBody();
		assertEquals(loginDetailsDto.toString(), loginDetailsDtos.toString());
	}
}
