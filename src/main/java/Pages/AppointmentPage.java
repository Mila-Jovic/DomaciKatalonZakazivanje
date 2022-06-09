package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;


public class AppointmentPage extends BasePage {
    private By facilities = By.id("combo_facility");
    private By apply4Readmission = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label");
    private By medicareRadioBtn = By.xpath("//input[@name='programs'and@value='Medicare']");
    private By medicaidRadioBtn = By.xpath("//input[@name='programs'and@value='Medicaid']");
    private By noneRadioBtn = By.xpath("//input[@name='programs'and@value='None']");
    private By visitDate = By.id("txt_visit_date");
    private By commentBar = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");


    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacilities() {
        return facilities;
    }

    public By getApply4Readmission() {
        return apply4Readmission;
    }

    public By getMedicareRadioBtn() {
        return medicareRadioBtn;
    }

    public By getMedicaidRadioBtn() {
        return medicaidRadioBtn;
    }

    public By getNoneRadioBtn() {
        return noneRadioBtn;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getCommentBar() {
        return commentBar;
    }

    public By getBookAppointmentBtn() {
        return bookAppointmentBtn;
    }

    public void selectFacility(String facility) {
        Select selectFacility = new Select(getDriver().findElement(facilities));
        selectFacility.selectByVisibleText(facility);
    }

    public void clickApply4Readmission() {
        getDriver().findElement(apply4Readmission).click();
    }

    public void choseRadioBtn(String value) {
        value = value.toUpperCase();
        switch (value) {
            case "MEDICARE":
                getDriver().findElement(medicareRadioBtn).click();
                break;
            case "MEDICAID":
                getDriver().findElement(medicaidRadioBtn).click();
                break;
            case "NONE":
                getDriver().findElement(noneRadioBtn).click();
                break;
            default:
                System.out.println("Invalid input, please chose Medicare, Medicaid or none! ");
        }
    }


    /**
     * enter the data in the form of dd/mm/yyyy
     **/
    public void enterVisitData(String data) {
        getDriver().findElement(visitDate).sendKeys(data);

    }

    public void enterComment(String comment) {
        getDriver().findElement(commentBar).sendKeys(comment);

    }

    public void clickBookAppointment() {
        getDriver().findElement(bookAppointmentBtn).click();
    }
    public boolean isFormPresent() {
        return !getDriver().findElements(By.id("appointment")).isEmpty();
    }

}
