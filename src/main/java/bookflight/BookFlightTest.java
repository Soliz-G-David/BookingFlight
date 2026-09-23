package bookflight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookFlightTest {

    private WebDriver driver;

    // Initialize the browser and navigate to the application
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
    }

    public static void main(String[] args) throws InterruptedException {

        BookFlightTest bookFlightTest = new BookFlightTest();
        bookFlightTest.setUp();
    }
}
