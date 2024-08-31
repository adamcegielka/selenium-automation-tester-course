import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserSetupTest {

    @Test
    public void openBookingPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Ustawienie trybu headless (bez otwierania okna przeglądarki)
        // options.setHeadless(true); // starsza wersja Selenium
        // w nowszych wersjach Selenium dla Chrome używa się addArguments("--headless");
        options.addArguments("--headless");

        // Start przeglądarki w trybie maksymalizowanym
        options.addArguments("--start-maximized");

        // Ustawienie niestandardowego rozmiaru okna
        options.addArguments("window-size=1200,800");

        // Uruchamianie przeglądarki w trybie incognito. Wszystkie sesje i ciasteczka są izolowane
        options.addArguments("--incognito");

        // Wyłącza natywne powiadomienia przeglądarki
        options.addArguments("--disable-notifications");

        // Wyłączenie trybu sandbox. Czasami potrzebne w środowiskach CI/CD
        options.addArguments("--no-sandbox");

        // Wyłączenie GPU (przydatne w trybie headless). Zmniejsza zasoby potrzebne do renderowania w trybie headless
        options.addArguments("--disable-gpu");

        // Pomijanie certyfikatów SSL. Przydatne w przypadku stron z problemami SSL
        options.addArguments("--ignore-certificate-errors");

        // Wyłącza dźwięk podczas pracy przeglądarki
        options.addArguments("--mute-audio");

        // Ustawienie lokalizacji (język, format daty itp.). Przydatne, do testów funkcji zależnej od lokalizacji
        options.addArguments("--lang=en-US");

        // Przeglądarka nie załaduje domyślnych rozszerzeń
        options.addArguments("--disable-extensions");

        // Tryb mobilny. Symuluje przeglądanie na urządzeniach mobilnych
        /*

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 375);
        deviceMetrics.put("height", 812);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X)");

        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        -- Wszystkie te opcje dodaje się do ChromeOptions w ten sposób:

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito", "--disable-notifications");
        // lub pojedynczo:
        options.addArguments("--headless");

        */

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.booking.com/");

        // driver.quit();
    }
}
