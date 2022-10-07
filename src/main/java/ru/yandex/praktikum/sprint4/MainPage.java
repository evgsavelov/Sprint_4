package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс Главной страницы
public class MainPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // локатор для кнопки "Заказать" вверху
    private final static By ORDER_TOP = By.cssSelector("button.Button_Button__ra12g");
    // локатор для кнопки "Заказать" внизу
    private final static By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g " +
            "Button_Middle__1CSJM']");
    // локатор для ожидания
    private By pagForWhomIsScooter = By.xpath(".//div[@class='Order_Content__bmtHS']");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для перехода по URL
    public void open() {
        driver.get(PAGE_URL);
    }

    //метод кликнуть по кнопке Заказать вверху
    public void clickOrder(String button) {
        if (button.equals("Верхняя"))
            driver.findElement(ORDER_TOP).click();
        else if (button.equals("Нижняя")) {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ORDER_BUTTON));
            driver.findElement(ORDER_BUTTON).click();
        }
    }

    //метод ожидания загрузки страницы
    public void downloadForWhomScooter() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(pagForWhomIsScooter));
    }
}
