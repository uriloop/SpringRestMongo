package uri.dam.SpringRestMongo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tickets")
public class Ticket {


    @Id
    private int id;
    private String seient;
    private String hora;


    public Ticket() {
    }

    public Ticket(int id, String seient, String hora) {
        this.id = id;
        this.seient = seient;
        this.hora = hora;

    }

    public Ticket(TicketDTO ticketDTO) {
        this.id = ticketDTO.getId();
        this.seient = ticketDTO.getSeient();
        this.hora = ticketDTO.getHora();

    }


}
