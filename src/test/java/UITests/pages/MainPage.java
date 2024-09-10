package UITests.pages;


import UITests.pages.catalogue.CatalogueMainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public String expectedCookieHeader = "Мы используем cookie, чтобы сделать сайт удобнее";
    public String expectedCookieText = "Мы обрабатываем cookie, чтобы ваш веб-серфинг шел как по маслу, а скидки и рекомендации для вас были точно в яблочко! ";

    public SelenideElement acceptCookies = $(By.xpath("//a[text()='Принять все cookie']"));
    public SelenideElement cookieHeader = $(By.xpath("//div[@class='auth-form']/div[@class='auth-form__title auth-form__title_base auth-form__title_nocondensed auth-form__title_condensed-other']"));
    public SelenideElement cookieText = $(By.xpath("//div[@class='auth-form']/div[@class='auth-form__description auth-form__description_primary auth-form__description_base-additional auth-form__description_condensed']"));
    public SelenideElement openCatalogue = $(By.xpath("//nav[@class='b-top-navigation']//span[text()='Каталог']"));

    public MainPage(boolean isCookiesAccepted){
        if (isCookiesAccepted){
            acceptCookies.click();
            acceptCookies.shouldNotBe(visible);
        }
    }
    public CatalogueMainPage goToCatalogue(){
        openCatalogue.click();
        return new CatalogueMainPage();
    }

}
