package com.eos.exceptions;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;
	private Integer status;
}
