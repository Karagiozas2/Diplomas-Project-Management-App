package diplomas_mgt_app.DaoTest;

import diplomas_mgt_app.dao.StudentDAO;
import diplomas_mgt_app.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @Test
    void testFindById() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student = new Student();
        Mockito.when(dao.findById(1)).thenReturn(student);

        // Act
        Student result = dao.findById(1);

        // Assert
        assertSame(student, result);
    }

    @Test
    void testFindByEmail() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student = new Student();
        Mockito.when(dao.findByEmail("test@test.com")).thenReturn(student);

        // Act
        Student result = dao.findByEmail("test@test.com");

        // Assert
        assertSame(student, result);
    }

    @Test
    void testFindByUsername() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student = new Student();
        Mockito.when(dao.findByUsername("testUsername")).thenReturn(student);

        // Act
        Student result = dao.findByUsername("testUsername");

        // Assert
        assertSame(student, result);
    }

    @Test
    void testSave() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student = new Student();
        Mockito.when(dao.save(student)).thenReturn(student);

        // Act
        Student result = dao.save(student);

        // Assert
        assertSame(student, result);
    }

    @Test
    void testDelete() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student = new Student();
        Mockito.doNothing().when(dao).delete(student);

        // Act
        dao.delete(student);

        // Assert
        Mockito.verify(dao, Mockito.times(1)).delete(student);
    }

    @Test
    void testFindAll() {
        // Arrange
        StudentDAO dao = Mockito.mock(StudentDAO.class);
        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> students = Arrays.asList(student1, student2);
        Mockito.when(dao.findAll()).thenReturn(students);

        // Act
        List<Student> results = dao.findAll();

        // Assert
        assertSame(students, results);
    }


}
