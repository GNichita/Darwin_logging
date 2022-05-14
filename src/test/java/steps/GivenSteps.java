package steps;

import Pages.DarwinPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;

import static util.Driver.getDriver;

public class GivenSteps {
    @Given("I navigate to Darwin homepage")
    public void givenINavigateToDarwinHomepage(){

       getDriver().get("https://darwin.md/");
        Driver.log.error("Sample ERROR message 1");
        Driver.log.info("Sample INFO message 1");
        Driver.log.warn("Sample WARN message 1");
    }
    @Given("I navigate to Darwin homepage 2")
    public void givenINavigateToDarwinHomepage2(){

        getDriver().get("https://darwin.md/");
        Driver.log.error("Sample ERROR message 2");
        Driver.log.info("Sample INFO message 2");
        Driver.log.warn("Sample WARN message 2");
    }



    }


