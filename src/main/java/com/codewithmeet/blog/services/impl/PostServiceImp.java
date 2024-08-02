package com.codewithmeet.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithmeet.blog.entities.Categorys;
import com.codewithmeet.blog.entities.Post;
import com.codewithmeet.blog.entities.User;
import com.codewithmeet.blog.exception.ResouecenotfoundException;
import com.codewithmeet.blog.payloads.PostDto;
import com.codewithmeet.blog.payloads.PostResponce;
import com.codewithmeet.blog.repositories.CategorysRepo;
import com.codewithmeet.blog.repositories.PostRepo;
import com.codewithmeet.blog.repositories.UserRepo;
import com.codewithmeet.blog.services.PostService;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public UserRepo userRepo;

	@Autowired
	public CategorysRepo categorysRepo;

	@Override
	public PostDto createPost(PostDto postDto, int userid, int catid) {

		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResouecenotfoundException("user", "user id", userid));
		Categorys categorys = this.categorysRepo.findById(catid)
				.orElseThrow(() -> new ResouecenotfoundException("category", "cat id", catid));

		Post postc = this.modelMapper.map(postDto, Post.class); // post in only title and contant
		postc.setImageName("defolt.png");
		postc.setAddeDate(new Date());
		postc.setUser(user);
		postc.setCategorys(categorys);

		Post postsave = this.postRepo.save(postc);
		return this.modelMapper.map(postsave, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, int id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResouecenotfoundException("post", "postid", id));
		post.setTitle(postDto.getTitle());
		post.setContant(postDto.getContant());
		post.setImageName(postDto.getImageName());
		Post savepost = this.postRepo.save(post);
		return this.modelMapper.map(savepost, PostDto.class);
	}

	@Override
	public void deletepost(int id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResouecenotfoundException("post", "postid", id));
		this.postRepo.delete(post);
	}

	@Override
	public void deletAllPost() {
		this.postRepo.deleteAll();

	}

	@Override
	public PostResponce getAllPost(Integer pagenumber, Integer pagesize, String sortdir) {

		Sort sort = (sortdir.equalsIgnoreCase("dsc")) ? Sort.by(sortdir).ascending() : Sort.by(sortdir).descending();
		PageRequest p = PageRequest.of(pagenumber, pagesize, sort);

		Page<Post> pagepost = this.postRepo.findAll(p);
		List<Post> allpost = pagepost.getContent();
		List<PostDto> postDtos = allpost.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		PostResponce postresponce = new PostResponce();
		postresponce.setContent(postDtos);
		postresponce.setPagenumber(pagepost.getNumber());
		postresponce.setPagesize(pagepost.getSize());
		postresponce.setTotalElement(pagepost.getTotalElements());
		postresponce.setTotalpage(pagepost.getTotalPages());
		postresponce.setLastpage(pagepost.isLast());

		return postresponce;
	}

	@Override
	public PostDto getPost(int id) {
		Post posts = this.postRepo.findById(id).orElseThrow(() -> new ResouecenotfoundException("post", "postid", id));
		return this.modelMapper.map(posts, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPostByuser(int userid) {
		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResouecenotfoundException("user", "user id ", userid));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postdtos;
	}

	@Override
	public List<PostDto> getAllPostByCategory(int catid) {

		Categorys cat = this.categorysRepo.findById(catid)
				.orElseThrow(() -> new ResouecenotfoundException("cat", "catid", catid));
		List<Post> posts = this.postRepo.findByCategorys(cat);
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> serchPost(String Keyword) {
		List<Post> post = this.postRepo.searchByTitle("%"+Keyword+"%");
		List<PostDto> postDtos = post.stream().map((post1) -> this.modelMapper.map(post1, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
