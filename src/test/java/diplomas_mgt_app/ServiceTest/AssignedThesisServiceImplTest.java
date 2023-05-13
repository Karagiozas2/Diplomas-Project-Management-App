package diplomas_mgt_app.ServiceTest;
import diplomas_mgt_app.dao.AssignedThesisDAO;
import diplomas_mgt_app.model.AssignedThesis;
import diplomas_mgt_app.service.AssignedThesisServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AssignedThesisServiceImplTest {

    private AssignedThesisDAO assignedThesisDAO = Mockito.mock(AssignedThesisDAO.class);
    private AssignedThesisServiceImpl service = new AssignedThesisServiceImpl(assignedThesisDAO);

    @Test
    public void testFindById() {
        AssignedThesis assignedThesis = new AssignedThesis();
        assignedThesis.setId(1);
        assignedThesis.setTitle("Thesis Title");

        when(assignedThesisDAO.findById(1)).thenReturn(assignedThesis);

        AssignedThesis found = service.findById(1);

        assertEquals(1, found.getId());
        assertEquals("Thesis Title", found.getTitle());
    }
}