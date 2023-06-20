package Listeners;

import Property.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentReport{

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    public static ExtentTest test;

    public void Setup_Report(String rname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        htmlReporter=new ExtentHtmlReporter(rname+timeStamp+".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        PropertyReader.Load(System.getProperty("user.dir")+"//src//test//java//Resources//config.properties");

        htmlReporter.config().setDocumentTitle(PropertyReader.GetValue("api")+" Automation Test Report");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setReportName(PropertyReader.GetValue("api")+" Automation Execution Report");
    }

    public void flushing(){
        extent.flush();
    }

    public void T_Pass(ExtentTest test) throws IOException {
        test.log(Status.PASS,
                "<summary> <b> <font color=green> Test Passed: </b> "
                        + "</font>" + "</summary>");
    }

    public void T_Fail(ExtentTest test, String name) throws IOException {
        test.fail("test failed");
        test.log(Status.FAIL,
                "<details>" + "<summary> <b> <font color=red> Test Failed: </b> " + "</font>" + "</summary>" +"<p></p>"+"</details>");
    }
}
