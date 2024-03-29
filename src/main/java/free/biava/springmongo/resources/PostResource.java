package free.biava.springmongo.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import free.biava.springmongo.entities.Post;
import free.biava.springmongo.resources.util.URL;
import free.biava.springmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/searchtitle")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParameter(text);
		return ResponseEntity.ok().body(service.findByTitle(text));
	}
	
	@GetMapping(value = "/testsearch")
	public ResponseEntity<List<Post>> testSearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = URL.decodeParameter(text);
		Instant min = URL.convertDate(minDate, Instant.parse("1970-01-01T00:00:00Z"));
		Instant max = URL.convertDate(maxDate, Instant.now());
		return ResponseEntity.ok().body(service.testSearch(text, min, max));
	}
}
