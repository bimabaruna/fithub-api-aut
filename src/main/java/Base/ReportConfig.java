package Base;


import Test.TestRunner;
import com.google.common.io.Files;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class ReportConfig {

    public static void generateCucumberReport() {
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");

        String projectName = "Qatalyst Automation Desktop Web";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Desktop", "WEB");


        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();

    }
}
