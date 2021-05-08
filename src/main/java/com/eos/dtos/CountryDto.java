package com.eos.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.eos.entities.CountryEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {

	private Long countryId;
	private String countryName;

	private List<UserDto> users = new ArrayList<>();

	/**
	 * Convert Entity object to its DTO form
	 *
	 * @return CountryDto
	 */
	public static CountryDto entityToDto(CountryEntity entity) {
		CountryDto dto = null;
		if (entity != null) {
			dto = new CountryDto();
			dto.setCountryId(entity.getCountryId());
			dto.setCountryName(entity.getCountryName());
		}
		return dto;

	}

	/**
	 * Convert DTO form to its Entity object
	 * 
	 * @param CountryEntity
	 * @return
	 */
	public static CountryEntity dtoToEntity(CountryDto dto) {
		CountryEntity entity = null;
		if (dto != null) {
			entity = new CountryEntity();
			entity.setCountryId(dto.getCountryId());
			entity.setCountryName(dto.getCountryName());
		}
		return entity;
	}

}
