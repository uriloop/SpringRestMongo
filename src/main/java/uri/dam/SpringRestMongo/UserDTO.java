package uri.dam.SpringRestMongo;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private int id;
    private String email;
    private String full_name;
    private String passwd;
    private List<Ticket> tickets;

    public UserDTO() {
    }

    public UserDTO(int id, String email, String passwd, String full_name, List<Ticket> tickets) {
        this.id = id;
        this.email = email;
        this.passwd= passwd;
        this.full_name = full_name;
        this.tickets = tickets;

    }
    public UserDTO(User user){
        this.id= user.getId();
        this.email=user.getEmail();
        this.passwd= user.getPassword();
        this.full_name=user.getFull_name();
        this.tickets=user.getTickets();
    }


}
