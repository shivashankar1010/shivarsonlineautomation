package com.rsonline.test;



import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.rsonline.pages.BrandPage;
import com.rsonline.pages.HomePage;
import com.rsonline.pages.ProductPage;
import com.rsonline.pages.SearchItem;
import com.rsonline.pages.SearchResultsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static sun.plugin.javascript.navig.JSType.Link;

public class StepDefs {

    WebDriver driver;

   /* HomePage homePage;
    BrandPage brandPage;
    ProductPage productPage;
    //ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    SearchItem searchItem;

    String productName;
    String price;
    String qty;*/

    public StepDefs() {
        this.driver = Hooks.getDriver();
    }



    @Given("^I am on the category page$")
    public void i_am_on_the_category_page() throws Throwable {

        driver.get("https://uk.rs-online.com/web/generalDisplay.html?id=new");
        String expectedtitle =  "  | RS Components";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("expectedtitle","actualTitle");//RS Components
        System.out.println(("Test is pass"));

    }

    @When("^I select a Connectors from category panel$")
    public void i_select_a_Connectors_from_category_panel() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"campaign-page-wrap\"]/div[2]/div[1]/div/div/div/a[7]"));

    }

    @Then("^I should be taken to the connectors screen$")
    public void i_should_be_taken_to_the_connectors_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String ExpectedConnectortitle = "Connectors | RS Components";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals("Expectedconnectortitle","ActualTitle");
        System.out.println(("Connector test is pass"));


    }

    @When("^I select a Cables-wires from category panel$")
    public void i_select_a_Cables_wires_from_category_panel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#campaign-page-wrap > div.row > div.col-sm-12.col-md-3 > div > div > div > a:nth-child(6)")).click();

    }

    @Then("^I should be taken to the cables-wires screen$")
    public void i_should_be_taken_to_the_cables_wires_screen() throws Throwable {

        // Write code here that turns the phrase above into concrete actions

        String ExpectedCabletitle = "Cables &amp; Wires | RS Components";
        String ActualcableTitle = driver.getTitle();
        Assert.assertEquals("Expectedcabletitle","ActualcableTitle");
        System.out.println(("Connector test is pass"));

    }

    @When("^I select a 'Connectors' from All products dropdown$")
    public void i_select_a_Connectors_from_All_products_dropdown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/ul/li[1]/ul/li[3]/a")).click();
        String pageSource = driver.getPageSource();
        boolean isTheTextPresent = driver.getPageSource().contains("Shop our range of Connectors supplies &amp; accessories. Free Next Day Delivery. Get the latest deals on Connectors.");
        assertTrue(isTheTextPresent);
    }

    @When("^I select a 'Cables-wires' from All products dropdown$")
    public void i_select_a_Cables_wires_from_All_products_dropdown() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]/ul/li[11]/a")).click();
        String pageSource = driver.getPageSource();
        boolean isTheTextPresent = driver.getPageSource().contains("cables & wires");
        assertTrue(isTheTextPresent);

    }

}
