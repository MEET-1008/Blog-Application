package com.codewithmeet.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.codewithmeet.blog.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private int postid;

	private String title;

	private String contant;

	private String imageName;

	private Date addeDate;

	private CategoryDto categorys;

	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
}
