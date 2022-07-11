package uri.dam.SpringRestMongo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uri.dam.SpringRestMongo.DTOs.UserDTO;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "users")
public class User {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
    private int id;
    private String email;
    private String password;
    private String full_name;
    private List<Ticket> tickets = new ArrayList<>();


    public User() {
    }

    public User(int id, String email, String passwd, String full_name, List<Ticket> tickets) {
        this.id = id;
        this.email = email;
        this.password = passwd;
        this.full_name = full_name;
        this.tickets = tickets;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPasswd();
        this.full_name = userDTO.getFull_name();
        this.tickets = userDTO.getTickets();
    }


}
