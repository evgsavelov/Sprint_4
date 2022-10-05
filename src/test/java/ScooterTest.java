import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.sprint4.AboutRent;
import ru.yandex.praktikum.sprint4.FaqPage;
import ru.yandex.praktikum.sprint4.InputInfo;
import ru.yandex.praktikum.sprint4.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.matchers.JUnitMatchers.containsString;

/*
Задание 1
Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается
соответствующий текст. Важно написать отдельный тест на каждый вопрос.
 */
public class ScooterTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void faqOne() {
        FaqPage faqPage = new FaqPage(driver);
        String answerOne = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerOne, faqPage.checkQuestOne());
    }

    @Test
    public void faqTwo() {
        FaqPage faqPage = new FaqPage(driver);
        String answerTwo = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                "можете просто сделать несколько заказов — один за другим.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerTwo, faqPage.checkQuestTwo());
    }

    @Test
    public void faqThree() {
        FaqPage faqPage = new FaqPage(driver);
        String answerThree = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerThree, faqPage.checkQuestThree());
    }

    @Test
    public void faqFour() {
        FaqPage faqPage = new FaqPage(driver);
        String answerFour = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerFour, faqPage.checkQuestFour());
    }

    @Test
    public void faqFive() {
        FaqPage faqPage = new FaqPage(driver);
        String answerFive = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку" +
                " по красивому номеру 1010.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerFive, faqPage.checkQuestFive());
    }

    @Test
    public void faqSix() {
        FaqPage faqPage = new FaqPage(driver);
        String answerSix = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете" +
                " кататься без передышек и во сне. Зарядка не понадобится.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerSix, faqPage.checkQuestSix());
    }

    @Test
    public void faqSeven() {
        FaqPage faqPage = new FaqPage(driver);
        String answerSeven = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                "Все же свои.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerSeven, faqPage.checkQuestSeven());
    }

    @Test
    public void faqEight() {
        FaqPage faqPage = new FaqPage(driver);
        String answerEight = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        faqPage.open();
        assertEquals("Ответ не совпадает", answerEight, faqPage.checkQuestEight());
    }




    /*
    Задание 2
    Заказ самоката. Весь флоу позитивного сценария.
     */

    @Test
    public void checkOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderTop();
        mainPage.downloadForWhomScooter();

        InputInfo inputInfo = new InputInfo(driver);
        inputInfo.login("Виктор", "Дуб", "Триумфальная арка 6", "Белорусская",
                "+79996666666");
        inputInfo.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.whenToBringScooter();
        aboutRent.clickCalendar();
        aboutRent.rentalPeriod();
        aboutRent.clickChoosingTheRentalTime();
        aboutRent.clickScooterColor();
        aboutRent.clickOrder();
        aboutRent.clickPlaceAnOrder();
        MatcherAssert.assertThat(aboutRent.isPopUpWindow(), containsString("Заказ оформлен"));
    }

    @Test
    public void checkOrderSecond() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderTop();
        mainPage.downloadForWhomScooter();

        InputInfo inputInfo = new InputInfo(driver);
        inputInfo.login("Виктория", "Тук", "Кутузовский проспект", "Белорусская",
                "+9054448833");
        inputInfo.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.whenToBringScooter();
        aboutRent.clickCalendar();
        aboutRent.rentalPeriod();
        aboutRent.clickChoosingTheRentalTime();
        aboutRent.clickScooterColor();
        aboutRent.clickOrder();
        aboutRent.clickPlaceAnOrder();
        MatcherAssert.assertThat(aboutRent.isPopUpWindow(), containsString("Заказ оформлен"));
    }

    @Test
    public void checkOrderMozilla() {
        driver = new FirefoxDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderTop();
        mainPage.downloadForWhomScooter();

        InputInfo inputInfo = new InputInfo(driver);
        inputInfo.login("Emmet", "Reverb", "Sunset hill 3", "Белорусская",
                "+9064448833");
        inputInfo.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.whenToBringScooter();
        aboutRent.clickCalendar();
        aboutRent.rentalPeriod();
        aboutRent.clickChoosingTheRentalTime();
        aboutRent.clickScooterColor();
        aboutRent.clickOrder();
        aboutRent.clickPlaceAnOrder();
        MatcherAssert.assertThat(aboutRent.isPopUpWindow(), containsString("Заказ оформлен"));
    }

    @Test
    public void checkOrderMozillaSecond() {
        driver = new FirefoxDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderTop();
        mainPage.downloadForWhomScooter();

        InputInfo inputInfo = new InputInfo(driver);
        inputInfo.login("Maria", "Pagozi", "Ilaria  st 5", "Белорусская",
                "+9065558833");
        inputInfo.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.whenToBringScooter();
        aboutRent.clickCalendar();
        aboutRent.rentalPeriod();
        aboutRent.clickChoosingTheRentalTime();
        aboutRent.clickScooterColor();
        aboutRent.clickOrder();
        aboutRent.clickPlaceAnOrder();
        MatcherAssert.assertThat(aboutRent.isPopUpWindow(), containsString("Заказ оформлен"));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}



