package com.codewithmeet.blog.payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer category_Id;
	
	public String category_Name;
	
	public String category_Des;

}
