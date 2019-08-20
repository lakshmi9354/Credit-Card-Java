package com.ing.creditcardpayment.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.creditcardpayment.dto.LoginDetailsDto;
import com.ing.creditcardpayment.dto.LoginDto;
import com.ing.creditcardpayment.entity.User;
import com.ing.creditcardpayment.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	LoginServiceImpl loginService;
	
	LoginDto loginDto = null;
	LoginDetailsDto loginDetailsDto = null;
	LoginDetailsDto loginDetailsDto1 = null;
	User user = null;
	
	@Before
	public void setup() {
		loginDto = new LoginDto();
		loginDto.setMobileNo("961833");
		loginDto.setPassword("lak");
		loginDetailsDto = new LoginDetailsDto();
		loginDetailsDto.setMessage("LoggedIn Successfully..");
		loginDetailsDto.setStatus("SUCCESS");
		loginDetailsDto1 = new LoginDetailsDto();
		loginDetailsDto1.setMessage("Login Failed...");
		loginDetailsDto1.setStatus("FAILURE");
		
		user = new User();
		user.setMobileNo("961833");
	}
	
	@Test
	public void loginSuccessTest() {
		Mockito.when(userRepository.findByMobileNoAndPassword("961833", "lak")).thenReturn(user);
		assertEquals(loginDetailsDto.toString(), loginService.login(loginDto).toString());
	}
	
	@Test
	public void loginNullTest() {
		Mockito.when(userRepository.findByMobileNoAndPassword("961833", "lak")).thenReturn(null);
		assertEquals(loginDetailsDto1.toString(), loginService.login(loginDto).toString());
	}
}
