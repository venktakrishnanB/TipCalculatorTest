package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TipCalculatorFunctionalitySteps {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("I am on the Tip Calculator page")
    public void iamOnTheTipCalculatorPage(){
        driver.get("https://qatipcalc.ccbp.tech/");
    }
    @When("I click the 'Calculate' Button")
    public void iClickTheCalculateButton(){
        driver.findElement(By.id("calculateButton")).click();
    }
    @Then("an error message 'Please Enter a Valid Input.' should be visible")
    public void verifyFirstErrorMessage(){
        String errorTextOne = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorTextOne, "Please Enter a Valid Input.");
    }
    @When("I enter a invalid input")
    public void iEnterAInvalidInput(){
        driver.findElement(By.id("percentageTip")).sendKeys("10f");
        driver.findElement(By.id("calculateButton")).click();
        String errorTextTwo = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorTextTwo, "Please Enter a Valid Input.");
    }
    @When("I enter a valid input")
    public void iEnterAValidInput(){
        driver.findElement(By.id("billAmount")).sendKeys("1000");
        driver.findElement(By.id("percentageTip")).sendKeys("15");
        driver.findElement(By.id("calculateButton")).click();
    }
    @Then("I can view the expected tip calculation text")
    public void iViewExpectedTipAmount(){
        String expectedTotalAmount = driver.findElement(By.id("totalAmount")).getText();
        String expectedTipAmount = driver.findElement(By.id("tipAmount")).getText();
        Assert.assertEquals(expectedTotalAmount, "1150.00");
        Assert.assertEquals(expectedTipAmount, "150.00");
    }
}
