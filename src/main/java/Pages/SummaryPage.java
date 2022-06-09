package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SummaryPage extends BasePage {


    private By appointmentFacility = By.id("facility");
    private By appointmentHospitalReadmission = By.id("hospital_readmission");
    private By appointmentRadioBtn = By.id("program");
    private By appointmentVisitDate = By.id("visit_date");
    private By appointmentComment = By.id("comment");


    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getFacilityText() {
        String text =getDriver().findElement(appointmentFacility).getText();
        return text;
    }

    public String getHospitalReadmissionText() {
        return getDriver().findElement(appointmentHospitalReadmission).getText();
    }

    public String getRadioText() {
        return getDriver().findElement(appointmentRadioBtn).getText();
    }

    public String getVisitDateText() {
        return getDriver().findElement(appointmentVisitDate).getText();
    }

    public String getAppointmentCommentText() {
        return getDriver().findElement(appointmentComment).getText();
    }
}
//    public String appointmentList() {
//        List<WebElement> fullAppointmentList = getDriver().findElements(By.xpath("//div[@class=\"col-xs-8\"]//p"));
//        String appointmentData;
//        for (int i = 0; i < fullAppointmentList.size(); i++) {
//           appointmentData= appointmentData + fullAppointmentList.get(i).findElement(By.tagName("p")).getText();
//
//        }
//        return appointmentData;
//    }

