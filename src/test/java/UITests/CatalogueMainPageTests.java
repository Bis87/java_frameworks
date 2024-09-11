package UITests;

import UITests.pages.MainPage;
import UITests.pages.catalogue.CatalogueMainPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogueMainPageTests implements UiConfig {
    static Logger log = LogManager.getLogger(CatalogueMainPageTests.class.getName());


    @Test
    public void testCatalogueTableOfContentItems() {
        List<String> expectedItems = Arrays.stream(CatalogueMainPage.CatalogueCategories.values())
                .map(CatalogueMainPage.CatalogueCategories::toString).toList();
        List<String> actualItems = new ArrayList<>();

        CatalogueMainPage catalogueMainPage = new CatalogueMainPage(true);
        ElementsCollection allCategories = catalogueMainPage.catalogueCategoriesItems;
        for (SelenideElement el : allCategories) {
            actualItems.add(el.text());
        }
        SoftAssert softAssert = new SoftAssert();
        log.info("expectedItems : \n" + expectedItems);
        log.info("actualItems : \n" + actualItems);
        softAssert.assertTrue(expectedItems.containsAll(actualItems), "actualItems should contains expectedItems");
        softAssert.assertEquals(expectedItems.size(), actualItems.size());
        softAssert.assertAll();
    }

    @Test
    public void testCatalogueConstructionItems() {
        CatalogueMainPage catalogueMainPage = new CatalogueMainPage(true);

    }

    @BeforeMethod
    public void goToPage() {
        CatalogueMainPage.goToPage();
    }
}
