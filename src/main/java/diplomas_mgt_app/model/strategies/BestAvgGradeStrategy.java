package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.List;

public class BestAvgGradeStrategy implements BestApplicantStrategy{
    public BestAvgGradeStrategy() {
    }

    public int compareApplications(Application app1, Application app2) {
        return Integer.compare(app2.getStudent().getCurrentaveragegrade(), app1.getStudent().getCurrentaveragegrade());
    }

    @Override
    public Student findBestApplicant(List<Application> applications) {
        return null;
    }
}