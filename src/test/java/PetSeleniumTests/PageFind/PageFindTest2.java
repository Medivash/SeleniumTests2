package PetSeleniumTests.PageFind;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFindTest2 {

    protected WebDriver driver;

    @Test
    public void testCoggleTitle() {
        driver.get("https://github.com/");
        System.out.println("Найдена страница: " + driver.getTitle());
    }

    @Test
    public void testGithubLogin() {
        driver.get("https://github.com/login");

        driver.findElement(By.id("login_field")).sendKeys("lucko01@bk.ru");
        driver.findElement(By.id("password")).sendKeys("dima2001D");
        driver.findElement(By.name("commit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement profileMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[@aria-label='View profile and more']"))
        );

        Assert.assertTrue(profileMenu.isDisplayed(), "Не удалось подтвердить успешную авторизацию на GitHub.");
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