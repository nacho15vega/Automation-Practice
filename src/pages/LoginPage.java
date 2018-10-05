package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    //*********Web Elements*********
    String usenameId = "email";
    String passwordId = "passwd";
    String loginButtonId = "SubmitLogin";
    String emailId="email_create";
    String createAccountId = "SubmitCreate";





    //*********Page Methods*********

    public void loginToAutomationWebsite (String username, String password){
        //Enter Username(Email)
        writeText(By.id(usenameId),username);
        //Enter Password
        writeText(By.id(passwordId), password);
        //Click Login Button
        click(By.id(loginButtonId));
    }

    public MyAccountPage doLogin (String username, String password) throws InterruptedException{
        Thread.sleep(5000);
        //Enter Username(Email)
        writeText(By.id(usenameId),username);
        //Enter Password
        writeText(By.id(passwordId), password);
        //Click Login Button
        click(By.id(loginButtonId));
        return new MyAccountPage(driver, wait);
    }

    public void goToRegistrationPage(String email) throws InterruptedException{
        Thread.sleep(5000);
        writeText(By.id(emailId), email);
        click(By.id(createAccountId));
    }

    public boolean isErrorMessageDisplayed_EmailAlreadyInUse(){
        WebElement createAccountErrorMsg = driver.findElement(By.id("create_account_error"));
        return createAccountErrorMsg.isDisplayed();
    }





}
