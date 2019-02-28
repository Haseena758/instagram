package automation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public  class listenersinTesng implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("testcases are started and details:"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("tests are succeed and details:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("tests are failed and details:"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("tests are skipped and details:"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("tests are failed and details:"+result.getName());
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("tests are started and details:"+result.getName());
	}

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("tests are finished and details:"+result.getName());
	}

	
	
}
