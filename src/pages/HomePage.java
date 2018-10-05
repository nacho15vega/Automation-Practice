
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //*********Page Variables*********
    String baseURL = "http://automationpractice.com/index.php";

    //*********Web Elements*********
    String signInButtonClass = "login";

    @FindBy (css = ".shopping_cart a")
    private WebElement cartButton;


    //*********Page Methods*********

    //Go to Homepage
    public void goToN11 (){
        driver.get(baseURL);
    }

    //Go to LoginPage
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }

    //Go to CartPage
    public CartPage goToCartPage() throws InterruptedException {

        cartButton.click();
        Thread.sleep(500);
        return new CartPage(driver, wait);
    }


}