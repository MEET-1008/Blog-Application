package com.codewithmeet.blog.services;

import com.codewithmeet.blog.payloads.CommentDto;

public interface CommentService  {
	
	public CommentDto commentcreated(CommentDto commentDto , int postID);
	
	public void commentdeleted(int id);

}
