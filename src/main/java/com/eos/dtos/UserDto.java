package com.eos.dtos;

import com.eos.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private String email;
	private String status;
	private Integer age;

	private CountryDto country;

	/**
	 * Convert Entity object to its DTO form
	 *
	 * @return UserDto
	 */
	public static UserDto entityToDto(UserEntity userEntity) {
		return new UserDto(userEntity.getId(), userEntity.getLogin(),
				userEntity.getFirstName(), userEntity.getLastName(),
				userEntity.getEmail(), userEntity.getStatus(),
				userEntity.getAge(), CountryDto.entityToDto(userEntity
						.getCountry()));

	}

	/**
	 * Convert DTO form to its Entity object
	 * 
	 * @param UserEntity
	 * @return
	 */
	public static UserEntity dtoToEntity(UserDto userDto) {
		return new UserEntity(userDto.getId(), userDto.getLogin(),
				userDto.getFirstName(), userDto.getLastName(),
				userDto.getEmail(), userDto.getStatus(), userDto.getAge(),
				CountryDto.dtoToEntity(userDto.getCountry()));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{login: " + login + ", firstName: " + firstName + "}";
	}
}
