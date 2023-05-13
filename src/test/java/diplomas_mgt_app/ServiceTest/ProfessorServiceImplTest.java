package diplomas_mgt_app.ServiceTest;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.dao.ThesisDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Subject;
import diplomas_mgt_app.model.Thesis;
import diplomas_mgt_app.service.ProfessorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ProfessorServiceImplTest {

    @InjectMocks
    private ProfessorServiceImpl professorService;

    @Mock
    private ProfessorDAO professorDAO;

    @Mock
    private SubjectDAO subjectDAO;

    @Mock
    private ApplicationDAO applicationDAO;

    @Mock
    private ThesisDAO thesisDAO;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        when(professorDAO.findAll()).thenReturn(Collections.singletonList(new Professor()));
        List<Professor> professors = professorService.findAll();
        assertEquals(1, professors.size());
    }

    @Test
    public void testFindById() {
        Professor professor = new Professor();
        when(professorDAO.findById(anyInt())).thenReturn(professor);
        Professor result = professorService.findById(1);
        assertNotNull(result);
    }

    @Test
    public void testSave() {
        Professor professor = new Professor();
        professorService.save(professor);
        verify(professorDAO, times(1)).save(professor);
    }

    @Test
    public void testDeleteById() {
        professorService.deleteById(1);
        verify(professorDAO, times(1)).deleteById(1);
    }


    @Test
    public void testRetrieveProfile() {
        Professor professor = new Professor();
        when(professorDAO.findByEmail(anyString())).thenReturn(professor);
        Professor result = professorService.retrieveProfile("email");
        assertNotNull(result);
    }

    @Test
    public void testFindByUsername() {
        Professor professor = new Professor();
        when(professorDAO.findByUsername(anyString())).thenReturn(professor);
        Professor result = professorService.findByUsername("username");
        assertNotNull(result);
    }

    @Test
    public void testSaveProfile() {
        Professor professor = new Professor();
        professorService.saveProfile(professor);
        verify(professorDAO, times(1)).save(professor);
    }



}