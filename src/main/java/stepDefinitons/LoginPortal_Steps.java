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

public class LoginPortal_Steps {
    private WebDriver driver;
    @Before
    public void setup() {
        //setupCromeDriver
        System.setProperty("web-driver.chrome.driver", System.getProperty("use.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown () {
        //closeChromeDriver
        driver.quit();
    }
    @Given("I access the webdriver university login portal page")
    public void i_access_the_webdriver_university_contact_us_page() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
        Thread.sleep(3000);
    }
    @When("I enter a first name of user name")
    public void i_enter_a_user_name() throws InterruptedException {
        driver.findElement(By.cssSelector("[placeholder=\"Username\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"Username\"]")).sendKeys("Joe");
        Thread.sleep(3000);
    }
    @And("I enter the user password")
    public void i_enter_the_password() throws InterruptedException {
        driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("Joe");
        Thread.sleep(3000);
    }

}
