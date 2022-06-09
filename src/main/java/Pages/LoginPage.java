package Pages;
/* LoginPage – dodati neophodne metode
·        AppointmentPage
o   getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
        (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By menu = By.id("menu-toggle");
    private By loginOption = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");
    private By usernameBar = By.id("txt-username");
    private By passwordBar= By.id("txt-password");
    private By loginBtn = By.id("btn-login");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public  void clickMenu(){
    getDriver().findElement(menu).click();
    }
    public void clickLoginOptions(){
        getDriver().findElement(loginOption).click();
    }
    public void enterUsername (String username){
        getDriver().findElement(usernameBar).sendKeys(username);
    }
    public void enterPassword (String password){
        getDriver().findElement(passwordBar).sendKeys(password);
    }
    public void login (){
        getDriver().findElement(loginBtn).click();
    }
}
