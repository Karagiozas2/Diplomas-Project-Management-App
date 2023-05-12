package diplomas_mgt_app.DaoTest;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationDAOTest {

    @Test
    void testFindById() {
        // Arrange
        ApplicationDAO dao = Mockito.mock(ApplicationDAO.class);
        Application application = new Application();
        Mockito.when(dao.findById(1)).thenReturn(application);

        // Act
        Application result = dao.findById(1);

        // Assert
        assertSame(application, result);
    }

    @Test
    void testFindAll() {
        // Arrange
        ApplicationDAO dao = Mockito.mock(ApplicationDAO.class);
        Application application1 = new Application();
        Application application2 = new Application();
        List<Application> applications = Arrays.asList(application1, application2);
        Mockito.when(dao.findAll()).thenReturn(applications);

        // Act
        List<Application> results = dao.findAll();

        // Assert
        assertSame(applications, results);
    }

    @Test
    void testFindByStudent() {
        // Arrange
        ApplicationDAO dao = Mockito.mock(ApplicationDAO.class);
        Student student = new Student();
        Application application1 = new Application();
        Application application2 = new Application();
        List<Application> applications = Arrays.asList(application1, application2);
        Mockito.when(dao.findByStudent(student)).thenReturn(applications);

        // Act
        List<Application> results = dao.findByStudent(student);

        // Assert
        assertSame(applications, results);
    }

    @Test
    void testFindAllByThesisId() {
        // Arrange
        ApplicationDAO dao = Mockito.mock(ApplicationDAO.class);
        Application application1 = new Application();
        Application application2 = new Application();
        List<Application> applications = Arrays.asList(application1, application2);
        Mockito.when(dao.findAllByThesisId(1)).thenReturn(applications);

        // Act
        List<Application> results = dao.findAllByThesisId(1);

        // Assert
        assertSame(applications, results);
    }
}
