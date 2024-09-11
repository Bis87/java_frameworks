package UITests.pages;


import UITests.pages.catalogue.CatalogueMainPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
    public CatalogueMainPage goToCatalogue(){
        ButtonOpenCatalogue.click();
        return new CatalogueMainPage();
    }

}
