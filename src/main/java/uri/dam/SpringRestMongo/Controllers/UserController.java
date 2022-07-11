package uri.dam.SpringRestMongo.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uri.dam.SpringRestMongo.DAOs.UserDAO;
import uri.dam.SpringRestMongo.DTOs.TicketDTO;
import uri.dam.SpringRestMongo.DTOs.UserDTO;
import uri.dam.SpringRestMongo.Models.Ticket;
import uri.dam.SpringRestMongo.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDTO> getUsers() {

        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : userDAO.findAll()) {
            UserDTO userDTO = new UserDTO(user);
            usersDTO.add(userDTO);
        }

        return usersDTO;

    }

    public void addUser(UserDTO userDTO) {

        User u= new User(userDTO);
        userDAO.save(u);
    }

    public UserDTO getUser(Integer id) {

        Optional<User> u = userDAO.findById(id);
        if (u.isPresent()){
            return new UserDTO(u.get());

        }
        return null;
    }

    public void deleteUser(Integer id) {

        User u= new User();
        u.setId(id);
        userDAO.deleteById(id);
    }

    public void updateUser(Integer id, UserDTO userDTO) {
        Optional<User> u = userDAO.findById(id);

        User user= new User(userDTO);
        if (u.isPresent()) {
            User us = u.get();
            us.setEmail(user.getEmail());
            us.setPassword(user.getPassword());
            us.setFull_name(user.getFull_name());
            userDAO.save(us);

        }


    }

    public void updateUser(User userPatched) {
        userDAO.save(userPatched);
    }

    public void patch(JsonPatch patch, Integer id) throws JsonPatchException, JsonProcessingException {
        Optional<User> u = userDAO.findById(id);
        User userPatched = applyPatchToUser(patch, u.get());
        userDAO.save(userPatched);
    }

    private User applyPatchToUser(JsonPatch patch, User user) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode patched = patch.apply(objectMapper.convertValue(user, JsonNode.class));
        return objectMapper.treeToValue(patched, User.class);
    }

    public void addTicket(TicketDTO ticket, Integer id) {
        Optional<User> u = userDAO.findById(id);

        if (u.isPresent()) {
            User us = u.get();
            us.getTickets().add(new Ticket(ticket));
            userDAO.save(us);
        }


    }
}


