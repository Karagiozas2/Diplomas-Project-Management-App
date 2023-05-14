package diplomas_mgt_app.model.strategies;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomApplicantStrategy extends TemplateStrategyAlgorithm{


    public Student findBestApplicant(List<Application> applications) {

        if (applications == null || applications.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(applications.size());
        return applications.get(randomIndex).getStudent();
    }

    @Override
    protected int compareApplications(Application app1, Application app2) {
        return 0;
    }
}