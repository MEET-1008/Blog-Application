package com.codewithmeet.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithmeet.blog.entities.Categorys;
import com.codewithmeet.blog.entities.Post;
import com.codewithmeet.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	 List<Post> findByUser(User user);

     List<Post> findByCategorys(Categorys cat);
	
	@Query("select p from Post p where p.title like :key")
	public List<Post> searchByTitle (@Param("key")    String title );
	
//	 List<Post> findByTitleContains(String title);
	
	

}
