package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// Класс главной страницы
public class HomePage {

    private WebDriver driver;

    // первая кнопка заказать
    private final By buttonOrderFirst = By.className("Button_Button__ra12g");

    // вторая кнопка заказать
    private final By buttonOrderSecond = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");


    public HomePage(WebDriver driver) {
        this.driver = driver;
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

    }

    // метод для клика по первой кнопке "Заказать"
    public void clickOrderFirst() {
        driver.findElement(buttonOrderFirst).click();
    }

    // метод для клика по второй кнопке "Заказать"
    public void clickOrderSecond() {
        driver.findElement(buttonOrderSecond).click();
    }
}
