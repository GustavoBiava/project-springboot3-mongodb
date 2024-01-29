package free.biava.springmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.biava.springmongo.entities.Post;
import free.biava.springmongo.repositories.PostRepository;
import free.biava.springmongo.services.exceptions.ResourceNotFoundExcepetion;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ResourceNotFoundExcepetion(id));
	}
}
