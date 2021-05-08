package com.eos.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, length = 11)
	private Long id;

	@Column(name = "login", nullable = false, length = 100, unique = true)
	private String login;

	@Column(name = "first_name", nullable = true, length = 100)
	private String firstName;

	@Column(name = "last_name", nullable = true, length = 100)
	private String lastName;

	@Column(name = "email", nullable = true, length = 200)
	private String email;

	@Column(name = "status", nullable = true, length = 30)
	private String status;
	
	@Column(name = "age", nullable = false, length = 30)
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private CountryEntity country;

}
