package diplomas_mgt_app.ServiceTest;
import diplomas_mgt_app.dao.ThesisDAO;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Thesis;
import diplomas_mgt_app.service.ThesisServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ThesisServiceImplTest {

    @Mock
    private ThesisDAO thesisDAO;

    private ThesisServiceImpl thesisService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        thesisService = new ThesisServiceImpl(thesisDAO);
    }

    @Test
    public void testFindById() {
        Thesis thesis = new Thesis();
        thesis.setId(1);
        when(thesisDAO.findById(1)).thenReturn(thesis);

        var result = thesisService.findById(1);

        assertEquals(thesis.getId(), result.getId());
        verify(thesisDAO, times(1)).findById(1);
    }

    @Test
    public void testFindByProfessorId() {
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        when(thesisDAO.findByProfessorId(1)).thenReturn(Arrays.asList(thesis1, thesis2));

        var result = thesisService.findByProfessorId(1);

        assertEquals(2, result.size());
        verify(thesisDAO, times(1)).findByProfessorId(1);
    }

    @Test
    public void testFindBySubjectId() {
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        when(thesisDAO.findBySubjectId(1)).thenReturn(Arrays.asList(thesis1, thesis2));

        var result = thesisService.findBySubjectId(1);

        assertEquals(2, result.size());
        verify(thesisDAO, times(1)).findBySubjectId(1);
    }

    @Test
    public void testFindByProfessor() {
        Professor professor = new Professor();
        Thesis thesis1 = new Thesis();
        Thesis thesis2 = new Thesis();
        when(thesisDAO.findByProfessor(professor)).thenReturn(Arrays.asList(thesis1, thesis2));

        var result = thesisService.findByProfessor(professor);

        assertEquals(2, result.size());
        verify(thesisDAO, times(1)).findByProfessor(professor);
    }

    @Test
    public void testDelete() {
        thesisService.delete(1);
        verify(thesisDAO, times(1)).deleteById(1);
    }
}