package free.biava.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import free.biava.springmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
