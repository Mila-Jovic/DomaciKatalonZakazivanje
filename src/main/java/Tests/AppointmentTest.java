package Tests;

import Pages.AppointmentPage;
import Pages.LoginPage;
import Pages.SummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mila-\\Desktop\\EXE file\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);

        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @BeforeMethod
    public void doBeforeMethod() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test(priority = 1)
    public void loginTest() {
        // Ulogovate se na stranicu preko demo naloga
        //John Doe/ThisIsNotAPassword
        loginPage.clickMenu();
        loginPage.clickLoginOptions();
        loginPage.enterUsername("John Doe");
        loginPage.enterPassword("ThisIsNotAPassword");
        loginPage.login();
        Assert.assertTrue(appointmentPage.isFormPresent());
    }

    @Test(priority = 2)
    public void makeAnAppointmentTest() throws InterruptedException {
        //Popunite appointment formu

        //facility opcije:   Tokyo CURA Healthcare Center    Hongkong CURA Healthcare Center   Seoul CURA Healthcare Center
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");

        //choseRadioBtn opcije:  Medicare   Medicaid  None

        appointmentPage.choseRadioBtn("medicaid");
        appointmentPage.enterVisitData("25/07/2022");
        appointmentPage.enterComment("Nesto zanimljivo.");
        appointmentPage.clickBookAppointment();
        Assert.assertEquals(summaryPage.getFacilityText(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(summaryPage.getHospitalReadmissionText(), "No");
        Assert.assertEquals(summaryPage.getRadioText(), "Medicaid");
        Thread.sleep(2000);
        Assert.assertEquals(summaryPage.getVisitDateText(), "25/07/2022");
        Assert.assertEquals(summaryPage.getAppointmentCommentText(), "Nesto zanimljivo.");
    }


}
