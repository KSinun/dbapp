package com.korea.dbapp.test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.korea.dbapp.domain.post.Post;
import com.korea.dbapp.domain.post.PostRepository;

@RestController
public class PostApiControllerTest {
	
	private final PostRepository postRepository;

	public PostApiControllerTest(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@GetMapping("/test/post")
	public List<Post> findAll(){
		// SELECT * FROM post
		return postRepository.findAll();
	}
	
	@GetMapping("/test/post/{id}")
	public Post findById(@PathVariable int id) {
		return postRepository.findById(id).get();
	}
	
}
