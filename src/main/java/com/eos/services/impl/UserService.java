package com.eos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.eos.constants.ExceptionCodeEnum;
import com.eos.entities.UserEntity;
import com.eos.repositories.IUserRepository;
import com.eos.services.IUserService;

/**
 * class UserService
 * 
 * @author kdiouri
 *
 */
@Service
public class UserService implements IUserService {

	private static final Long FRANCE = 2L;

	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserEntity getUserByLogin(String login) {

		UserEntity userEntity = userRepo.findUserByLogin(login);
		if (userEntity == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ExceptionCodeEnum.DATA_NOT_FOUND.getErrorCode()
							+ " - "
							+ ExceptionCodeEnum.DATA_NOT_FOUND
									.getErrorContext() + " [login: " + login
							+ "]");
		}
		return userEntity;
	}

	@Override
	public UserEntity saveUser(UserEntity user) {

		if (user == null || user.getLogin() == null || user.getAge() == null
				|| user.getCountry() == null
				|| user.getCountry().getCountryId() == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ExceptionCodeEnum.PROBLEM_CRITERIA_BIZ.getErrorContext());
		} else {
			if (user.getAge() < 18
					|| user.getCountry().getCountryId() != FRANCE) {
				throw new ResponseStatusException(
						HttpStatus.INTERNAL_SERVER_ERROR,
						ExceptionCodeEnum.USER_ACCEPTANTCE_CRITERIA
								.getErrorContext());
			}
		}
		return userRepo.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}
}
