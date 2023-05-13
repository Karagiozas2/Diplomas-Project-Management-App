package diplomas_mgt_app.ServiceTest;

import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Subject;
import diplomas_mgt_app.service.SubjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class SubjectServiceImplTest {

    @Mock
    private SubjectDAO subjectDAO;

    private SubjectServiceImpl subjectService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        subjectService = new SubjectServiceImpl(subjectDAO);
    }

    @Test
    public void testSave() {
        Subject subject = new Subject();
        subjectService.save(subject);
        verify(subjectDAO, times(1)).save(subject);
    }

    @Test
    public void testFindAll() {
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();
        when(subjectDAO.findAll()).thenReturn(Arrays.asList(subject1, subject2));

        var result = subjectService.findAll();

        assertEquals(2, result.size());
        verify(subjectDAO, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Subject subject = new Subject();
        subject.setId(1);
        when(subjectDAO.findById(1)).thenReturn(Optional.of(subject));
        var result = subjectService.findById(1);
        assertEquals(subject.getId(), result.getId());
        verify(subjectDAO, times(1)).findById(1);
    }
}