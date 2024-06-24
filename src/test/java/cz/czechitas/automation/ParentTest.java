package cz.czechitas.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParentTest extends TestRunner {


    @BeforeEach
    void login() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
    }

    //4.Komplexnější testy
    @Test
    void komplexnejsi_testy3() {
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search("Tester001");
        asserter.applicationSection.checkNumberOfApplications(1);
        browser.applicationSection.clickEditFirstApplicationButton();
        browser.applicationDetailsSection.selectBankTransferPaymentMethod();
        browser.applicationDetailsSection.clickEditApplicationButton();
        browser.applicationSection.search("Tester001");
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailAction.checkPaymentMethod("Bankovní převod");
        asserter.applicationDetailAction.checkRemainingAmountToPay("1 800 Kč");
        asserter.applicationDetailAction.checkMessageContainsStudentLastName("Tester001");
    }
    //4.Komplexnější testy
    @Test
    void komplexnejsi_testy6() {
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
        browser.applicationDetailsSection.insertStudentFirstName("Jan");
        var mojePrijmeni = browser.generateRandomName(10);
        browser.applicationDetailsSection.insertStudentLastName(mojePrijmeni);
        browser.applicationDetailsSection.insertBirthdate("01.01.2010");
        browser.applicationDetailsSection.insertNote("Note");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(mojePrijmeni);
        asserter.applicationSection.checkNumberOfApplications(1);
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("bartolomejkozman@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(mojePrijmeni);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
    }


    //7.Komplexnější testy
    @Test
    void komplexnejsi_testy7() {
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("Heslo11");
        browser.profileSection.insertPasswordVerification("Heslo11");
        browser.profileSection.clickChangeButton();
        browser.headerMenu.goToHomePage();
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo11");
        browser.loginSection.clickLoginButton();
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("Heslo1");
        browser.profileSection.insertPasswordVerification("Heslo1");
        browser.profileSection.clickChangeButton();
        browser.headerMenu.goToHomePage();
        browser.loginSection.logout();
    }

    //Domácí úkol Cancel Application
    @Test
    void cancel_app() {
        webDriver.get("https://team8-2022brno.herokuapp.com/zaci");
        browser.applicationSection.clickCancelFirstApplicationButton();
        browser.applicationSection.clickReasonIllButton();
        browser.applicationSection.submitCancelButton();
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailAction.checkIfCancelled();
    }
}
