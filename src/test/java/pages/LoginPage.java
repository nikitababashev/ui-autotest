package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement emailInput = $("[data-testid='loginIdName']");
    private final SelenideElement passwordInput = $("[data-testid='loginPasswordFormDialog']");
    private final SelenideElement loginButton = $("[data-testid='loginButtonPrimary']");
    private final SelenideElement dashboard = $("[data-testid='onboardingSidebarDashboard']");
    private final SelenideElement errorpassword = $("[data-testid='loginErrorText']");
    private final SelenideElement erroremailfieldempty = $$(".loginpage-message").
            findBy(text("Email/Login is required."));
    private final SelenideElement errorpasswordfieldempty = $$(".loginpage-message").
            findBy(text("Password is required."));
    private final String correctEmail = System.getenv("TEST_EMAIL");
    private final String correctPassword  = System.getenv("TEST_PASSWORD");

    public String getEmail(){
        return correctEmail;
    }

    public String getPassword(){
        return correctPassword;
    }

    public void openPage(){
        open("/index.php?/auth/login");
    }

    public void login(String email, String password){
        emailInput.click(); /*без этого поле не успевает ввестись (javascript не успевает прогрузить поле, т.е.
           мы записываем значение в поле до того, как js иницилизирует/создаёт это поле, поэтому оно перезаписывается
           пустой строкой) */
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
    }

    public void checkSuccessfulLogin(){
        dashboard.shouldBe(visible);
    }

    public void checkUnsuccessfulLogin() {errorpassword.shouldBe(visible); }

    public void checkEmptyEmailFieldLoginTest() {erroremailfieldempty.shouldBe(visible); }

    public void checkEmptyPasswordFieldLoginTest() {errorpasswordfieldempty.shouldBe(visible); }
}
