package UITests.pages.catalogue;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CatalogueMainPage {

    public ElementsCollection catalogueCategoriesItems = $$(By.xpath("//ul[@class='catalog-navigation-classifier']/li//span[@class='catalog-navigation-classifier__item-title-wrapper']"));

}
