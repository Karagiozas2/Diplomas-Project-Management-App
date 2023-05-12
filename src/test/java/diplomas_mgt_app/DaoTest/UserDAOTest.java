package diplomas_mgt_app.DaoTest;
import diplomas_mgt_app.dao.UserDAO;
import diplomas_mgt_app.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void testFindByUsername() {
        // Arrange
        UserDAO dao = Mockito.mock(UserDAO.class);
        User user = new User();
        Mockito.when(dao.findByUsername("testUsername")).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = dao.findByUsername("testUsername");

        // Assert
        assertTrue(result.isPresent());
        assertSame(user, result.get());
    }

    @Test
    void testSave() {
        // Arrange
        UserDAO dao = Mockito.mock(UserDAO.class);
        User user = new User();
        Mockito.when(dao.save(user)).thenReturn(user);

        // Act
        User result = dao.save(user);

        // Assert
        assertSame(user, result);
    }

    @Test
    void testDelete() {
        // Arrange
        UserDAO dao = Mockito.mock(UserDAO.class);
        User user = new User();
        Mockito.doNothing().when(dao).delete(user);

        // Act
        dao.delete(user);

        // Assert
        Mockito.verify(dao, Mockito.times(1)).delete(user);
    }

    @Test
    void testFindAll() {
        // Arrange
        UserDAO dao = Mockito.mock(UserDAO.class);
        User user1 = new User();
        User user2 = new User();
        List<User> users = Arrays.asList(user1, user2);
        Mockito.when(dao.findAll()).thenReturn(users);

        // Act
        List<User> results = dao.findAll();

        // Assert
        assertSame(users, results);
    }

    @Test
    void testFindByIdOptional() {
        // Arrange
        UserDAO dao = Mockito.mock(UserDAO.class);
        User user = new User();
        Mockito.when(dao.findById(1)).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = dao.findById(1);

        // Assert
        assertTrue(result.isPresent());
        assertSame(user, result.get());
    }
}
