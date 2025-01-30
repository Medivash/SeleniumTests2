import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ElectTest {
    @Test
    public void testCoggleTitle() {
        // Установка пути к chromedriver
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        // Настройка опций Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Разрешить все origins
        options.addArguments("--no-sandbox"); // Отключить sandbox
        options.addArguments("--disable-dev-shm-usage"); // Отключить использование /dev/shm

        // Создание экземпляра WebDriver с опциями
        WebDriver driver = new ChromeDriver(options);

        // Открытие страницы Google
        driver.get("https://www.google.com");

        // Вывод заголовка страницы
        System.out.println("Заголовок страницы: " + driver.getTitle());

        // Закрытие браузера
        driver.quit();

        System.out.println("Проверка GIT");
        System.out.println("Проверка GIT2");
    }
}