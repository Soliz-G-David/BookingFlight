package bookflight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        bookFlightTest.search();
    }

    // Search for a flight between the selected cities
    public void search() throws InterruptedException {

        Select fromSelect = new Select(driver.findElement(By.name("fromPort")));
        fromSelect.selectByVisibleText("Boston");

        Select toSelect = new Select(driver.findElement(By.name("toPort")));
        toSelect.selectByVisibleText("Buenos Aires");

        WebElement buttonFindFlights = driver.findElement(By.cssSelector("input[value='Find Flights']"));
        buttonFindFlights.click();
        Thread.sleep(1000);
    }
}
