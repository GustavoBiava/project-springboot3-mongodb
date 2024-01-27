package free.biava.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import free.biava.springmongo.entities.User;
import free.biava.springmongo.repositories.UserRepository;

@Configuration
public class DatabaseSeeding implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User user = new User(null, "Ronaldo", "cristiano@gmail.com");
		User user2 = new User(null, "Messi", "lional@gmail.com");
		User user3 = new User(null, "Mbappé", "kylian@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user, user2, user3));
		
	}

}
