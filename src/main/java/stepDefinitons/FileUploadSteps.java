package stepDefinitons;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUploadSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the File Upload page")
    public void i_am_on_the_file_upload_page() {
        driver.get("https://webdriveruniversity.com/File-Upload/index.html");
    }

    @When("I select a file to upload")
    public void i_select_a_file_to_upload() {
        WebElement fileUploadField = driver.findElement(By.id("file-upload"));
        fileUploadField.sendKeys("/path/to/file.txt");
    }

    @When("I click the Upload button")
    public void i_click_the_upload_button() {
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'File Uploaded!')]"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Then("the uploaded file should be displayed on the page")
    public void the_uploaded_file_should_be_displayed_on_the_page() {
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals("file.txt", uploadedFile.getText());
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Error')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("I select a file that exceeds the maximum file size")
    public void i_select_a_file_that_exceeds_the_maximum_file_size() {
        WebElement fileUploadField = driver.findElement(By.id("file-upload"));
        fileUploadField.sendKeys("/path/to/large-file.txt");
    }

    @When("I click the Clear button")
    public void i_click_the_clear_button() {
        WebElement clearButton = driver.findElement(By.id("file-submit"));
        clearButton.click();
    }
}
