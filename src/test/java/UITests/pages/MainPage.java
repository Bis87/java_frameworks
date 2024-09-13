package UITests.pages;


import UITests.pages.catalogue.CatalogueMainPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.*;

public class MainPage {
   public static String pageURL = "https://www.onliner.by/";
    CookiePopUp cookiePopUp = new CookiePopUp();
    public SelenideElement ButtonOpenCatalogue = $(By.xpath("//nav[@class='b-top-navigation']//span[text()='Каталог']"));

    public MainPage(boolean acceptCookies){
        if (acceptCookies){
            cookiePopUp.acceptCookies();
        }
    }

    public static void goToPage(){
        Selenide.open(pageURL);
    }
    @Step
    public CatalogueMainPage goToCatalogue(){
        ButtonOpenCatalogue.click();
        return new CatalogueMainPage();
    }

}
