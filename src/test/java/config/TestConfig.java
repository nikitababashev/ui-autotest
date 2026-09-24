package config;

import com.codeborne.selenide.Configuration;

public class TestConfig {
    public static void configure(){
        Configuration.baseUrl = System.getProperty("baseUrl", "https://workspaceforapiandui.testrail.io/index.php?");
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests/screenshotsFailedTests";
    }
}
