package uri.dam.SpringRestMongo.Resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uri.dam.SpringRestMongo.Controllers.TicketController;
import uri.dam.SpringRestMongo.DTOs.TicketDTO;

import java.util.List;

@RestController
@RequestMapping(TicketResource.TICKET_RESOURCE )
public class TicketResource {

    TicketController ticketController;

    public static final String TICKET_RESOURCE = "/t";

    @Autowired
    public TicketResource(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    @GetMapping("/tickets")  // llistem
    public List<TicketDTO> tickets() {
        return ticketController.getTickets();

    }

    @PostMapping("/tickets")    // afegim un element
    public TicketDTO addTicket(@RequestBody TicketDTO ticket) {
        ticketController.addTicket(ticket);
        return ticket;
    }

    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable("id") Integer id){
        ticketController.deleteTicket(id);
    }


}
