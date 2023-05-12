package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    public void testStudentMethods() {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Alice");
        student.setLastName("Smith");
        student.setEmail("cs04444@uoi.gr");
        student.setYearofstudies(6);
        student.setCurrentaveragegrade(5.5);
        student.setNumberofremainingcoursesforgraduation(5);
        student.setUsername("cs04444");

        assertEquals(1, student.getId());
        assertEquals("Alice", student.getFirstName());
        assertEquals("Smith", student.getLastName());
        assertEquals("cs04444@uoi.gr", student.getEmail());
        assertEquals(6, student.getYearofstudies());
        assertEquals(5.5, student.getCurrentaveragegrade());
        assertEquals(5, student.getNumberofremainingcoursesforgraduation());
        assertEquals("cs04444", student.getUsername());
    }
}