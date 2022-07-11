package uri.dam.SpringRestMongo.DTOs;

import lombok.Data;
import uri.dam.SpringRestMongo.Models.Ticket;

@Data
public class TicketDTO {



    private int id;
    private String seient;
    private String hora;


    public TicketDTO() {
    }

    public TicketDTO(int id, String seient, String hora, Integer userId) {
        this.id = id;
        this.seient = seient;
        this.hora= hora;
    }
    public TicketDTO(Ticket ticket){
        this.id= ticket.getId();
        this.seient=ticket.getSeient();
        this.hora= ticket.getHora();
    }
}
