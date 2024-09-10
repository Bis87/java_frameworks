package UITests;

import UITests.pages.catalogue.CatalogueMainPage;
import UITests.pages.MainPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestTry implements UiConfig {

    @Test
    public void testCookiesDialogueDisplayed() {
        MainPage mainPage = new MainPage(false);
        mainPage.cookieHeader.shouldHave(text(mainPage.expectedCookieHeader));
        mainPage.cookieText.shouldHave(text(mainPage.expectedCookieText));
        mainPage.acceptCookies.click();
        mainPage.acceptCookies.shouldNotBe(visible);
    }

    @Test
    public void testCatalogueTableOfContentItems(){
        List <String> expectedItems = Arrays.asList("Onlíner Prime","Электроника","Компьютеры и сети","Бытовая техника","На каждый день","Стройка и ремонт","Дом и сад","Авто и мото","Красота и спорт","Детям и мамам");
        List <String> actualItems = new ArrayList<>();
        MainPage mainPage = new MainPage(true);
        CatalogueMainPage catalogueMainPage = mainPage.goToCatalogue();
        ElementsCollection allCategories =  catalogueMainPage.catalogueCategoriesItems;
        for(SelenideElement el : allCategories){
            actualItems.add(el.text());
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(expectedItems.containsAll(actualItems));
        softAssert.assertEquals(expectedItems.size(), actualItems.size());
        softAssert.assertAll();



        sleep(5000);
    }

}
