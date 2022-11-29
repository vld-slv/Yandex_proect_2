import org.openqa.selenium.JavascriptExecutor;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;




    @RunWith(Parameterized.class)
    public class TestCheckImportantForm {

        private final String actual;
        private final int index;

        WebDriver driver = new ChromeDriver();


        public TestCheckImportantForm(String actual, int index) {
            this.actual = actual; //ожидаемый результь
            this.index = index; // индекс сравниваемой строки
        }

        // Тестовые данные для теста списка "О важном"
        @Parameterized.Parameters
        public static Object[][] getTextSelect() {
            return new Object[][]{
                    {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                    {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                    {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
            };
        }


        @Test
        public void checkSelectAboutImportant() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePage objHomePage = new HomePage(driver);
            objHomePage.clickSelect(index);
            MatcherAssert.assertThat(actual, is(objHomePage.checkTextSelect(index)));


        }

        @After
        public void tearDown() {
            // Закрыть браузер
            driver.quit();
        }
    }
