package diplomas_mgt_app.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.service.ApplicationService;
import diplomas_mgt_app.service.ApplicationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationDAO applicationDAO;

    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @BeforeEach
    public void setUp() {
        applicationService = new ApplicationServiceImpl(applicationDAO);
    }

    @Test
    @Transactional
    public void testSave() {
        Application application = new Application();
        applicationService.save(application);
        verify(applicationDAO, times(1)).save(application);
    }

    @Test
    public void testFindAll() {
        Application app1 = new Application();
        Application app2 = new Application();
        when(applicationDAO.findAll()).thenReturn(Arrays.asList(app1, app2));
        List<Application> result = applicationService.findAll();
        verify(applicationDAO, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindAllByThesisId() {
        Integer thesisId = 1;
        Application app1 = new Application();
        Application app2 = new Application();
        when(applicationDAO.findAllByThesisId(thesisId)).thenReturn(Arrays.asList(app1, app2));
        List<Application> result = applicationService.findAllByThesisId(thesisId);
        verify(applicationDAO, times(1)).findAllByThesisId(thesisId);
        assertEquals(2, result.size());
    }

    @Test
    @Transactional
    public void testFindById() {
        Integer id = 1;
        Application application = new Application();
        when(applicationDAO.findById(id)).thenReturn(Optional.of(application));
        Application result = applicationService.findById(id);
        verify(applicationDAO, times(1)).findById(id);
        assertEquals(application, result);
    }

    @Test
    @Transactional
    public void testFindByIdNotFound() {
        Integer id = 1;
        when(applicationDAO.findById(id)).thenReturn(Optional.empty());
        Application result = applicationService.findById(id);
        verify(applicationDAO, times(1)).findById(id);
        assertNull(result);
    }
}