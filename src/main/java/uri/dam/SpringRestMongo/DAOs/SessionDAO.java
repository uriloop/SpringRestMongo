package uri.dam.SpringRestMongo.DAOs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uri.dam.SpringRestMongo.Models.Session;

@Repository
public interface SessionDAO extends MongoRepository<Session,Integer> {
}
