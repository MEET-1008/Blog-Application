package com.codewithmeet.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmeet.blog.payloads.ApiResponse;
import com.codewithmeet.blog.payloads.CommentDto;
import com.codewithmeet.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class commentcontroller {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postid}/comment")
	public ResponseEntity<CommentDto> createdcomment (@PathVariable int postid, @RequestBody CommentDto comment){
		CommentDto creaed = this.commentService.commentcreated(comment, postid);
		return new ResponseEntity<CommentDto>(creaed ,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/comments/{commentid}")
	public ResponseEntity<ApiResponse> deletcomment (@PathVariable int commentid){
		this.commentService.commentdeleted(commentid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("comment successfully deleted...!",true),HttpStatus.OK);
		
	}
	
	
}
