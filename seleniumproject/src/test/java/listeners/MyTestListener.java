package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {

		System.out.println("Test Finish");
	}

	@Override
	public void onStart(ITestContext arg0) {

		System.out.println("Test Started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		System.out.println("Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped");

	}

	@Override
	public void onTestStart(ITestResult arg0) {

		System.out.println("Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		System.out.println("Test successed");
	}

}