package uri.dam.SpringRestMongo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uri.dam.SpringRestMongo.DAOs.SessionDAO;
import uri.dam.SpringRestMongo.DAOs.TicketDAO;
import uri.dam.SpringRestMongo.DTOs.SessionDTO;
import uri.dam.SpringRestMongo.DTOs.TicketDTO;
import uri.dam.SpringRestMongo.Models.Session;
import uri.dam.SpringRestMongo.Models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionsService {

    SessionDAO sessionDAO;

    @Autowired
    public SessionsService(SessionDAO sessionDAO) {
        this.sessionDAO=sessionDAO;
    }





    public List<SessionDTO> getSessions(){


        List<SessionDTO> sessionsDTO = new ArrayList<>();
        for (Session session : sessionDAO.findAll()) {
            SessionDTO sessionDTO = new SessionDTO(session);
            sessionsDTO.add(sessionDTO);
        }
        return sessionsDTO;


    }


    public Object getPelicula(int id) {

        Optional<Session> s=sessionDAO.findById(id);
        SessionDTO sessionDTO = null;
        if (s.isPresent()) {
             sessionDTO = new SessionDTO(s.get());
        }
        return sessionDTO;

    }


}
