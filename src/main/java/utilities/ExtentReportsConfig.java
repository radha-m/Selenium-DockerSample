package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsConfig {

    static ExtentReports extent;

    public static ExtentReports reportConfig()
    {
        String reportPath = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
        report.config().setReportName("My TestNg Results");
        report.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Test Type","Automation");
        return extent;
    }

}
