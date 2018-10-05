package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {


    //*********Constructor*********
    public CartPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //*********Web Elements*********
    @FindBy (css = "p.alert")
    private WebElement cartEmptyAlert;

    //*********Page Methods*********
    public boolean isCartEmpty() {
        return !cartEmptyAlert.isDisplayed();
    }

}
