package uri.dam.SpringRestMongo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserResource.USER_RESOURCE)
public class UserResource {

    UserController userController;
    public static final String USER_RESOURCE = "/u";

    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users")  // llistem
    public List<UserDTO> users() {
        return userController.getUsers();

    }


    @GetMapping("{id}")   //  demanem un en concret               #  localhost:8081/u/1
    public UserDTO getUser(@PathVariable("id") Integer id) {

        return userController.getUser(id);

    }

    @GetMapping("{id}/email")    // demanem un atribut concret d'un element concret
    public Map<String, String> getEmail(@PathVariable("id") Integer id) {
        return Collections.singletonMap("email", userController.getUser(id).getEmail());

    }


    @PostMapping("/users")    // afegim un element
    public UserDTO addUser(@RequestBody UserDTO user) {
        userController.addUser(user);
        return user;
    }

    @PostMapping("{id}")    // afegim un element
    public void addTicket(@PathVariable Integer id,@RequestBody TicketDTO ticket) {
        userController.addTicket(ticket,id);
    }


    @DeleteMapping("{id}")      // esborrem un element concret
    public void deleteUser(@PathVariable("id") Integer id) {
        userController.deleteUser(id);

    }

    @PutMapping("{id}")         // actualitzem els atributs d'un element concret
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO user) {
        userController.updateUser(id, user);
    }


    @PatchMapping(path = "{id}")     // realitzem totes les operacions CRUD anteriors passant-li un json amb la operació, atributs, valors
    public void updateUserPatch(
            @RequestBody JsonPatch patch, @PathVariable("id") Integer id) throws JsonPatchException, JsonProcessingException {
        userController.patch(patch,id);

    }


}

