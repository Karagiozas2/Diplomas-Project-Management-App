package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SubjectTest {
    private Subject subject;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
    }

    @Test
    public void testSetAndGetId() {
        int id = 1;
        subject.setId(id);
        Assertions.assertEquals(id, subject.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Subject name";
        subject.setName(name);
        Assertions.assertEquals(name, subject.getName());
    }
}