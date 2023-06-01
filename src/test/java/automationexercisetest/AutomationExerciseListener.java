package automationexercisetest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import uspiit.base.CommonAPI;

public class AutomationExerciseListener extends CommonAPI implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Case started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case skipped: " + result.getName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
        System.out.println("Test Case failed with timeout: " + result.getName());    }
}
