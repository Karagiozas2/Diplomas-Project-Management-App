package diplomas_mgt_app.DaoTest;
import diplomas_mgt_app.dao.ThesisDAO;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Thesis;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ThesisDAOTest {

    @Test
    void testFindById() {
        // Arrange
        ThesisDAO dao = Mockito.mock(ThesisDAO.class);
        Thesis thesis = new Thesis();
        Mockito.when(dao.findById(1)).thenReturn(thesis);

        // Act
        Thesis result = dao.findById(1);

        // Assert
        assertSame(thesis, result);
    }

    @Test
    void testFindByProfessorId() {
        // Arrange
        ThesisDAO dao = Mockito.mock(ThesisDAO.class);
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        List<Thesis> theses = Arrays.asList(thesis1, thesis2);
        Mockito.when(dao.findByProfessorId(1)).thenReturn(theses);

        // Act
        List<Thesis> results = dao.findByProfessorId(1);

        // Assert
        assertSame(theses, results);
    }

    @Test
    void testFindBySubjectId() {
        // Arrange
        ThesisDAO dao = Mockito.mock(ThesisDAO.class);
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        List<Thesis> theses = Arrays.asList(thesis1, thesis2);
        Mockito.when(dao.findBySubjectId(1)).thenReturn(theses);

        // Act
        List<Thesis> results = dao.findBySubjectId(1);

        // Assert
        assertSame(theses, results);
    }

    @Test
    void testSave() {
        // Arrange
        ThesisDAO dao = Mockito.mock(ThesisDAO.class);
        Professor professor = new Professor();
        Mockito.doNothing().when(dao).save(professor);

        // Act
        dao.save(professor);

        // Assert
        Mockito.verify(dao, Mockito.times(1)).save(professor);
    }

    @Test
    void testFindByProfessor() {
        // Arrange
        ThesisDAO dao = Mockito.mock(ThesisDAO.class);
        Professor professor = new Professor();
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        List<Thesis> theses = Arrays.asList(thesis1, thesis2);
        Mockito.when(dao.findByProfessor(professor)).thenReturn(theses);

        // Act
        List<Thesis> results = dao.findByProfessor(professor);

        // Assert
        assertSame(theses, results);
    }
}
