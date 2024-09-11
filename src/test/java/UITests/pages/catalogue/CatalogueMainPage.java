package UITests.pages.catalogue;

import UITests.pages.CookiePopUp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogueMainPage {
    public static String pageURL = "https://catalog.onliner.by/";

    public ElementsCollection catalogueCategoriesItems = $$(By.xpath("//ul[@class='catalog-navigation-classifier']/li//span[@class='catalog-navigation-classifier__item-title-wrapper']"));

    CookiePopUp cookiePopUp = new CookiePopUp();

    public void openCataloguePage(boolean isCookiesAccepted){
        Selenide.open(pageURL);
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


