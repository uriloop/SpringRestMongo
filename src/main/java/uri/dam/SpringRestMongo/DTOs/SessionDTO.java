package uri.dam.SpringRestMongo.DTOs;

import lombok.Data;
import uri.dam.SpringRestMongo.Models.Session;
import uri.dam.SpringRestMongo.Models.Ticket;

import java.util.ArrayList;
import java.util.List;

@Data
public class SessionDTO {

    private int id;
    private String pelicula;
    private String dia;
    private String hora;
    private List<Ticket> tickets = new ArrayList<>();

    public SessionDTO() {
    }

    public SessionDTO(int id, String pelicula, String dia, String hora, List<Ticket> tickets) {
        this.id = id;
        this.pelicula = pelicula;
        this.dia = dia;
        this.hora = hora;
        this.tickets = tickets;
        if(tickets==null){
            this.tickets=new ArrayList<>();
        }
    }

    public SessionDTO(Session session) {

        this.id=session.getId();
        this.pelicula= session.getPelicula();
        this.dia= session.getDia();
        this.hora= session.getHora();
        this.tickets= session.getTickets();

    }


}
