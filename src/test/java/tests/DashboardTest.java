package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.stream.Stream;


public class DashboardTest extends BaseTest{
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void authorization(){
        loginPage.openPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
    }

    @Test
    @DisplayName("UI-005 Переход на Dashboard")
    void openDashboardTest(){
        dashboardPage.openDashboard();
        dashboardPage.checkDashboardOpened();
    }

    @Test
    @DisplayName("UI-006 Открытие Sample Project")
    void openSampleProjectTest(){
        dashboardPage.openPage();
        String nameProject = "Sample Project";
        dashboardPage.openProject(nameProject);
        dashboardPage.checkProjectOpened(nameProject);
    }


    static Stream<String> projectNames() {
        Faker faker = new Faker();

        return Stream.of(
                "Auto Project " + faker.number().digits(6),
                        "Auto Project " + faker.number().digits(6)
        );
    }

    @ParameterizedTest
    @MethodSource("projectNames")
    @DisplayName("UI-007 Добавление проекта через Add Project")
    void createProjectTest(String projectName) {
        dashboardPage.openPage();
        dashboardPage.createNewProject(projectName);
        dashboardPage.checkCreatedProject();
    }

}
