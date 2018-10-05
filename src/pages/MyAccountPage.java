package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    //*********Constructor*********
    public MyAccountPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //*********Web Elements*********
    @FindBy(className = "page-heading")
    private WebElement header;

    @FindBy(className = "myaccount-link-list")
    private WebElement linksList;

    //*********Page Methods*********
    public boolean verifyLandInMyAccountPage() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementVisible(linksList);
        return linksList.isDisplayed();
    }

}
