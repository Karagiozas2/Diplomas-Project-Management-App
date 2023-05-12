package diplomas_mgt_app.DaoTest;

import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.model.Professor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ProfessorDAOTest {

    @Test
    void testFindById() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor = new Professor();
        Mockito.when(dao.findById(1)).thenReturn(professor);

        // Act
        Professor result = dao.findById(1);

        // Assert
        assertSame(professor, result);
    }

    @Test
    void testFindByEmail() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor = new Professor();
        Mockito.when(dao.findByEmail("test@test.com")).thenReturn(professor);

        // Act
        Professor result = dao.findByEmail("test@test.com");

        // Assert
        assertSame(professor, result);
    }

    @Test
    void testFindByUsername() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor = new Professor();
        Mockito.when(dao.findByUsername("testUsername")).thenReturn(professor);

        // Act
        Professor result = dao.findByUsername("testUsername");

        // Assert
        assertSame(professor, result);
    }

    @Test
    void testSave() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor = new Professor();
        Mockito.when(dao.save(professor)).thenReturn(professor);

        // Act
        Professor result = dao.save(professor);

        // Assert
        assertSame(professor, result);
    }

    @Test
    void testDelete() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor = new Professor();
        Mockito.doNothing().when(dao).delete(professor);

        // Act
        dao.delete(professor);

        // Assert
        Mockito.verify(dao, Mockito.times(1)).delete(professor);
    }

    @Test
    void testFindAll() {
        // Arrange
        ProfessorDAO dao = Mockito.mock(ProfessorDAO.class);
        Professor professor1 = new Professor();
        Professor professor2 = new Professor();
        List<Professor> professors = Arrays.asList(professor1, professor2);
        Mockito.when(dao.findAll()).thenReturn(professors);

        // Act
        List<Professor> results = dao.findAll();

        // Assert
        assertSame(professors, results);
    }

    
}
