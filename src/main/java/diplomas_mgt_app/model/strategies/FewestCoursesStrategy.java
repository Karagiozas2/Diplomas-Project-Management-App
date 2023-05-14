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
        if (applications == null || applications.isEmpty()) {
            return null;
        }

        Application bestApplication = applications.get(0);

        for (Application application : applications) {

            if (compareApplications(bestApplication, application) < 0) {
                bestApplication = application;
            }
        }

        return bestApplication.getStudent();
    }

}