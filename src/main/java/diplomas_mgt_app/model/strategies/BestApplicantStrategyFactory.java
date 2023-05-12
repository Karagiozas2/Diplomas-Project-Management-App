package diplomas_mgt_app.model.strategies;

public class BestApplicantStrategyFactory {
    public BestApplicantStrategyFactory() {
    }

    public BestApplicantStrategy createStrategy(String BestApplicantStrategy) {
        if (BestApplicantStrategy == null) {
            return null;
        }

        if (BestApplicantStrategy.equalsIgnoreCase("BestAvgGrade")) {
            return new BestAvgGradeStrategy();
        } else if (BestApplicantStrategy.equalsIgnoreCase("FewestCourses")) {
            return new FewestCoursesStrategy();
        } else if (BestApplicantStrategy.equalsIgnoreCase("RandomApplicantStrategy")) {
            return (diplomas_mgt_app.model.strategies.BestApplicantStrategy) new RandomApplicantStrategy();
        }

        return null;
    }
}