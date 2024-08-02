package com.codewithmeet.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Categorys {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Category_Id ;
	
	public String Category_Name;
	
	public String Category_Des;
	
	@OneToMany(mappedBy = "categorys",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public List<Post> post = new ArrayList<>();

}
