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
        bookFlightTest.selectTravel();
        bookFlightTest.payTravel();
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

    // Select the first available flight
    public void selectTravel() throws InterruptedException {

        WebElement firstOption = driver.findElements(By.cssSelector("input.btn-small")).get(0);
        firstOption.click();

        Thread.sleep(1000);
    }

    // Complete the passenger and payment information
    public void payTravel() throws InterruptedException {

        WebElement nameInput = driver.findElement(By.id("inputName"));
        nameInput.sendKeys("David");

        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("Street colibri and Ruisenor Avenue");

        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("Cochabamba");

        WebElement stateInput = driver.findElement(By.id("state"));
        stateInput.sendKeys("Cercado");

        WebElement zipCodeInput = driver.findElement(By.id("zipCode"));
        zipCodeInput.sendKeys("1234");

        Select cardTypeSelect = new Select(driver.findElement(By.id("cardType")));
        cardTypeSelect.selectByVisibleText("Visa");

        WebElement creditCardNumberInput = driver.findElement(By.id("creditCardNumber"));
        creditCardNumberInput.sendKeys("890089890890890");

        WebElement monthInput = driver.findElement(By.id("creditCardMonth"));
        monthInput.sendKeys("January");

        WebElement yearInput = driver.findElement(By.id("creditCardYear"));
        yearInput.sendKeys("2028");

        WebElement nameCreditCardInput = driver.findElement(By.id("nameOnCard"));
        nameCreditCardInput.sendKeys("David Soliz Garcia");

        WebElement rememberCheck = driver.findElement(By.id("rememberMe"));

        if (!rememberCheck.isSelected()) {
            rememberCheck.click();
        }
        // Submit the purchase
        WebElement purchaseButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        purchaseButton.click();
    }

}
