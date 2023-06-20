package Listeners;
import Loggers.Log;
import Property.PropertyReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportListener extends ExtentReport implements ITestListener {

    public static String name;
    public static int count=0;

    Log log=new Log();

    public static ExtentTest gettest(){
        return test;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
//        if(count!=0){
//            test = extent.createTest(name);
//            test.log(Status.INFO, "Retrying the test");
//            test.log(Status.INFO, iTestResult.getMethod().getDescription());
//            log.info(iTestResult.getMethod().getDescription());
//            log.info("Retrying test");
//            count=0;
//        }

            String name=iTestResult.getMethod().getMethodName();
            test = extent.createTest(name);

            test.log(Status.INFO, "Staring test");
            log.info("Starting test");
            test.log(Status.INFO, iTestResult.getMethod().getDescription());
            log.info(iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            T_Pass(test);
            Log.info("This test is successful "+iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            T_Fail(test, iTestResult.getMethod().getMethodName());
            log.error("Test failed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.skip("test skipped");
        log.info("Test skipped");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //Log.info("Test cases started");
        try {
            PropertyReader.Load("/home/vend/IdeaProjects/ReqresAPI/src/test/java/Resources/config.properties");
            Setup_Report(PropertyReader.GetValue("report")+".html");
            log.info("report step up");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        extent.flush();
        //Log.info("Test case ended");
        flushing();
        log.info("End");
    }
}
