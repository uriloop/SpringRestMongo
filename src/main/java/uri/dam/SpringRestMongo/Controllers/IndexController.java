package uri.dam.SpringRestMongo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uri.dam.SpringRestMongo.Services.SessionsService;

@Controller
public class IndexController {


    SessionsService sessionsService;

    @Autowired
    public IndexController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @GetMapping("/home")
    public String getHomepage(Model model){

        model.addAttribute("sessions", sessionsService.getSessions());

        return "index";
    }

}
