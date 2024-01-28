package free.biava.springmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import free.biava.springmongo.dto.AuthorDTO;
import free.biava.springmongo.entities.Post;
import free.biava.springmongo.entities.User;
import free.biava.springmongo.repositories.PostRepository;
import free.biava.springmongo.repositories.UserRepository;

@Configuration
public class DatabaseSeeding implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user = new User(null, "Ronaldo", "cristiano@gmail.com");
		User user2 = new User(null, "Messi", "lional@gmail.com");
		User user3 = new User(null, "Mbappé", "kylian@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user, user2, user3));
		
		Post post = new Post(null, Instant.now(), "Partiu Miami!", "Hoje é o dia da viagem para Miami para os amistosos de pré-temporada! Siuu", new AuthorDTO(user));
		Post post2 = new Post(null, Instant.now(), "Esqueci minhas chuteiras!", "Lembrei-me agora que minhas chuteiras ficaram no CT do clube! Terei que dar um jeito", new AuthorDTO(user));
		

		postRepository.saveAll(Arrays.asList(post, post2));
		
	}

}
