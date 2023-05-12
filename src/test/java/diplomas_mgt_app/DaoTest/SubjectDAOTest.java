package diplomas_mgt_app.DaoTest;
import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Subject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SubjectDAOTest {

    @Test
    void testFindById() {
        // Arrange
        SubjectDAO dao = Mockito.mock(SubjectDAO.class);
        Subject subject = new Subject();
        Mockito.when(dao.findById(1)).thenReturn(subject);

        // Act
        Subject result = dao.findById(1);

        // Assert
        assertSame(subject, result);
    }

    @Test
    void testFindByProfessor() {
        // Arrange
        SubjectDAO dao = Mockito.mock(SubjectDAO.class);
        Professor professor = new Professor();
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();
        List<Subject> subjects = Arrays.asList(subject1, subject2);
        Mockito.when(dao.findByProfessor(professor)).thenReturn(subjects);

        // Act
        List<Subject> results = dao.findByProfessor(professor);

        // Assert
        assertSame(subjects, results);
    }

    @Test
    void testFindByIdAndProfessor() {
        // Arrange
        SubjectDAO dao = Mockito.mock(SubjectDAO.class);
        Professor professor = new Professor();
        Subject subject = new Subject();
        Mockito.when(dao.findByIdAndProfessor(1, professor)).thenReturn(subject);

        // Act
        Subject result = dao.findByIdAndProfessor(1, professor);

        // Assert
        assertSame(subject, result);
    }

    @Test
    void testSave() {
        // Arrange
        SubjectDAO dao = Mockito.mock(SubjectDAO.class);
        Professor professor = new Professor();
        Mockito.doNothing().when(dao).save(professor);

        // Act
        dao.save(professor);

        // Assert
        Mockito.verify(dao, Mockito.times(1)).save(professor);
    }

    @Test
    void testFindAll() {
        // Arrange
        SubjectDAO dao = Mockito.mock(SubjectDAO.class);
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();
        List<Subject> subjects = Arrays.asList(subject1, subject2);
        Mockito.when(dao.findAll()).thenReturn(subjects);

        // Act
        List<Subject> results = dao.findAll();

        // Assert
        assertSame(subjects, results);
    }
}
