package com.sauce.stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagelocators {
	WebDriver driver;
	public static WebElement login_username(WebDriver driver){
		return driver.findElement(By.id("user-name"));
	}
	
	public static WebElement login_password(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	
	public static WebElement login_button(WebDriver driver) {
		return driver.findElement(By.id("login-button"));
	}
	
	public static WebElement page_span_title(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='title']"));
	}
	
	public static WebElement menu_button(WebDriver driver) {
		return driver.findElement(By.id("react-burger-menu-btn"));
	}
	
	public static WebElement logout_button(WebDriver driver) {
		return driver.findElement(By.id("logout_sidebar_link"));
	}
	
	public static WebElement add_to_cart(WebDriver driver, String item_name) {
		return driver.findElement(By.id("add-to-cart-sauce-labs-"+item_name+""));
	}
	
	public static WebElement shopping_link(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	}
	
	public static WebElement remove_item(WebDriver driver, String remove_item) {
		return driver.findElement(By.id("remove-sauce-labs-"+remove_item+""));
	}
	
	public static WebElement checkout_btn(WebDriver driver) {
		return driver.findElement(By.id("checkout"));
	}
	
	public static WebElement first_name(WebDriver driver) {
		return driver.findElement(By.id("first-name"));
	}
	
	public static WebElement last_name(WebDriver driver) {
		return driver.findElement(By.id("last-name"));
	}
	
	public static WebElement postal_code(WebDriver driver) {
		return driver.findElement(By.id("postal-code"));
	}
	
	public static WebElement continue_btn(WebDriver driver) {
		return driver.findElement(By.id("continue"));
	}
	
	public static WebElement finish_btn(WebDriver driver) {
		return driver.findElement(By.id("finish"));
	}
	
	public static WebElement success_message(WebDriver driver, String success_msg) {
		return driver.findElement(By.xpath("//h2[@class='complete-header']"));
	}
	
	public static WebElement total_value(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='summary_info_label summary_total_label']"));
	}

}

