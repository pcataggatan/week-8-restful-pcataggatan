package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/users")
public class UserList {

    UserDao userDao = new UserDao();
    String jsonString = null;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {

        List<User> users = userDao.getAllUsers();

        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(users);
        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(jsonString).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageWithParm(@PathParam("id") int userId) {

        User user = userDao.getUser(userId);

        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(user);
        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(jsonString).build();
    }

}
