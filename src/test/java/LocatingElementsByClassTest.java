import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatingElementsByClassTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserDriverManager.getDriver("firefox");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // first method
    @Test
    public void firstTestMethod() {
        driver.findElement(By.className("topSecret"));
    }

    // second method
    @Test
    public void secondTestMethod() {
        WebElement paraHidden = driver.findElement(By.className("topSecret"));
    }

    // third method
    @Test
    public void thirdTestMethod() {
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);
    }
}
