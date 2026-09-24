package tests;

import config.TestConfig.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void openLoginPage(){
        loginPage.openPage();
    }

    @Test
    @DisplayName("UI-001 Успешная авторизация")
    void successfulLoginTest(){
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        loginPage.checkSuccessfulLogin();
    }

    @Test
    @DisplayName("UI-002 Авторизация с неверным паролем")
    void incorrectPasswordLoginTest(){
        loginPage.login(loginPage.getEmail(), "wrong_password");
        loginPage.checkUnsuccessfulLogin();
    }

    @Test
    @DisplayName("UI-003 Пустой email")
    void emptyEmailFieldLoginTest(){
        loginPage.login("", loginPage.getPassword());
        loginPage.checkEmptyEmailFieldLoginTest();
    }

    @Test
    @DisplayName("UI-004 Пустой password")
    void emptyPasswordFieldLoginTest(){
        loginPage.login(loginPage.getEmail(), "");
        loginPage.checkEmptyPasswordFieldLoginTest();
    }
}
