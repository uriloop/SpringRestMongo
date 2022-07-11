package uri.dam.SpringRestMongo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uri.dam.SpringRestMongo.Models.Ticket;
import uri.dam.SpringRestMongo.DAOs.TicketDAO;
import uri.dam.SpringRestMongo.DTOs.TicketDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketController {

    TicketDAO ticketDAO;

    @Autowired
    public TicketController(TicketDAO ticketDAO) {
        this.ticketDAO=ticketDAO;
    }


    public List<TicketDTO> getTickets() {
        List<TicketDTO> ticketsDTO = new ArrayList<>();
        for (Ticket ticket : ticketDAO.findAll()) {
            TicketDTO ticketDTO = new TicketDTO(ticket);
            ticketsDTO.add(ticketDTO);
        }
        return ticketsDTO;
    }


    public void addTicket(TicketDTO ticketDTO) {
        Ticket ticket= new Ticket(ticketDTO);
        Ticket t= new Ticket(ticketDTO);
        ticketDAO.save(t);
    }


    public void deleteTicket(Integer id) {
        ticketDAO.deleteById(id);

    }

}
