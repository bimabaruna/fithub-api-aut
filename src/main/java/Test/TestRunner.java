package Test;


import Base.ReportConfig;
import com.google.common.io.Files;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@CucumberOptions(

        glue = "TestStep",
        features = "src/test/java/",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
        },
        tags = {"@apiTest2"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    public String reportDirectory = "reports";
    public String reportFormat = "xml";

    DesiredCapabilities dc = new DesiredCapabilities();

    public void setUp() throws IOException, InterruptedException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);

    }

    @Before
    public void asd(Scenario scenario){
        String scenarioName = scenario.getName();
        String[] arrayScenarioName = scenarioName.split("--");
        String scenarioName1 = arrayScenarioName[0];
        String scenarioName2 = arrayScenarioName[1];
        System.out.println("Scenario Name 1 for this test is -> " + scenarioName1);
        System.out.println("Scenario Name 2 for this test is -> " + scenarioName2);
    }


    @AfterSuite(alwaysRun = true)
    public void quit() throws IOException {
        ReportConfig.generateCucumberReport();
    }

    @BeforeSuite
    public void setUpp() throws Exception {
        setUp();
    }
}
