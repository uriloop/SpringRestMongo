package uri.dam.SpringRestMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDAO  extends MongoRepository<Ticket,Integer> {
}