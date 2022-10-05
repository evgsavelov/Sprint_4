package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс страницы "Про аренду"
public class AboutRent {
    private final WebDriver driver;

    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }

    // локатор для поля "Когда привезти самокат"
    public By whenToBringScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор для календаря и даты
    public By calendar = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--008 " +
            "react-datepicker__day--weekend']");
    // локатор для срока аренды
    public By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор для выбора времени аренды
    public By choosingTheRentalTime = By.xpath(".//div[@class='Dropdown-option']");
    // локатор для цвета
    public By scooterColor = By.id("black");
    // локатор для кнопки "Заказать"
    public By order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для кнопки "Да"
    public By placeAnOrder = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    public By popUpWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // метод для поля "* Когда привезти самокат"
    public void whenToBringScooter() {
        driver.findElement(whenToBringScooter).click();
    }

    // метод выбора даты
    public void clickCalendar() {
        driver.findElement(calendar).click();
    }

    // метод для клика по полю "Срок аренды"
    public void rentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    // метод для выбора срока аренды
    public void clickChoosingTheRentalTime() {
        driver.findElement(choosingTheRentalTime).click();
    }

    // метод для выбора цвета
    public void clickScooterColor() {
        driver.findElement(scooterColor).click();
    }

    // метод для кнопки "Заказать"
    public void clickOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(order)).click();
    }

    // метод для кнопки "Заказать"
    public void clickPlaceAnOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(placeAnOrder)).click();
    }

    public String isPopUpWindow() {
        return driver.findElement(popUpWindow).getText();
    }
}
