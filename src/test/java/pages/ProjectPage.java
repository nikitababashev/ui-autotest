package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {
    private final SelenideElement testCasesButton = $("[data-testid='navigateToCasesButton']");
    private final SelenideElement addTestCaseButton = $("[data-testid='sidebarCasesAdd']");
    private final SelenideElement textCheckSuccessfulCreationTestCase = $("[data-testid='messageSuccessDivBox']");
    private final SelenideElement titleForTestCaseField = $("[data-testid='addEditCaseTitle']");
    private final SelenideElement sectionForTestCaseButton = $("[data-testid='historyCompareToButton']");
    private final SelenideElement choiceSectionField = $(".chosen-search-input");
    private final SelenideElement addEditTestCaseButton = $$("div.button-group button").
            findBy(text("Add Test Case"));
    private final SelenideElement testRunsAndResultsButton = $("[data-testid='navigateToRunsButton']");
    private final SelenideElement textCheckPageTestCases = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement textCheckPageTestRunsAndResults = $("[data-testid='testCaseContentHeaderTitle']");

    public void openPage(){
        open("/projects/overview/1");
    }

    public void openTestCases(){
        testCasesButton.click();
    }

    public void openTestRunsAndResults(){
        testRunsAndResultsButton.click();
    }

    public void checkSuccessfulOpenedTestCases(){
        textCheckPageTestCases.shouldHave(text("Test Cases"));
    }

    public void checkSuccessfulOpenedTestRunsAndResults(){
        textCheckPageTestRunsAndResults.shouldHave(text("Test Runs & Results"));
    }

    public void createTestCase(String title, String section){
        addTestCaseButton.click();
        titleForTestCaseField.click();
        titleForTestCaseField.setValue(title);
        sectionForTestCaseButton.click();
        choiceSectionField.setValue(section).pressEnter();
        addEditTestCaseButton.click();
    }

    public void checkCreationTestCase(){
        textCheckSuccessfulCreationTestCase.shouldHave(text("Successfully added the new test case."));
    }
}
