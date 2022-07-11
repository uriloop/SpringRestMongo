package uri.dam.SpringRestMongo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uri.dam.SpringRestMongo.Services.SessionsService;

@Controller
public class PeliculaController {

    SessionsService sessionsService;

    @Autowired
    public PeliculaController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @GetMapping("/pelicula/{id}")
    public String getPelicula(Model model, @PathVariable int id){

        model.addAttribute("sessio", sessionsService.getPelicula(id));

        return "sessio";
    }



}
