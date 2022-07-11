package uri.dam.SpringRestMongo.DAOs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uri.dam.SpringRestMongo.Models.User;

@Repository
public interface UserDAO extends MongoRepository<User,Integer> {

}
