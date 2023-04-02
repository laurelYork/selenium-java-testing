package stepDefinitons;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import java.time.Duration;

public class Contact_Us_Steps {
    private WebDriver driver;
    @Before
    public void setup() {
        //setupCromeDriver
        System.setProperty("web-driver.chrome.driver", System.getProperty("use.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown () {
        //closeChromeDriver
        driver.quit();

    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        Thread.sleep(3000);
    }
    @When("I enter a first name")
    public void i_enter_a_first_name() throws InterruptedException {
        driver.findElement(By.cssSelector("[name=\"first_name\"]")).sendKeys("Joe");
        Thread.sleep(3000);

    }
    @And("I enter a last name")
    public void i_enter_a_last_name() throws InterruptedException {
        driver.findElement(By.cssSelector("[name=\"last_name\"]")).sendKeys("Blogs");
        Thread.sleep(3000);
    }
    @And("I enter an email address")
    public void i_enter_an_email_address() {
        driver.findElement(By.name("email")).sendKeys("aurel900104@gmail.com");
    }
    @And("I enter a comment")
    public void i_enter_a_comment()  {
        driver.findElement(By.name("message")).sendKeys("Some text to this field.");
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.cssSelector("[value=\"SUBMIT\"]")).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }

}
