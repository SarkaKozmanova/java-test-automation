package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Test class for custom student tests
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodeAutomationTest extends TestRunner {

    //1.přejít do sekce Pro rodiče=>Návody a formuláře
    @Test
    void gotosectionProRodiceNavody() {
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
    }


    //2.přejít do sekce Pro učitelé=>Objednávka pro MŠ/ZŠ
    @Test
    void gotosectionObjednavky() {
    browser.headerMenu.goToKindergartenAndSchoolSection();
    browser.orderSection.selectSuburbanCampOption();
    }

    //3.projít všechny sekce horního menu
    @Test
    void gotosection() {
        browser.headerMenu.goToHomePage();
        browser.headerMenu.goToContactsSection();
        browser.headerMenu.goToInstructionsAndFormsForTeacherSection();
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
    }

    //4.vyplnění políčka ICO
    @Test
    void fillICO() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("22834958");
    }

    //6.vytvoření přihlášky
    @Test
    void createAPP() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();

        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
    }

    //1.dlaždice Programování
    @Test
    void checkprogramovani() {
        browser.headerMenu.goToHomePage();
        asserter.checkProgrammingSectionPresense();
    }

    //2.tlačítko registrace, user není přihlášený
    @Test
    void checkregistrationbutton() {
        browser.headerMenu.goToCreateApplicationSection();
        asserter.checkRegistrationButtonPresense();
    }

    //4.přihlášení, detail přihlášky, způsob úhrady
    @Test
    void checkpayment() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailAction.checkPaymentMethod("Hotově");
    }

    //1.Opakování (Navigace)
    @Test
    void opakovani_navigace() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("22834958");
        browser.orderSection.selectSchoolInNatureOption();
        browser.orderSection.insertChildrenCount(4);
    }

    //2.Opakování Assertace, přihlášení, sekce přihlášky, sloupce Jméno, Kategorie
    @Test
    void opakovani_assert() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        asserter.applicationSection.checkColumnExists("Jméno");
        asserter.applicationSection.checkColumnExists("Kategorie");
    }

    //3.Komplexnější testy
    @Test
    void komplexnejsi_testy() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
        browser.applicationDetailsSection.insertStudentFirstName("Jan");
        browser.applicationDetailsSection.insertStudentLastName("Kozman");
        browser.applicationDetailsSection.insertBirthdate("01.01.2000");
        browser.applicationDetailsSection.insertNote("Note");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        asserter.applicationDetailAction.checkTerm("27.06. - 30.06.2024");
        asserter.applicationDetailAction.checkFirstName("Jan");
        asserter.applicationDetailAction.checkLastName("Kozman");
        asserter.applicationDetailAction.checkDateOfBirth("01.01.2000");
        asserter.applicationDetailAction.checkNote("Note");
        asserter.applicationDetailAction.checkPaymentMethod("Hotově");
    }

    //4.Komplexnější testy
    @Test
    void komplexnejsi_testy3() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
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
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
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

    //1.Domácí úkol
    @Test
    void DU_Automation() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("bartolomejkozman@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
        var nahodnePrijmeni = browser.generateRandomName(10);
        browser.applicationSection.search(nahodnePrijmeni);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
        browser.applicationDetailsSection.insertStudentFirstName("ŠárkaDU");
        browser.applicationDetailsSection.insertStudentLastName(nahodnePrijmeni);
        browser.applicationDetailsSection.insertBirthdate("04.04.2004");
        browser.applicationDetailsSection.insertNote("Hezký den!");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(nahodnePrijmeni);
        asserter.applicationSection.checkNumberOfApplications(1);
        browser.applicationSection.clickEditFirstApplicationButton();
        browser.applicationDetailsSection.selectBankTransferPaymentMethod();
        browser.applicationDetailsSection.clickEditApplicationButton();
        browser.applicationSection.search(nahodnePrijmeni);
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailAction.checkPaymentMethod("Bankovní převod");
    }


    //7.Komplexnější testy
    @Test
    void komplexnejsi_testy7() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("sarkakozmanova@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.clickLoginButton();
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

    @Test
    void myfirsttest() {
        webDriver.get("https://bj24-testingbeasts.czechhackitas.cz/zaci");
        browser.waitFor(3);
        webDriver.navigate().back();
        browser.waitFor(3);
        webDriver.navigate().forward();
        browser.waitFor(3);
        webDriver.navigate().refresh();
    }

    //HW Check registration
    @Test
    void checkvalidregistration() {
        webDriver.get("https://team8-2022brno.herokuapp.com/");
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickRegistrationButton();
        var nahodneJmenoPrijmeni = browser.generateRandomName(10);
        browser.loginSection.insertName(nahodneJmenoPrijmeni);
        browser.loginSection.insertRegEmail(nahodneJmenoPrijmeni + "@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.insertPasswordVerification("Heslo1");
        browser.waitFor(3);
        browser.loginSection.clickConfirmRegButton();
        asserter.checkIsLoggedIn();

    }


    //HW Check nonvalid registration
    @Test
    void checknonvalidregistration() {
        webDriver.get("https://team8-2022brno.herokuapp.com/");
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickRegistrationButton();
        var nahodneJmenoPrijmeni = browser.generateRandomName(10);
        browser.loginSection.insertName(nahodneJmenoPrijmeni);
        browser.loginSection.insertRegEmail(nahodneJmenoPrijmeni + "@gmail.com");
        browser.loginSection.insertPassword("Heslo1");
        browser.loginSection.insertPasswordVerification("Heslo2");
        browser.waitFor(3);
        browser.loginSection.clickConfirmRegButton();
        asserter.checkDifferentPasswordReg();

    }
}