package uri.dam.SpringRestMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection="users")
public class User {

    @Id
    private  int id;
    private  String email;
    private  String password;
    private  String full_name;



    public User() {
    }

    public User(int id, String email, String passwd, String full_name) {
        this.id = id;
        this.email = email;
        this.password = passwd;
        this.full_name = full_name;

    }

    public User(UserDTO userDTO){
        this.id= userDTO.getId();
        this.email= userDTO.getEmail();
        this.password= userDTO.getPasswd();
        this.full_name= userDTO.getFull_name();

    }


}
