import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.sprint4.AboutRent;
import ru.yandex.praktikum.sprint4.InputInfo;
import ru.yandex.praktikum.sprint4.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // добавили раннер Parameterized

/*
    Задание 2
    Заказ самоката. Весь флоу позитивного сценария.
     */

public class OrderTest {
    // поля класса:
    private WebDriver driver;
    private String button;
    private String userName;
    private String surName;
    private String metroStation;
    private String address;
    private String telephoneNumber;
    private String result;
    private String date;
    private String color;
    private String comment;

    public OrderTest(String button, String userName, String surName, String metroStation, String address,
                     String telephoneNumber, String result, String date, String color, String comment) {
        this.button = button;
        this.userName = userName;
        this.surName = surName;
        this.metroStation = metroStation;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.result = result;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Верхняя", "Виктор", "Дуб", "Белорусская", "Триумфальная арка 6", "79996666666", "Заказ оформлен",
                        "25.10.2022", "чёрный жемчуг", "лифт не работает"},
                {"Нижняя", "Виктория", "Тук", "Белорусская", "Кутузовский проспект", "89054448833", "Заказ оформлен",
                        "25.11.2023", "серая безысходность", "домофон не работает"},


        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    public void checkOrder() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrder(button);

        InputInfo inputInfo = new InputInfo(driver);
        inputInfo.setUsername(userName);
        inputInfo.setSurName(surName);
        inputInfo.setAddressHouse(address);
        inputInfo.setMetroStation(metroStation);
        inputInfo.setTelephoneNumber(telephoneNumber);
        inputInfo.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.setDate(date);
        aboutRent.rentalPeriod();
        aboutRent.clickChoosingTheRentalTime();
        aboutRent.clickScooterColor(color);
        aboutRent.sendComment(comment);
        aboutRent.clickOrder();
        aboutRent.clickPlaceAnOrder();
        assertEquals(result, aboutRent.isPopUpWindow());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
