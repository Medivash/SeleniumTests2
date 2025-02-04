package siginExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElectTest{
    @FindBy(xpath = " /html/body/div[1]/div[3]/header/div/div[1]/div[2]/a")
    private WebElement siginBtn;

    protected WebDriver driver;
    @Test
    public void testCoggleTitle() {
        driver.get("https://github.com/");
        System.out.println("Найдена страница: " + driver.getTitle());
        System.out.println("git");
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Разрешить все origins
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}