package com.codewithmeet.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmeet.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
