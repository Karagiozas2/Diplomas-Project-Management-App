package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.List;

public class FewestCoursesStrategy implements BestApplicantStrategy{
    public FewestCoursesStrategy() {
    }

    public int compareApplications(Application app1, Application app2) {
        return Integer.compare(app1.getStudent().getNumberofremainingcoursesforgraduation(), app2.getStudent().getNumberofremainingcoursesforgraduation());
    }

    @Override
    public Student findBestApplicant(List<Application> applications) {
        return null;
    }
}