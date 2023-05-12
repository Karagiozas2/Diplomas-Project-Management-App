package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.Professor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessorTest {
    @Test
    public void testProfessorMethods() {
        Professor professor = new Professor();
        professor.setId(1);
        professor.setFirstName("John");
        professor.setLastName("Doe");
        professor.setEmail("cs01234@uoi.gr");
        professor.setSpecialty("Software Engineer");
        professor.setUsername("cs01234");

        assertEquals(1, professor.getId());
        assertEquals("John", professor.getFirstName());
        assertEquals("Doe", professor.getLastName());
        assertEquals("cs01234@uoi.gr", professor.getEmail());
        assertEquals("Software Engineer", professor.getSpecialty());
        assertEquals("cs01234", professor.getUsername());
    }
}