package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс главной страницы
public class HomePage {

    private WebDriver driver;


    // первая кнопка заказать
    private final By buttonOrderFirst = By.className("Button_Button__ra12g");
    // вторая кнопка заказать
    private final By buttonOrderSecond = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    // кнопка принятия кук
    private final By buttonCookiesYes = By.id("rcc-confirm-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для одобрения кук
    public void clickCookiesYes() {
        driver.findElement(buttonCookiesYes).click();

    }


    // метод для получения текста из списка "О важном"
    public String checkTextSelect(int index) {
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-" + index + "']")).getText();

    }

    // метод для клика по списку "О важном"
    public void clickSelect(int index) {
        WebElement element = driver.findElement(By.xpath(".//div[@id='accordion__heading-" + index + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[@id='accordion__heading-" + index + "']")).click();
        new WebDriverWait(driver, 1);
    }

    // метод для клика по первой кнопке "Заказать"
    public void clickOrder(int Num) {
        if (Num == 1) {
            driver.findElement(buttonOrderFirst).click();
        } else if (Num == 2) {
            WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(buttonOrderSecond).click();
        }
    }

}
