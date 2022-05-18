package uri.dam.SpringRestMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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




}
