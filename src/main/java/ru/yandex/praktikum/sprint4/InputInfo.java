package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputInfo {
    private final WebDriver driver;

    // локатор имя
    private By FIRST_NAME = By.xpath(".//input[@placeholder='* Имя']");
    // локатор фамилия
    private By LAST_NAME = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор адрес
    private By ADRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор станция метро
    private By METRO = By.className("select-search__input");
    // выпадающий список
    private By DROPDOWN_LIST = By.xpath(".//li[@class='select-search__row']");
    // локатор телефон
    private By TELEPHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка далее
    private By NEXT = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public InputInfo(WebDriver driver) {
        this.driver = driver;
    }

    //методы для заполнения формы
    public void setUsername(String userName) {
        driver.findElement(FIRST_NAME).sendKeys(userName);
    }

    public void setSurName(String surName) {
        driver.findElement(LAST_NAME).sendKeys(surName);
    }

    public void setAddressHouse(String address) {
        driver.findElement(ADRESS).sendKeys(address);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(METRO).sendKeys(metroStation);
        driver.findElement(DROPDOWN_LIST).click();

    }

    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(TELEPHONE).sendKeys(telephoneNumber);
    }

    public void clickNextButton() {

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(NEXT)).click();
    }
}
