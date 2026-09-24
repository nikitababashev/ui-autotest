package tests;

import com.codeborne.selenide.Selenide;
import config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void setUp(){
        TestConfig.configure();
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }
}
