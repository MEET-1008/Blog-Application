package com.codewithmeet.blog.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	public String name ;
	
	
}
