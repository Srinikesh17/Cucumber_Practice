package com.sauce.stepdefenitions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pageaction extends Pagelocators {
	WebDriver driver;
@Given("^I open the saucedemo login page$")
public void i_open_the_saucedemo_login_page() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	//WebDriverManager.firefoxdriver().setup();
	//driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com");
}

@When("^I wait for the page to load$")
public void i_wait_for_the_page_to_load1() throws InterruptedException {
	Thread.sleep(2000);
}

@When("^I provide username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void i_provide_username_as_and_password_as1(String username, String password) {
	Pagelocators.login_username(driver).sendKeys(username);
	Pagelocators.login_password(driver).sendKeys(password);
}

@When("^I click on login button$")
public void i_click_on_login_button1() {
	Pagelocators.login_button(driver).click();
}


@Then("^the \"([^\"]*)\" page should be displayed$")
public void the_page_should_be_displayed(String text) throws InterruptedException {
	String actual_text = Pagelocators.page_span_title(driver).getText();
	if(actual_text.equalsIgnoreCase(text)) {
		System.out.println(text + " page is displayed");
	}
	else
	{
		System.out.println(text + " page is not displayed");
		driver.close();
	}
    
}

@When("^I click the menu button$")
public void i_click_the_menu_button()  {
	Pagelocators.menu_button(driver).click();
}

@When("^I click the logout link$")
public void i_click_the_logout_link() throws InterruptedException  {
	Pagelocators.logout_button(driver).click();
}

@When("I select the {string} into AddToCart")
public void i_select_the_into_add_to_cart(String item_name) {
	Pagelocators.add_to_cart(driver,item_name).click();
   
}

@When("I click the ShoppingCart link")
public void i_click_the_shopping_cart_link() {
	Pagelocators.shopping_link(driver).click();
}

@When("I remove the {string} from the cart")
public void i_remove_the_from_the_cart(String remove_item) throws InterruptedException {
	Pagelocators.remove_item(driver,remove_item).click();
}

@When("I proceed to the Checkout")
public void i_proceed_to_the_checkout() {
	Pagelocators.checkout_btn(driver).click();
}

@When("I enter the firstname {string} in the checkout information page")
public void i_enter_the_firstname_in_the_checkout_information_page(String firstname) {
	Pagelocators.first_name(driver).sendKeys(firstname);
}

@When("I enter the lastname {string} in the checkout information page")
public void i_enter_the_lastname_in_the_checkout_information_page(String lastname) {
	Pagelocators.last_name(driver).sendKeys(lastname);
}

@When("I enter the zip code {string} in the checkout information page")
public void i_enter_the_zip_code_in_the_checkout_information_page(String zip_code) {
	Pagelocators.postal_code(driver).sendKeys(zip_code);
}

@When("I click the continue button in the checkout information page")
public void i_click_the_continue_button_in_the_checkout_information_page() throws InterruptedException {
	Pagelocators.continue_btn(driver).click();    
}

@When("I click the finish button in the Checkout Overview page")
public void i_click_the_finish_button_in_the_checkout_overview_page() {
	Pagelocators.finish_btn(driver).click();
}

@Then("the order is placed and the page shout have the text {string}")
public void the_order_is_placed_and_the_page_shout_have_the_text(String success_msg) {
	String actual_success_message = Pagelocators.success_message(driver, success_msg).getText();
	if(actual_success_message.equalsIgnoreCase(success_msg)) {
		System.out.println(success_msg + " message is displayed");
	}
	else
	{
		System.out.println(success_msg + "message is not displayed");
		driver.close();
	}
	 
}
@When("I verify the order values are between {double} to {double} dollars")
public void i_verify_the_order_values_are_between_to_dollars(Double double1, Double double2) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	String total_value_string = Pagelocators.total_value(driver).getText();
	String removed_char = total_value_string.replaceAll("[^0-9]", " ");
    String Convert_str	= removed_char.trim().replace(" ", ".");
    Double total_value = Double.valueOf(Convert_str);
    System.out.println(total_value);
    if (total_value>=double1 && total_value<=double2) {
    	System.out.println("The total value is between 30$ to 60$");
    }
    	else {
    		System.out.println("The total value is not under 30$ to 60$ range");
    		driver.close();	
    	}
    }

@Then("^I Close the browser$")
public void i_Close_the_browser() {
	driver.close();
}

}
