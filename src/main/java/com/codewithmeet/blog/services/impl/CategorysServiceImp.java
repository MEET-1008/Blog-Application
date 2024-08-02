package com.codewithmeet.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmeet.blog.entities.Categorys;
import com.codewithmeet.blog.exception.ResouecenotfoundException;
import com.codewithmeet.blog.payloads.CategoryDto;
import com.codewithmeet.blog.repositories.CategorysRepo;
import com.codewithmeet.blog.services.CategorysService;

@Service
public class CategorysServiceImp implements CategorysService {

	@Autowired
	private CategorysRepo categorysrepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Categorys cat = this.modelmapper.map(categoryDto, Categorys.class); // categorydto to category
		Categorys addedcat = this.categorysrepo.save(cat);
		return this.modelmapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryID) {
		Categorys cat = this.categorysrepo.findById(categoryID)
				.orElseThrow(() -> new ResouecenotfoundException("Category", "CotegotyID", categoryID));
		cat.setCategory_Name(categoryDto.getCategory_Name());
		cat.setCategory_Des(categoryDto.getCategory_Des());

		Categorys updatecat = this.categorysrepo.save(cat);
		return this.modelmapper.map(updatecat, CategoryDto.class);
	}

	@Override
	public void deletcategory(Integer categoryID) {
		Categorys cat = this.categorysrepo.findById(categoryID)
				.orElseThrow(() -> new ResouecenotfoundException("category", "cotegotyid", categoryID));
		this.categorysrepo.delete(cat);
	}

	@Override
	public CategoryDto getcategory(Integer categoryID) {
		Categorys cat = this.categorysrepo.findById(categoryID)
				.orElseThrow(() -> new ResouecenotfoundException("category", "categoryid", categoryID));
		return this.modelmapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getallcategory() {
		List<Categorys> categorys = this.categorysrepo.findAll();
		List<CategoryDto> catdto = categorys.stream().map((category) -> this.modelmapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return catdto;
	}

}
