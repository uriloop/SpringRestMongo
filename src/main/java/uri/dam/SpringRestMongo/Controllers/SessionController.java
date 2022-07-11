package uri.dam.SpringRestMongo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uri.dam.SpringRestMongo.DAOs.SessionDAO;
import uri.dam.SpringRestMongo.DTOs.SessionDTO;
import uri.dam.SpringRestMongo.Models.Session;

@Controller
public class SessionController {


    SessionDAO sessionDAO;

    @Autowired
    public SessionController(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    public void addSession(SessionDTO sessionDTO){

        Session s= new Session(sessionDTO);

        sessionDAO.insert(s);

    }

}
