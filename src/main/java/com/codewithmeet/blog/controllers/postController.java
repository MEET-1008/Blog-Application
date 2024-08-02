package com.codewithmeet.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmeet.blog.config.appconstant;
import com.codewithmeet.blog.entities.Post;
import com.codewithmeet.blog.payloads.ApiResponse;
import com.codewithmeet.blog.payloads.PostDto;
import com.codewithmeet.blog.payloads.PostResponce;
import com.codewithmeet.blog.services.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/")
public class postController {

	@Autowired
	private PostService postService;

	// created
	@PostMapping("/user/{user_id}/categorys/{category_id}/post")
	public ResponseEntity<PostDto> postcreate(@RequestBody PostDto postDto, @PathVariable("user_id") int user_id,
			@PathVariable("category_id") int category_id) {

		PostDto post = this.postService.createPost(postDto, user_id, category_id);
		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);

	}

	// get all post by user
	@GetMapping("/user/{user_user_id}/post")
	public ResponseEntity<List<PostDto>> GetpostByUser(@PathVariable("user_user_id") int user_user_id) {
		List<PostDto> allPostByuser = this.postService.getAllPostByuser(user_user_id);
		return new ResponseEntity<List<PostDto>>(allPostByuser, HttpStatus.OK);
	}

	// getall post by category
	@GetMapping("/categorys/{category_id}/post")
	public ResponseEntity<List<PostDto>> GetpostBycategory(@PathVariable("category_id") int category_id) {
		List<PostDto> allPostBycategory = this.postService.getAllPostByCategory(category_id);
		return new ResponseEntity<List<PostDto>>(allPostBycategory, HttpStatus.OK);
	}
	

	// get all post
	@GetMapping("post/")
	public ResponseEntity<PostResponce> getallpost(
			@RequestParam(value = "pagenumber" , required = false,defaultValue = appconstant.PAGE_NUMBER) Integer pagenumber,
			@RequestParam(value = "pagesize" , required = false , defaultValue = appconstant.PAGE_SIZE) Integer pagesize,
			@RequestParam(value = "sortdir" , required = false , defaultValue = appconstant.SORT_DIR) String sortdir
			
			) {
		 PostResponce postResponce = this.postService.getAllPost(pagenumber,pagesize,sortdir);
		return new ResponseEntity<PostResponce>(postResponce, HttpStatus.OK);
	}
	

	// get single post
	@GetMapping("post/{id}")
	public ResponseEntity<PostDto> getSinglepost (@PathVariable int id){
			PostDto postfind = this.postService.getPost(id);
			return new ResponseEntity<PostDto>(postfind,HttpStatus.OK);
	}
	
	
	// update post 
	@PutMapping("post/{id}")
	public ResponseEntity<PostDto> upadtepost(@PathVariable int id, @RequestBody PostDto postDto) {
		PostDto updatePost = this.postService.updatePost(postDto, id);
		return new ResponseEntity<PostDto>(updatePost , HttpStatus.OK);
	}
	
	
	//post delet
	@DeleteMapping("post/")
	public void deletpost(){
		this.postService.deletAllPost();
	}
	
	// singal post delet
	@DeleteMapping("post/{id}")
	public void singalpostdelet(@PathVariable int id ) {
		this.postService.deletepost(id);
	}
	
	
	// serch the post result 
	@GetMapping("/post/search/{keyword}")
	public ResponseEntity<List<PostDto>> serchPost(@PathVariable("keyword") String Keyword1) {
		List<PostDto> result = this.postService.serchPost(Keyword1);
		
		return new ResponseEntity<List<PostDto>> (result ,HttpStatus.OK);
	}
	
	
	
	
	

}
