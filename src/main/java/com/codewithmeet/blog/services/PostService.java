package com.codewithmeet.blog.services;

import java.util.List;

import com.codewithmeet.blog.entities.Post;
import com.codewithmeet.blog.payloads.PostDto;
import com.codewithmeet.blog.payloads.PostResponce;

public interface PostService {

	//created
	PostDto createPost(PostDto postDto , int userid,int catid);
	
	//update  post
	PostDto updatePost(PostDto postDto, int id );
	
	//deletpost
	void deletepost(int id );
	
	//delets all post
	void deletAllPost();
	
	//get all post
	PostResponce getAllPost (Integer pagenumber,Integer pagesize,String sortby);
	
	//get single post
	PostDto getPost(int id );
	
	//get All post by user
	List<PostDto> getAllPostByuser(int id );
	
	//get all post by category 
	List<PostDto> getAllPostByCategory(int id );
	
	//search post by id 
	List<PostDto> serchPost (String Keyword);
	
	
}
