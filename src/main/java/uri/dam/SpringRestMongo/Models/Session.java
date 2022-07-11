package uri.dam.SpringRestMongo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uri.dam.SpringRestMongo.DTOs.SessionDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Document(collection = "sessions")
public class Session {

    @Id
    private int id;
    private String pelicula;
    private String dia;
    private String hora;
    private List<Ticket> tickets= new ArrayList<>();

    public Session() {
    }

    public Session(SessionDTO sessionDTO) {
        this.id = sessionDTO.getId();
        this.pelicula= sessionDTO.getPelicula();
        this.dia= sessionDTO.getDia();
        this.hora= sessionDTO.getHora();
        this.tickets= sessionDTO.getTickets();

    }
}
