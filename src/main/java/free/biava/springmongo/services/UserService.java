package free.biava.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoDataIntegrityViolationException;
import org.springframework.stereotype.Service;

import free.biava.springmongo.dto.UserDTO;
import free.biava.springmongo.entities.User;
import free.biava.springmongo.repositories.UserRepository;
import free.biava.springmongo.services.exceptions.DatabaseException;
import free.biava.springmongo.services.exceptions.ResourceNotFoundExcepetion;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundExcepetion(id));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		if(repository.existsById(id)) {
			try {
				repository.deleteById(id);		
			}
			catch(MongoDataIntegrityViolationException error) {
				throw new DatabaseException(error.getMessage());
			}
		}
		else {
			throw new ResourceNotFoundExcepetion(id);
		}
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
