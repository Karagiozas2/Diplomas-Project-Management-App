package diplomas_mgt_app.model.strategies;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;
import java.util.List;

public interface BestApplicantStrategy {

    Student findBestApplicant(List<Application> applications);
}