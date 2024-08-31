import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZeroTemplateTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserDriverManager.getDriver("firefox");
        driver.get("http://seleniumdemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstNameTest() {}

    @Test
    public void secondNameTest() {}
}
