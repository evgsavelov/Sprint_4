package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public By WHEN_TO_BRING_SCOOTER = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор для срока аренды
    public By RENTAL_PERIOD = By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор для выбора времени аренды
    public By CHOOSING_THE_RENTAL_TIME = By.xpath(".//div[@class='Dropdown-option']");
    // локатор для цвета
    public By SCOOTER_COLOR_BLACK = By.id("black");
    public By SCOOTER_COLOR_GREY = By.id("grey");
    // локатор для кнопки "Заказать"
    public By ORDER = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    // локатор для кнопки "Да"
    public By PLACE_AN_ORDER = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    // комметарий для курьера
    private final By COMMENT_FOR_THE_DELIVERY_MANAGER = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    public By POPUPWINDOW = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // метод для поля "* Когда привезти самокат"
    public void whenToBringScooter() {
        driver.findElement(WHEN_TO_BRING_SCOOTER).click();
    }

    // метод выбора даты
    public void setDate(String date) {
        driver.findElement(WHEN_TO_BRING_SCOOTER).sendKeys(date);
        driver.findElement(WHEN_TO_BRING_SCOOTER).sendKeys(Keys.ENTER);
    }

    // метод для клика по полю "Срок аренды"
    public void rentalPeriod() {
        driver.findElement(RENTAL_PERIOD).click();
    }

    // метод для выбора срока аренды
    public void clickChoosingTheRentalTime() {
        driver.findElement(CHOOSING_THE_RENTAL_TIME).click();
    }

    public void clickScooterColor(String color) {
        if (color.equals("чёрный жемчуг"))
            driver.findElement(SCOOTER_COLOR_BLACK).click();
        else if (color.equals("серая безысходность"))
            driver.findElement(SCOOTER_COLOR_GREY).click();
    }

    // метод для кнопки "Заказать"
    public void clickOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(ORDER)).click();
    }

    // метод для кнопки "Заказать"
    public void clickPlaceAnOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(PLACE_AN_ORDER)).click();
    }

    public String isPopUpWindow() {
        return driver.findElement(POPUPWINDOW).getText();
    }

    public void sendComment(String comment) {
        driver.findElement(COMMENT_FOR_THE_DELIVERY_MANAGER).sendKeys(comment);
    }
}
