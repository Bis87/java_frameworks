package UITests.pages.catalogue;

import UITests.pages.CookiePopUp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.HoverOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import javax.swing.text.Element;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogueMainPage {
    public static String pageURL = "https://catalog.onliner.by/";
    CookiePopUp cookiePopUp = new CookiePopUp();

    public ElementsCollection topMenuCatalogCategories = $$(By.xpath("//ul[@class='catalog-navigation-classifier']/li//span[@class='catalog-navigation-classifier__item-title-wrapper']"));
    public ElementsCollection selectedCategoryLeftMenuItems = $$(By.xpath(".//div[@class='catalog-navigation-list__aside-title']"));
    public ElementsCollection selectedCategoryItems = $$(By.xpath("//span[@class='catalog-navigation-list__dropdown-title']"));
//    public SelenideElement selectedCategoryItem = $(By.xpath("//span[@class='catalog-navigation-list__dropdown-title' and normalize-space()='%s']"));

    public void selectSubcategory(String category){
        $(By.xpath(String.format("//span[@class='catalog-navigation-list__dropdown-data']//span[normalize-space()='%s']", category))).click();
    }

    public SelenideElement getItemByName(String name){
        return $(By.xpath(String.format("//span[@class='catalog-navigation-list__dropdown-title' and normalize-space()='%s']", name)));
    }

    public void hoverOnLeftMenuItem(String item){
        $(By.xpath(String.format(".//div[@class='catalog-navigation-list__aside-title' and normalize-space()='%s']",item))).hover();
    }

    public void selectCatalogueCategory(CatalogueCategories category){
        $(By.xpath(String.format("//span/span[normalize-space()='%s']", category.toString()))).click();
        // //span/span[normalize-space()='Электроника']
    }



    public static void goToPage(){
        Selenide.open(pageURL);
    }

    public CatalogueMainPage(boolean acceptCookies){
        if (acceptCookies){
            cookiePopUp.acceptCookies();
        }
    }

    public CatalogueMainPage(){
    }

    @RequiredArgsConstructor
    public enum CatalogueCategories {
        PRIME("Onlíner Prime"),
        ELECTRONIC("Электроника"),
        COMPUTER_AND_NETWORKS("Компьютеры и сети"),
        HOUSEHOLD_APPLIANCE("Бытовая техника"),
        EACH_DAY_USE("На каждый день"),
        CONSTRUCTION("Стройка и ремонт"),
        HOUSE_AND_GARDEN("Дом и сад"),
        CAR_AND_MOTO("Авто и мото"),
        BEAUTY_AND_SPORT("Красота и спорт"),
        MOM_AND_KID("Детям и мамам");

        private final String value;

        @Override
        public String toString() {
            return this.value;
        }

        }

}


