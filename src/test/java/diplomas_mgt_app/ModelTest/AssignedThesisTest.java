package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.AssignedThesis;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignedThesisTest {
    @Test
    public void testAssignedThesis() {
        AssignedThesis assignedThesis = new AssignedThesis();
        Student student = new Student();
        Professor professor = new Professor();
        assignedThesis.setId(1);
        assignedThesis.setTitle("Thesis Title");
        assignedThesis.setStudent(student);
        assignedThesis.setProfessor(professor);
        assignedThesis.setImplementationgrade(Double.valueOf("7.0"));
        assignedThesis.setReportgrade(Double.valueOf("8.0"));
        assignedThesis.setPresentationgrade(Double.valueOf("9.0"));
        assignedThesis.setTotalgrade(Double.valueOf("8.0"));

        assertEquals(1, assignedThesis.getId());
        assertEquals("Thesis Title", assignedThesis.getTitle());
        assertEquals(student, assignedThesis.getStudent());
        assertEquals(professor, assignedThesis.getProfessor());
        assertEquals(Double.valueOf("7.0"), assignedThesis.getImplementationgrade());
        assertEquals(Double.valueOf("8.0"), assignedThesis.getReportgrade());
        assertEquals(Double.valueOf("9.0"), assignedThesis.getPresentationgrade());
        assertEquals(Double.valueOf("8.0"), assignedThesis.getTotalgrade());
    }
}