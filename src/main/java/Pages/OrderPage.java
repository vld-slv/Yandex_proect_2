package Pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.*;

import static org.hamcrest.CoreMatchers.is;

public class OrderPage {

    private WebDriver driver;

    // локатор строки Имя
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");

    // локатор строки Фамилия
    private final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор строки Адресс
    private final By inputAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор строки Метро
    private final By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");

    // локатор строки Метро
    private final By inputTelNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор кнопки далее
    private final By buttonNext = By.xpath(".//button[text()='Далее']");

    // локатор строки дата аренда самоката
    private final By dateRentScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // локатор строки время аренды
    private final By rentTime = By.xpath(".//div[@class='Dropdown-placeholder']");

    // локатор строки комментарий
    private final By commentary = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор кнопки заказать
    private final By buttonOrder = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор кнопки да
    private final By buttonYes = By.xpath(".//button[text()='Да' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор финальной надписи
    private final By textSuccess = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод заполнения формы "О себе"
    // Дорогой ревьюер, как делать правильней, в одном методе собрать кучу действий
    // или для каждого действия отдельный метод ?
    public void sendKeysOrderForm(String name, String lastname, String adress, String metro, String telephone) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputLastName).sendKeys(lastname);
        driver.findElement(inputAdress).sendKeys(adress);
        driver.findElement(inputMetro).sendKeys(metro);
        driver.findElement(By.xpath(".//div[text()='" + metro + "']/parent::button")).click();
        driver.findElement(inputTelNumber).sendKeys(telephone);
        driver.findElement(buttonNext).click();
    }

    // метод заполнения формы "Аренда самоката"
    public void sendKeysRentForm(String date, String dropdown, String color_scooter, String comment) {
        driver.findElement(dateRentScooter).sendKeys(date);
        driver.findElement(dateRentScooter).sendKeys(Keys.ENTER);
        driver.findElement(rentTime).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[" + dropdown + "]")).click();
        driver.findElement(By.xpath(".//input[@id='" + color_scooter + "']")).click();
        driver.findElement(commentary).sendKeys(comment);
        driver.findElement(buttonOrder).click();
        driver.findElement(buttonYes).click();
        MatcherAssert.assertThat("Заказ оформлен", is(driver.findElement(textSuccess).getText()));
    }

}
