package Test;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class Steps extends BaseUtil {

    private BaseUtil baseUtil;

    public Steps (BaseUtil util) {
        this.baseUtil = util;


    }

    private WebDriver driver ;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//erdinc//Documents//TestAutomation//selenium-webDriver//chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("^I am in the login page of the Para Bank Application$")
    public void iAmInTheLoginPageOfTheParaBankApplication() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }

    @When("^I enter valid {string} and {string} with {String}")
    public void iEnterValidCredentials(String username, String password, String userFullName1) {

        baseUtil.userFullName = userFullName1;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("^I should be taken to the Overview page$")
    public void iShouldBeTakenToTheOverviewPage() throws Exception{
        Thread.sleep(5000);

        String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
        System.out.println(baseUtil.userFullName.toString());
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));

        driver.findElement(By.linkText("Log out")).click();

    }

    @After
    public void quitBrowser() {
        driver.quit ();
    }
}
