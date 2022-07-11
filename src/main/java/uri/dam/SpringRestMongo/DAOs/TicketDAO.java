package uri.dam.SpringRestMongo.DAOs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uri.dam.SpringRestMongo.Models.Ticket;

@Repository
public interface TicketDAO  extends MongoRepository<Ticket,Integer> {
}
