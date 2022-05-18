package uri.dam.SpringRestMongo;

import lombok.Data;

@Data
public class UserDTO {



    private int id;
    private String email;
    private String full_name;
    private String passwd;


    public UserDTO() {
    }

    public UserDTO(int id, String email, String passwd, String full_name) {
        this.id = id;
        this.email = email;
        this.passwd= passwd;
        this.full_name = full_name;

    }
    public UserDTO(User user){
        this.id= user.getId();
        this.email=user.getEmail();
        this.passwd= user.getPassword();
        this.full_name=user.getFull_name();
    }

}
