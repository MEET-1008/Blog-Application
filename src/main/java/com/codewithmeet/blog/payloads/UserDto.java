package com.codewithmeet.blog.payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@NotEmpty
	@NotNull
	@Size(min=4,message = "min 4 chr are requer name fild..!! ")
	public String name ;
	
	@NotEmpty
	@Email(message = "email address is  are note validate..!!  ")
	public String email;
	
	@NotEmpty
	@Size(min = 4 ,message = "min size of password is 4 ")
	public String password;
	
}
