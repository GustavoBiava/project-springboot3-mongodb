package free.biava.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import free.biava.springmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
