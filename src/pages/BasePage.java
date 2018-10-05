package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }


    //Waits and Write on Clean Element
//    public boolean waitAndTypeOnCleanElement(final WebElement element, String text) {
//        try {
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver arg0) {
//                    return element.isEnabled();
//                }
//            });
//
//            element.clear();
//            element.sendKeys(text);
//            return true;
//        } catch (Exception e) {
//            String name = e.getMessage().split("\n")[0];
//            if (name.contains("no such element")) {
//                name = "null";
//            }
//            return false;
//        }
//    }

    public void waitAndTypeOnCleanElement(final WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

        //Waits for visibility of element
    public boolean waitForElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));

            return element.isDisplayed();
        } catch (Exception e) {
            String name = "null";

            if (e.getMessage() != null) {
                name = e.getMessage().split("\n")[0];
            }
            if (name.contains("no such element")) {
                name = "null";
            }
            return false;
        }
    }


    public boolean waitAndClickElement(final WebElement element) {
        try {
            boolean vlr;

            vlr = wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver arg0) {
                    return element.isEnabled();
                }
            });
            element.click();

            return vlr;
        } catch (Exception e) {
            String name = "null";

            if (e.getMessage() != null) {
                name = e.getMessage().split("\n")[0];
            }
            if (name.contains("no such element")) {
                name = "null";
            }
            return false;
        }
    }

    public void jsSelect(WebElement element, int index) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].selectedIndex=" + index + ";", element);
    }

    public void jsSelect(WebElement element, String item) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("const textToFind = '" + item + "';" +
                "const dd = arguments[0];" +
                "dd.selectedIndex = [...dd.options].findIndex (option => option.text === textToFind);", element);
    }

    public void jsSelectValue(WebElement element, String item) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("const textToFind = '" + item + "';" +
                "const dd = arguments[0];" +
                "dd.selectedIndex = [...dd.options].findIndex (option => option.value === textToFind);", element);
    }


}
