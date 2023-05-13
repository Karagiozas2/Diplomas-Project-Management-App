package diplomas_mgt_app.DaoTest;

import diplomas_mgt_app.dao.AssignedThesisDAO;
import diplomas_mgt_app.model.AssignedThesis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AssignedThesisDAOTest {

    @Autowired
    private AssignedThesisDAO assignedThesisDAO;

    @Test
    public void testFindById() {
        AssignedThesis assignedThesis = new AssignedThesis();
        assignedThesis.setId(1);
        assignedThesis.setTitle("Thesis Title");

        assignedThesisDAO.save(assignedThesis);

        AssignedThesis found = assignedThesisDAO.findById(1);

        assertEquals(1, found.getId());
        assertEquals("Thesis Title", found.getTitle());
    }
}