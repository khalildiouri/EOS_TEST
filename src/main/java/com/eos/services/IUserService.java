package com.eos.services;

import java.util.List;

import com.eos.entities.UserEntity;

/**
 * interface IUserService
 * 
 * @author kdiouri
 *
 */
public interface IUserService {

	/**
	 * Get User By login
	 * 
	 * @param login
	 * @return UserEntity
	 */
	UserEntity getUserByLogin(String login);

	/**
	 * save user should have age > 18 and countryId = 2 (France)
	 * 
	 * @param user
	 * @return UserEntity
	 */
	UserEntity saveUser(UserEntity user);

	/**
	 * get all users
	 * 
	 * @return List<UserEntity>
	 */
	List<UserEntity> getAllUsers();

}
