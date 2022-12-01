import pages.OrderPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


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
    private final int num_button_order; //номер кнопки заказа

    final String link = "https://qa-scooter.praktikum-services.ru/"; //ссылка на сайт

    WebDriver driver = new ChromeDriver();


    public TestFormRentScooterToFinal(String name, String lastname, String adress, String metro, String telephone, String date, String dropdown, String color_scooter, String comment, int num_button_order) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.metro = metro;
        this.telephone = telephone;
        this.date = date;
        this.dropdown = dropdown;
        this.color_scooter = color_scooter;
        this.comment = comment;
        this.num_button_order = num_button_order;
    }


    // Тестовые данные для Формы аренды Скутера
    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {"Владислав", "Колягин", "улица Колотушкина", "Сокольники", "88005553535", "25.11.2022", "2", "black", "blabla", 2},
                {"Виктор", "Жмышенко", "улица Православная", "Черкизовская", "88005553535", "27.11.2022", "1", "grey", "coomentare", 1},
        };
    }


    // положительный тест проверки формы аренды заказа
    @Test
    public void checkSelectAboutImportant() {
        driver.get(link);
        HomePage objHomePage = new HomePage(driver);
        OrderPage objOrderPage = new OrderPage(driver);
        objHomePage.clickCookiesYes();
        objHomePage.clickOrder(num_button_order);
        objOrderPage.sendKeysOrderForm(name, lastname, adress, metro, telephone);
        objOrderPage.sendKeysRentForm(date, dropdown, color_scooter, comment);
        objOrderPage.checkOrderVerificationCompleted();
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}

