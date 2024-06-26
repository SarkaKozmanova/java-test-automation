package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Application selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ApplicationAction {

    private final ElementFinder elementFinder;

    ApplicationAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    /**
     * Click Vytvorit novou prihlasku on table view
     */
    void clickCreateNewApplicationButton() {
        var createApplicationButton = elementFinder.findByCssSelector(".btn-sm");
        createApplicationButton.click();
    }

    void selectProgrammingSection() {
        var programmingSectionButton = elementFinder.findByXPath("//*[contains(text(), 'Programování')]//ancestor::*[@class='card']//a");
        programmingSectionButton.click();
    }

    /**
     * Click Vytvorit prihlasku for Javascript course
     */
    void clickCreateApplicationButton() {
        var createApplicationButton = elementFinder.findByCssSelector(".btn-primary");
        createApplicationButton.click();
    }

    void openFirstApplicationDetailsPage() {
        var openApplicationButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Zobrazit']");
        openApplicationButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath("//input[@type='search']");
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
    }

    void clickEditFirstApplicationButton() {
        var firstApplicationEditButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Upravit']");
        firstApplicationEditButton.click();
    }

    void clickCancelFirstApplicationButton() {
        var firstApplicationCancelButton = elementFinder.findByCssSelector(".btn-danger");
        firstApplicationCancelButton.click();
    }

    void clickReasonIllButton() {
        var cancelAppReasonIll = elementFinder.findByCssSelector("label.custom-control-label[for='logged_out_illness']");
        cancelAppReasonIll.click();
    }

    void submitCancelButton() {
        var submitCancellation = elementFinder.findByCssSelector(".btn-primary");
        submitCancellation.click();
    }



}

