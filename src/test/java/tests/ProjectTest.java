package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProjectPage;


public class ProjectTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeEach
    void openProject(){
        loginPage.openPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        projectPage.openPage();
    }

    @Test
    @DisplayName("UI-008 Переход в Test Cases")
    void openTestCasesTest(){
        projectPage.openTestCases();
        projectPage.checkSuccessfulOpenedTestCases();
    }

    @Test
    @DisplayName("UI-009 Переход в Test Runs & Results")
    void openTestRunsAndResultsTest(){
        projectPage.openTestRunsAndResults();
        projectPage.checkSuccessfulOpenedTestRunsAndResults();
    }

    @Test
    @DisplayName("UI-010 Создание Test Case")
    void createTestCaseTest(){
        Faker faker = new Faker();
        projectPage.createTestCase("Test" + faker.number().digits(3), "UI");
        projectPage.checkCreationTestCase();
    }
}
