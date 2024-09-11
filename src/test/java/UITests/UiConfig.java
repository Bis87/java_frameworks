package UITests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.ByteArrayInputStream;
import java.util.Map;

public interface UiConfig {
//    App app = new App();

    @BeforeSuite()
    static void configure() {
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
//        Configuration.baseUrl = "https://onliner.by/";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.pageLoadTimeout = 60000;
        Configuration.fileDownload = FileDownloadMode.FOLDER;
//        Configuration.proxyEnabled = true;
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "./test-result/reports";
        Configuration.browserSize = "1920×1080";
    }


//    @BeforeMethod()
//    static void goToApp() {
//        Selenide.open(Configuration.baseUrl);
//    }

    @AfterMethod(description = "screenshot", alwaysRun = true, timeOut = 10000)
    static void attachScreenshotIfFailed(ITestResult testResult) {
        if (testResult.getStatus() != ITestResult.SUCCESS) {
            takeScreenshot();
        }
    }

    @AfterMethod(dependsOnMethods = {"attachScreenshotIfFailed"}, alwaysRun = true)
    static void closeDriver() {
        Selenide.closeWebDriver();
    }

    @Attachment(type = "image/png")
    static byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Step(value = "state screenshot")
    static void attachScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)));
    }



    static void refreshPage() {
        Selenide.refresh();
    }

}
