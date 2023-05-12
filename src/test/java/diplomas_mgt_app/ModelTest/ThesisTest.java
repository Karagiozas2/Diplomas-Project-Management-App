package diplomas_mgt_app.ModelTest;

import diplomas_mgt_app.model.Thesis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThesisTest {
    private Thesis thesis;

    @BeforeEach
    public void setUp() {
        thesis = new Thesis();
    }

    @Test
    public void testSetAndGetId() {
        int id = 1;
        thesis.setId(id);
        Assertions.assertEquals(id, thesis.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        String title = "Thesis title";
        thesis.setTitle(title);
        Assertions.assertEquals(title, thesis.getTitle());
    }
}