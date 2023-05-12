package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.Comparator;
import java.util.List;

public class FewestCoursesStrategy extends TemplateStrategyAlgorithm {
    @Override
    protected int compareApplications(Application app1, Application app2) {
        return Integer.compare(app1.getStudent().getNumberofremainingcoursesforgraduation(), app2.getStudent().getNumberofremainingcoursesforgraduation());
    }

    @Override
    public Student findBestApplicant(List<Application> applications) {
        return applications.stream()
                .max(this::compareApplications) // Use compareApplications here.
                .map(Application::getStudent)
                .orElse(null);
    }
}