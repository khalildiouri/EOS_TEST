package com.eos;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eos.entities.CountryEntity;
import com.eos.entities.UserEntity;
import com.eos.services.IUserService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EosApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void isNotNuLLTest() {
		UserEntity user = userService.getUserByLogin("khalil");
		assertThat(user).isNotNull();
		assertThat(user.getCountry().getCountryId()).isEqualTo(2L);
	}

	@Test
	public void listSizeTest() {
		List<UserEntity> users = userService.getAllUsers();
		assertThat(users.size()).isEqualTo(2);
	}
}
