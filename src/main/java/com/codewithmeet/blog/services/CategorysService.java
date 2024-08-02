package com.codewithmeet.blog.services;

import java.util.List;


import com.codewithmeet.blog.payloads.CategoryDto;




public interface CategorysService {
	
	//create 
	CategoryDto createCategory(CategoryDto categoryDto); 
	
	//Update 
	CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryID); 
	
	
	//Delete
	void deletcategory(Integer categoryID);
	
	//get
	CategoryDto getcategory(Integer categoryID);
	
	//Get all 
	List<CategoryDto> getallcategory();
	

}
