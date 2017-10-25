package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    private UserDao userDao;
    private User user;


    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
    }


    @Test
    public void getAllClients() throws Exception {
        List<User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
    }


    @Test
    public void getClient() throws Exception {
        int id = 1;
        user = userDao.getUser(id);
        assertTrue("Not the user with userId " + id,
                user.getFirstName().equals("Joe")
                        && user.getLastName().equals("Coyne"));
    }


}