/*
Задание 1
Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается
соответствующий текст. Важно написать отдельный тест на каждый вопрос.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.sprint4.FaqPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class) // добавили раннер Parameterized

public class FaqPageTest {
    // поля класса:
    private WebDriver driver;

    private final int answer; // текст, который передаётся в метод
    private final String expected; // ожидаемый результат

    // конструктор с параметрами
    public FaqPageTest(int answer, String expected) {
        this.answer = answer;
        this.expected = expected;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                        " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                        " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку" +
                        " по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете" +
                        " кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим." +
                        " Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    // тест
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkAnswer() {
        FaqPage fp = new FaqPage(driver);
        fp.open();
        String actual = fp.checkQuest(answer);
        assertEquals(expected, actual);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
