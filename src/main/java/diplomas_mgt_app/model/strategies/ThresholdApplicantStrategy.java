package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.Comparator;
import java.util.List;
public class ThresholdApplicantStrategy extends TemplateStrategyAlgorithm {

    private double th1;  // The average grade threshold
    private double th2;  // The remaining courses threshold

    public ThresholdApplicantStrategy(double th1, double th2) {
        this.th1 = th1;
        this.th2 = th2;
    }

    public ThresholdApplicantStrategy() {

    }

    @Override
    protected int compareApplications(Application app1, Application app2) {
        boolean app1MeetsThresholds = app1.getStudent().getCurrentaveragegrade() > th1
                && app1.getStudent().getNumberofremainingcoursesforgraduation() < th2;
        if (app1MeetsThresholds) {
            return 1;
        } else{
            return -1;
        }
    }
    @Override
    public Student findBestApplicant(List<Application> applications) {
        if (applications == null || applications.isEmpty()) {
            return null;
        }

        Application bestApplication = applications.get(0);

        for (Application application : applications) {
            int comparison = compareApplications(bestApplication, application);
            if (comparison >= 0) {
                bestApplication = application;
            } else if (comparison < 0) {
                return null;
            }
        }

        return bestApplication.getStudent();
    }
}

