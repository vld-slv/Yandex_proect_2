import Pages.OrderPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Parameterized.class)
public class TestFormRentScooterToFinal {

    private final String name; //имя
    private final String lastname; //фамилия
    private final String adress; //адрес
    private final String metro; //станция метро
    private final String telephone; //номер телефона
    private final String date; // дата заказа
    private final String dropdown; //срок аренды
    private final String color_scooter; //цвет скутера
    private final String comment; //комментарий

    WebDriver driver = new ChromeDriver();



    public TestFormRentScooterToFinal(String name, String lastname, String adress, String metro, String telephone, String date, String dropdown, String color_scooter, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.metro = metro;
        this.telephone = telephone;
        this.date = date;
        this.dropdown = dropdown;
        this.color_scooter = color_scooter;
        this.comment = comment;
    }


    // Тестовые данные для Формы аренды Скутера
    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {"Владислав", "Колягин", "улица Колотушкина", "Сокольники", "88005553535", "22.11.2022", "2", "black", "blabla"},
        };
    }


    // положительный тест проверки формы аренды заказа
    @Test
    public void checkSelectAboutImportant() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        OrderPage objOrderPage = new OrderPage(driver);
        objHomePage.clickOrderFirst();
        objOrderPage.sendKeysOrderForm(name, lastname, adress, metro, telephone);
        objOrderPage.sendKeysRentForm(date, dropdown, color_scooter, comment);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}

