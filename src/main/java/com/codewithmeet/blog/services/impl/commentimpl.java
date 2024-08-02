package com.codewithmeet.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmeet.blog.entities.Comment;
import com.codewithmeet.blog.entities.Post;
import com.codewithmeet.blog.exception.ResouecenotfoundException;
import com.codewithmeet.blog.payloads.CommentDto;
import com.codewithmeet.blog.repositories.CommentRepo;
import com.codewithmeet.blog.repositories.PostRepo;
import com.codewithmeet.blog.services.CommentService;

@Service
public class commentimpl implements CommentService {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public CommentRepo commentRepo;

	@Autowired
	public PostRepo postRepo;

	@Override
	public CommentDto commentcreated(CommentDto commentDto, int postID) {

		Post postid = this.postRepo.findById(postID)
				.orElseThrow(() -> new ResouecenotfoundException("post", "post id ", postID));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(postid);
		Comment save = this.commentRepo.save(comment);
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public void commentdeleted(int id1) {
		Comment comment = this.commentRepo.findById(id1)
				.orElseThrow(() -> new ResouecenotfoundException("post", "post id ", id1));

		this.commentRepo.delete(comment);

	}

}
