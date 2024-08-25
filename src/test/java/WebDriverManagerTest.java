import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrawser() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // open Booking.com page
        driver.get("https://www.booking.com/");
        // increase window to maximum
        driver.manage().window().maximize();
        // decrease window
        Dimension windowSize = new Dimension(600, 800);
        driver.manage().window().setSize(windowSize);
        // close the window
        driver.quit();
    }
}

/*
WebDriverManager

<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>

Links:
- https://github.com/bonigarcia/webdrivermanager
- https://bonigarcia.dev/webdrivermanager/
 */