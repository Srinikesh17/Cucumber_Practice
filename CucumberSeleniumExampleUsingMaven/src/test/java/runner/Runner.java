package runner;

import org.junit.runner.RunWith;
import cucumber.api.*;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="featureFiles/saucedemo.feature" ,
glue ="com.sauce.stepdefenitions")
public class Runner {

}
