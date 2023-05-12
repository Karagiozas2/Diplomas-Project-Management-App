package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.Role;
import diplomas_mgt_app.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetAndGetId() {
        int id = 1;
        user.setId(id);
        Assertions.assertEquals(id, user.getId());
    }

    @Test
    public void testSetAndGetUsername() {
        String username = "username";
        user.setUsername(username);
        Assertions.assertEquals(username, user.getUsername());
    }

    @Test
    public void testSetAndGetRole() {
        Role role = Role.ADMIN;
        user.setRole(role);
        Assertions.assertEquals(role, user.getRole());
    }
}