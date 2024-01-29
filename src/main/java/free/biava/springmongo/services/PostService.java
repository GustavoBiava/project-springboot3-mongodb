package free.biava.springmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitle(text);
	}
	
	public List<Post> testSearch(String text, Instant minDate, Instant maxDate) {
		maxDate = maxDate.plus(1, ChronoUnit.DAYS);
		return repository.testSearch(text, minDate, maxDate);
	}
}
