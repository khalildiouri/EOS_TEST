package com.eos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eos.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

	/**
	 * find user by login
	 * 
	 * @param login
	 * @return UserEntity
	 */
	UserEntity findUserByLogin(String login);
}
