package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void validLoginTest() throws InterruptedException {
        //*************TEST DATA*************
        String email = "peter.parker@avantica.net";
        String password = "123456";

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to AutomationWebsite
        MyAccountPage myAccountPage = loginPage.doLogin(email, password);
        Thread.sleep(500);

        //Verify user landed on My Account Page
        assertTrue(myAccountPage.verifyLandInMyAccountPage(), "The page header doesn't correspond to My Account Page");
    }

    @Test(priority = 1)
    public void signUpNewUser() throws InterruptedException {
        //*************TEST DATA*************
        String firstName = "Peter";
        String lastName = "Parker";
        String email = "peter.parker_"+getRandomNumberInRange(0,100)+"@gmail.net";
        String password = "123456";
        int birthDay = 10;
        int birthMonth = 8;
        String birthYear = "1962";
        String companyName = "Avantica Technologies";
        String addressLine1 = "Walt Disney World Resort";
        String city = "Orlando";
        String state= "Florida";
        String zipCode = "32830";
        String mobilePhone ="407 939-1936";
        String addressAlias = "Disney Hotel";


        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Go to RegistrationPage
        loginPage.goToRegistrationPage(email);
        Thread.sleep(15000);

        //Fill the registration form
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setPassword(password);
        registrationPage.setBirthDays(birthDay);
        registrationPage.setBirthMonth(birthMonth);
        registrationPage.setBirthYear(birthYear);
        registrationPage.setCompanyName(companyName);
        registrationPage.setAddressFirstName(firstName);
        registrationPage.setAddressLastName(lastName);
        registrationPage.setAddresLine1(addressLine1);
        registrationPage.setCity(city);
        registrationPage.setState(state);
        registrationPage.setZipCode(zipCode);
        registrationPage.setMobilePhone(mobilePhone);
        registrationPage.setAddressAlias(addressAlias);

        //Click on registration button and verify user landed on My account page
        MyAccountPage myAccountPage = registrationPage.clickRegistrationButton();
        assertTrue(myAccountPage.verifyLandInMyAccountPage(), "The page header doesn't correspond to My Account Page");

    }

    @Test(priority = 2)
    public void failed_signUpUser_withExistingEmail() throws InterruptedException {
        String email = "peter.parker@gmail.net";
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Go to RegistrationPage
        loginPage.goToRegistrationPage(email);
        Thread.sleep(5000);
        assertTrue(loginPage.isErrorMessageDisplayed_EmailAlreadyInUse(), "The error message wasn't displayed");
    }




}
