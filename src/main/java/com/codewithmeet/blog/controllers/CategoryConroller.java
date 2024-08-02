package com.codewithmeet.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmeet.blog.payloads.CategoryDto;
import com.codewithmeet.blog.services.CategorysService;

@RestController
@RequestMapping("Api/category")
public class CategoryConroller {
	
	@Autowired
	public CategorysService cateserService;
	
	
	//create 
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategorys(@RequestBody CategoryDto categorydto){
		CategoryDto createcategory = this.cateserService.createCategory(categorydto);
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updatecategory(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
		CategoryDto updateCategory = this.cateserService.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	public void  deletcat(@PathVariable int id ){
		this.cateserService.deletcategory(id);
	}
	
	
	//get
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@RequestBody CategoryDto categorydto,@PathVariable int id ){
		CategoryDto createcategory = this.cateserService.getcategory(id);
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.OK);
	}
	
	
	//get-all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getallcategorys() {
		List<CategoryDto> getall =  this.cateserService.getallcategory();
		return ResponseEntity.ok(getall);
	}
	

}
