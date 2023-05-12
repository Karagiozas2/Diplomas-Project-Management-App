package diplomas_mgt_app.ModelTest;
import diplomas_mgt_app.model.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    private Application application;

    @BeforeEach
    public void setUp() {
        application = new Application();
    }

    @Test
    public void testSetAndGetId() {
        int id = 1;
        application.setId(id);
        Assertions.assertEquals(id, application.getId());
    }

    @Test
    public void testSetAndGetStatus() {
        String status = "APPROVED";
        application.setStatus(status);
        Assertions.assertEquals(status, application.getStatus());
    }
}