package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.List;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy {
    public TemplateStrategyAlgorithm() {
    }

    public abstract Student findBestApplicant(List<Application> applications);
    protected abstract int compareApplications(Application app1, Application app2);
}
