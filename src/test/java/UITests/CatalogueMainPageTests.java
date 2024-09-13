package UITests;

import UITests.pages.catalogue.CatalogueMainPage;
import UITests.pages.catalogue.CatalogueMainPage.CatalogueCategories;
import com.codeborne.selenide.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static java.lang.Thread.sleep;

public class CatalogueMainPageTests implements UiConfig {
    static Logger log = LogManager.getLogger(CatalogueMainPageTests.class.getName());


    @Test
    public void testCatalogueTableOfContentItems() {
        List<String> expectedItems = Arrays.stream(CatalogueCategories.values())
                .map(CatalogueCategories::toString).toList();

        CatalogueMainPage catalogueMainPage = new CatalogueMainPage(true);
        ElementsCollection allCategories = catalogueMainPage.selectedCategoryLeftMenuItems;
        List<String> actualItems = new ArrayList<>();
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
        catalogueMainPage.selectCatalogueCategory(CatalogueCategories.CONSTRUCTION);
//        sleep(5000);

        ElementsCollection categoryItems = catalogueMainPage.selectedCategoryItems
                .shouldBe(CollectionCondition.sizeGreaterThan(1));

        List<String> actualCategoryItems = categoryItems.stream().map(SelenideElement::text).toList();
        Set<String> uniqueItems = new HashSet<>(actualCategoryItems);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualCategoryItems.size()).isEqualTo(uniqueItems.size());
        softAssertions.assertThat(actualCategoryItems).containsAll(uniqueItems);
        softAssertions.assertAll();
    }

    @Test
    public void testCatalogueLeftMenu() throws InterruptedException {
        CatalogueMainPage catalogueMainPage = new CatalogueMainPage(true);
        catalogueMainPage.selectCatalogueCategory(CatalogueCategories.ELECTRONIC);

        ElementsCollection leftMenuItems = catalogueMainPage.selectedCategoryLeftMenuItems
                .shouldBe(CollectionCondition.sizeGreaterThan(1));

//        List<String> leftMenuItemsText = leftMenuItems.stream().map(SelenideElement::text).toList();

        List<List<String>> itemsToVerify = Arrays.asList(
                Arrays.asList("Мобильные телефоны и аксессуары", "Смартфоны"),
                Arrays.asList("Телевидение и видео", "Телевизоры"),
                Arrays.asList("Планшеты, электронные книги", "Планшеты"),
                Arrays.asList("Аудиотехника", "Наушники"),
                Arrays.asList("Hi-Fi аудио", "Hi-Fi плееры"),
                Arrays.asList("Фото- и видеотехника", "Фотоаппараты"),
                Arrays.asList("Видеоигры", "Игровые приставки"),
                Arrays.asList("Гаджеты", "Пульсометры"),
                Arrays.asList("Умный дом и видеонаблюдение", "Датчики"),
                Arrays.asList("Электрический транспорт", "Гироциклы"),
                Arrays.asList("Телефония и связь", "Факсы"),
                Arrays.asList("Музыкальное оборудование", "Аудиоинтерфейсы666"),
                Arrays.asList("Оптические приборы", "Телескопы")
                );

        for(List<String> s : itemsToVerify){
            catalogueMainPage.hoverOnLeftMenuItem(s.get(0));
            assertThat(catalogueMainPage.getItemByName(s.get(1)).isDisplayed())
                    .as(String.format("\nleft menu %s\nitem %s",s.get(0), s.get(1) ))
                    .isEqualTo(true);

        }
    }

    @BeforeMethod
    public void goToPage() {
        CatalogueMainPage.goToPage();
    }
}
