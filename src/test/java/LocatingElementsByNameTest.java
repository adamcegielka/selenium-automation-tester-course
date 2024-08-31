import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatingElementsByNameTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByName() {

        // first method:
        driver.findElement(By.name("fname")).sendKeys("Piotr");
        driver.findElement(By.name("fname")).clear();

        // second method:
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        firstNameInput2.sendKeys("Ewa");
        firstNameInput2.clear();

        // third method
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);
        firstNameInput.sendKeys("Adam");

        // assert before clear
        String inputValueBeforeClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("Adam", inputValueBeforeClear);

        firstNameInput.clear();

        // assert after clear
        String inputValueAfterClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("", inputValueAfterClear);
    }

    @Test
    public void findElementByNameOptimized() {

        // Using a single WebElement instance for all operations
        WebElement firstNameInput = driver.findElement(By.name("fname"));

        firstNameInput.sendKeys("Piotr");
        firstNameInput.clear();

        firstNameInput.sendKeys("Ewa");
        firstNameInput.clear();

        firstNameInput.sendKeys("Adam");

        // assert before clear
        String inputValueBeforeClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("Adam", inputValueBeforeClear);

        firstNameInput.clear();

        // assert after clear
        String inputValueAfterClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("", inputValueAfterClear);
    }
}
