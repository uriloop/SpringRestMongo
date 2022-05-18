package uri.dam.SpringRestMongo;

import lombok.Data;

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
