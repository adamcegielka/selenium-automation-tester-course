import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CloseWindowTest {

    @Test
    public void openBookingPage() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // got to Booking.com Page
        driver.get("https://www.booking.com/");

        // Open a new window Wizzair
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://wizzair.com/', '_blank', 'height=400,width=600');");

        // Closes only the current window
        driver.close();

        // Closes all windows and terminates the WebDriver session
        // driver.quit();
    }
}
