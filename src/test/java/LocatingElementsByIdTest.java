import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatingElementsByIdTest {

    @Test
    public void findElementById() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // first method:
        driver.findElement(By.id("clickOnMe")).click();
        Alert alert1Off = driver.switchTo().alert();
        alert1Off.accept();

        // second method:
        WebElement clickOnMeButton2 = driver.findElement(By.id("clickOnMe"));
        clickOnMeButton2.click();
        Alert alert2Off = driver.switchTo().alert();
        alert2Off.accept();

        // third method
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        clickOnMeButton.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Hello world!", alertText);

        alert.accept();

        driver.quit();
    }
}
