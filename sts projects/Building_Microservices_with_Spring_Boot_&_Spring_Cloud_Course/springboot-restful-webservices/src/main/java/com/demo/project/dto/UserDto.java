package com.demo.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
		description = "UserDto Model Information"
		)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	
	@Schema(
			description = "User First Name"
			)
	@NotEmpty(message = "User First Name should not be null or empty")
	private String firstName;
	
	@Schema(
			description = "User Last Name"
			)
	@NotEmpty(message = "User Last Name should not be null or empty")
	private String lastName;
	
	@Schema(
			description = "User Email"
			)
	@NotEmpty(message = "User Email should not be null or empty")
	@Email(message = "Email should be valid")
//	private String emailAddress;
	private String email;

}
