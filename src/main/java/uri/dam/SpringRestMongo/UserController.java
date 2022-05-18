package uri.dam.SpringRestMongo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDTO> getUsers() {

        List<UserDTO> usersDTO=userDAO.findAll().stream().map(UserDTO::new).toList();

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
}


