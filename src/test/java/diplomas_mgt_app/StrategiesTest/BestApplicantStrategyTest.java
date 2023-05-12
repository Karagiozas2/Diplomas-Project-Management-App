package diplomas_mgt_app.StrategiesTest;

import diplomas_mgt_app.model.*;
import diplomas_mgt_app.model.strategies.BestAvgGradeStrategy;
import diplomas_mgt_app.model.strategies.FewestCoursesStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class BestApplicantStrategyTest {

    @Test
    public void testBestAvgGradeStrategy() {
        BestAvgGradeStrategy strategy = new BestAvgGradeStrategy();
        Professor professor1 = new Professor(1);
        Subject subject1 = new Subject(1);
        Student student1 = new Student(1,3.5,4);
        Thesis thesis1 = new Thesis(1,professor1,subject1);
        Application app1 = new Application(1,student1,thesis1);

        Professor professor2 = new Professor(2);
        Subject subject2 = new Subject(2);
        Student student2 = new Student(2,4.5,9);
        Thesis thesis2 = new Thesis(2,professor2,subject2);
        Application app2 = new Application(2,student2,thesis2);

        List<Application> applications = Arrays.asList(app1, app2);
        Student bestStudent = strategy.findBestApplicant(applications);

        Assertions.assertEquals(4.5, bestStudent.getCurrentaveragegrade());
    }

    @Test
    public void testFewestCoursesStrategy() {
        FewestCoursesStrategy strategy = new FewestCoursesStrategy();
        Professor professor1 = new Professor(1);
        Subject subject1 = new Subject(1);
        Student student1 = new Student(1,3.5,4);
        Thesis thesis1 = new Thesis(1,professor1,subject1);
        Application app1 = new Application(1,student1,thesis1);

        Professor professor2 = new Professor(2);
        Subject subject2 = new Subject(2);
        Student student2 = new Student(2,4.5,9);
        Thesis thesis2 = new Thesis(2,professor2,subject2);
        Application app2 = new Application(2,student2,thesis2);

        List<Application> applications = Arrays.asList(app1, app2);
        Student bestStudent = strategy.findBestApplicant(applications);

        Assertions.assertEquals(4, bestStudent.getNumberofremainingcoursesforgraduation());
    }
}