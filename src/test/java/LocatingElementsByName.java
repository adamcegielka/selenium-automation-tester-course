import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatingElementsByName {

    @Test
    public void findElementByName() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

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

        // assert
        String inputValueBeforeClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("Adam", inputValueBeforeClear);

        firstNameInput.clear();

        // assert
        String inputValueAfterClear = firstNameInput.getAttribute("value");
        Assert.assertEquals("", inputValueAfterClear);

        driver.quit();
    }
}
