package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{

    //*********Constructor*********
    public RegistrationPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //*********Web Elements*********
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

   @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement birthDaysDropdown;

    @FindBy(id = "months")
    private WebElement birthMonthsDropdown;

    @FindBy(id = "years")
    private WebElement birthYearsDropdown;

    @FindBy(id = "firstname")
    private WebElement addressFirstNameInput;

    @FindBy(id = "lastname")
    private WebElement addressLastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addresLine1Input;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id  = "alias")
    private WebElement addressAliasInput;

    @FindBy(id  = "submitAccount")
    private WebElement registerButton;



    //*********Page Methods*********
    public void setFirstName(String firstName){
        waitAndTypeOnCleanElement(firstNameInput, firstName);
    }

    public void setLastName(String lastName){
        waitAndTypeOnCleanElement(lastNameInput, lastName);
    }

    public void setPassword(String password){
        waitAndTypeOnCleanElement(passwordInput, password);
    }

    public void setBirthDays(int birthDay){
        jsSelect(birthDaysDropdown, birthDay);
//        Select daysDropdown = new Select(birthDaysDropdown);
//        daysDropdown.selectByIndex(birthDay);
    }

    public void setBirthMonth(int birthMonth){
        jsSelect(birthMonthsDropdown, birthMonth);
//        Select monthsDropdown = new Select(birthMonthsDropdown);
//        monthsDropdown.selectByIndex(birthMonth);
    }

    public void setBirthYear(String birthYear){
        jsSelectValue(birthYearsDropdown, birthYear);
//        Select yearsDropdown = new Select(birthYearsDropdown);
//        yearsDropdown.selectByValue(birthYear);
    }

    public void setAddressFirstName(String addressFirstName){
        waitAndTypeOnCleanElement(addressFirstNameInput, addressFirstName);
    }

    public void setAddressLastName(String addressLastName){
        waitAndTypeOnCleanElement(addressLastNameInput, addressLastName);
    }

    public void setCompanyName(String companyName){
        waitAndTypeOnCleanElement(companyInput, companyName);
    }

    public void setAddresLine1(String addresLine1){
        waitAndTypeOnCleanElement(addresLine1Input, addresLine1);
    }

    public void setCity(String city){
        waitAndTypeOnCleanElement(cityInput, city);
    }

    public void setState(String state){
        jsSelect(stateDropdown, state);
//        Select statesDropdown = new Select(stateDropdown);
//        statesDropdown.selectByVisibleText(state);
    }

    public void setZipCode(String zipCode){
        waitAndTypeOnCleanElement(zipCodeInput, zipCode);
    }

    public void setMobilePhone(String mobilePhone){
        waitAndTypeOnCleanElement(mobilePhoneInput, mobilePhone);
    }

    public void setAddressAlias(String addressAlias){
        waitAndTypeOnCleanElement(addressAliasInput, addressAlias);
    }

    public MyAccountPage clickRegistrationButton(){
        if(registerButton.isEnabled()){
            registerButton.click();
            return new MyAccountPage(driver, wait);
        }
        return null;
    }


    public void refreshPage() {
        PageFactory.initElements(driver, this);
    }
}
