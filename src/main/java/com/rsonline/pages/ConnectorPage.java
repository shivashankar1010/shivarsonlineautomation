package com.rsonline.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConnectorPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='breadcrumb']//li[last()]")
    private WebElement brandTitle;

    @FindBy(css = "div#ATPopularProduct a.productDesc")
    private List<WebElement> popularProducts;

    //ByCssSelector<Link>("ul a[href='https://uk.rs-online.com/web/c/" + page + "/']")
    //                .IsDisplayed();

    public ConnectorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBrandTitle() {
        return brandTitle.getText().trim();
    }

    /**
     * Get popular products displayed on the Brand page
     * @return
     */
    public Map<String, WebElement> getPopularProducts() {
        Map<String, WebElement> popularProductsMap = new HashMap<>();

        for(WebElement element : popularProducts) {
            String title = element
                    .findElement(By.cssSelector("div.at-right-c"))
                    .getText().trim();
            popularProductsMap.put(title, element);
        }
        return popularProductsMap;
    }

    /**
     * Select a product from popular products list
     * @param name name of the product
     * @return Product page
     */
    public ProductPage selectPopularProduct(String name) {
        if (getPopularProducts().containsKey(name)) {
            WebElement element = getPopularProducts().get(name);
            element.findElement(By.cssSelector("div.at-right-c")).click();
            return new ProductPage(driver);
        } else {
            throw new IllegalArgumentException("Specified product name not found in the list: " + name);
        }
    }
}
