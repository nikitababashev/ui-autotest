package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private final SelenideElement dashboardButton = $("[data-testid='onboardingSidebarDashboard']");
    private final SelenideElement textCheckDashboardOpened = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement checkCorrectOpenedProject = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement addProjectButton = $("[data-testid='sidebarProjectsAddButton']");
    private final SelenideElement inputNameProjectField = $("[data-testid='addProjectNameInput']");
    private final SelenideElement addEditProjectButton = $("[data-testid='addEditProjectAddButton']");
    private final SelenideElement textCheckSuccessfulCreatedProject = $("[data-testid='messageSuccessDivBox']");

    public void openPage(){
        open("/index.php?/dashboard");
    }

    public void openDashboard(){
        dashboardButton.click();
    }

    public void checkDashboardOpened(){
        textCheckDashboardOpened.shouldHave(text("Dashboard"));
    }

    public void openProject(String nameProject){
        $$("div.summary-title a").findBy(text(nameProject)).click();
    }

    public void checkProjectOpened(String nameProject){
        checkCorrectOpenedProject.shouldHave(text(nameProject));
    }

    public void createNewProject(String name){
        addProjectButton.click();
        inputNameProjectField.click();
        inputNameProjectField.setValue(name);
        addEditProjectButton.click();
    }

    public void checkCreatedProject(){
        textCheckSuccessfulCreatedProject.shouldHave(text("Successfully added the new project."));
    }
}
