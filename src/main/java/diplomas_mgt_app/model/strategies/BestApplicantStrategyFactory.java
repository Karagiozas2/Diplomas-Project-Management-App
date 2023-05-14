package diplomas_mgt_app.model.strategies;

public class BestApplicantStrategyFactory {
    public BestApplicantStrategyFactory() {
    }

    public BestApplicantStrategy createThresholdStrategy(double th1, double th2) {
        return new ThresholdApplicantStrategy(th1, th2);
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
            return new RandomApplicantStrategy();
        }else if (BestApplicantStrategy.equalsIgnoreCase("ThresholdApplicantStrategy")) {
            return new ThresholdApplicantStrategy();
        }

        return null;
    }
}