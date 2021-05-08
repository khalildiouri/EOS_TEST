package com.eos.entities;

import javax.persistence.*;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", nullable = false, length = 11)
	private Long countryId;

	@Column(name = "country_name", nullable = false, length = 100)
	private String countryName;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<UserEntity> users = new ArrayList<>();

}
