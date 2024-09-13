package UITests;

import UITests.pages.CookiePopUp;
import UITests.pages.catalogue.CatalogueMainPage;
import UITests.pages.catalogue.CatalogueMainPage.CatalogueCategories;
import UITests.pages.MainPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class MainPageTests implements UiConfig {

    static Logger log = LogManager.getLogger(MainPageTests.class.getName());
    @Test
    public void testCookiesDialogueDisplayed() {
        CookiePopUp cookiePopUp = new CookiePopUp();
        cookiePopUp.cookieHeader.shouldHave(text(cookiePopUp.expectedCookieHeader));
        cookiePopUp.cookieText.shouldHave(text(cookiePopUp.expectedCookieText));
        cookiePopUp.acceptCookies.click();
        cookiePopUp.acceptCookies.shouldNotBe(visible);
    }

    @Test(description = "Check that catalogue can be opened from main page")
    public void testCatalogueOpened(){
        MainPage mainPage = new MainPage(true);
        mainPage.goToCatalogue();

        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), CatalogueMainPage.pageURL);
    }

    @BeforeMethod
    public void goToPage(){
        MainPage.goToPage();
    }




}
