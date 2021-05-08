package com.eos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import com.eos.dtos.UserDto;
import com.eos.entities.UserEntity;
import com.eos.reponse.ResponseObject;
import com.eos.services.impl.UserService;

/**
 * user Controller
 * 
 * @author kdiouri
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save")
	public ResponseObject saveUser(@RequestBody UserDto user,
			HttpServletRequest request) {

		UserEntity userEntity = null;
		userEntity = userService.saveUser(UserDto.dtoToEntity(user));
		return new ResponseObject(UserDto.entityToDto(userEntity),
				HttpStatus.OK);

	}

	@GetMapping(value = "/get/{login}")
	public ResponseObject getUser(@PathVariable String login,
			HttpServletRequest request) {

		UserEntity userEntity = null;
		userEntity = userService.getUserByLogin(login);
		return new ResponseObject(UserDto.entityToDto(userEntity),
				HttpStatus.OK);

	}

	@GetMapping(value = "/s")
	public ResponseObject getUserS(@RequestParam String s,
			HttpServletRequest request) {

		return new ResponseObject(s, HttpStatus.OK);

	}

	@GetMapping(value = "/get")
	public ResponseObject getUserParam(
			@RequestParam(defaultValue = "admin", required = false) String login,
			HttpServletRequest request) {

		UserEntity userEntity = null;
		userEntity = userService.getUserByLogin(login);

		return new ResponseObject(UserDto.entityToDto(userEntity),
				HttpStatus.OK);

	}
}
