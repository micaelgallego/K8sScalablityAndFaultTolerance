package es.codeurjc.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.board.model.Post;
import es.codeurjc.board.repository.PostRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
	
	@Autowired
	private PostRepository posts;

	@Transactional(readOnly = false)
	public void save(Post post) {
		posts.save(post);		
	}

	@Transactional(readOnly = true)
	public List<Post> findAll() {
		return posts.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Post> findById(long id) {
		return posts.findById(id);
	}

	@Transactional(readOnly = false)
	public void replace(Post updatedPost) {

		posts.findById(updatedPost.getId()).orElseThrow();

		posts.save(updatedPost);		
	}

	@Transactional(readOnly = false)
	public void deleteById(long id) {
		
		posts.deleteById(id);		
	}
}
