package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Driver;

import static util.Driver.getActions;
import static util.Driver.getDriver;

public class DarwinPage {

    @FindBy(xpath = "//div[@class='btn-content ml-1']//span")
    private static WebElement cookies;

    @FindBy(xpath = "//button[@class='menu-toggle']")
    private static WebElement toateCategoriile;

    @FindBy(xpath = "//a[@href='darwin.md/apple-category']")
    private static WebElement apple;

    @FindBy(xpath = "//a[@href='https://darwin.md/telefoane/smartphone/apple-iphone-13-pro-max']")
    private static WebElement iPhone13;


    @FindBy(xpath = "//a[@class='add_to_cart add_cart']")
    private static WebElement addToBusket;



    public static void initPage() {
        PageFactory.initElements(getDriver(), DarwinPage.class);
    }

    public static void clickCookies(){
        cookies.click();
    }
    public static void hoverToateCategoriile() {
       getActions().moveToElement(toateCategoriile).build().perform();

    }
    public static void hoverApple(){
        getActions().moveToElement(apple).build().perform();
    }

    public static void clickIPhone13(){
       iPhone13.click();
    }
    public static void clickAddToBusket(){
        addToBusket.click();
    }





   /* public static void clickXXX(String asdas){

        XXXXX.sendKeys();
    }*/

}
