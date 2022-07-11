package uri.dam.SpringRestMongo.Resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uri.dam.SpringRestMongo.Controllers.SessionController;
import uri.dam.SpringRestMongo.DTOs.SessionDTO;
import uri.dam.SpringRestMongo.DTOs.UserDTO;

@RestController
@RequestMapping(SessionResource.SESSION_RESOURCE)
public class SessionResource {
    public static final String SESSION_RESOURCE = "/s";

    SessionController sessionController;

    @Autowired
    public SessionResource(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    @PostMapping("/sessions")    // afegim un usuari
    public SessionDTO addSession(@RequestBody SessionDTO sessionDTO) {
        sessionController.addSession(sessionDTO);
        return sessionDTO;
    }

}
