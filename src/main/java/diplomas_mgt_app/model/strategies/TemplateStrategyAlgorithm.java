package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.List;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy {
    public TemplateStrategyAlgorithm() {
    }

    public Student findBestApplicant(List<Application> applications) {
        Application bestApp = null;
        for (Application app : applications) {
            if (bestApp == null || compareApplications(app, bestApp) > 0) {
                bestApp = app;
            }
        }
        return bestApp != null ? bestApp.getStudent() : null;
    }
    protected abstract int compareApplications(Application app1, Application app2);
}
