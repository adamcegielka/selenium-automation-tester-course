import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01SeleniumDemoCom {

    @Test
    public void findSeleniumProduct() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://seleniumdemo.com/");

        // by xpath
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(seleniumProduct.isDisplayed());
        driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']")).click();
        WebElement nameSeleniumProduct = driver.findElement(By.xpath("//span[text()='Selenium Demo Page']"));
        Assert.assertTrue(nameSeleniumProduct.isDisplayed());

        // by css selector
        driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt")).click();
        driver.findElement(By.cssSelector(".button.wc-forward")).click();

        // by link text
        WebElement checkProductInCart = driver.findElement(By.linkText("Java Selenium WebDriver"));
        Assert.assertTrue(checkProductInCart.isDisplayed());

        driver.quit();
    }
}
