package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputInfo {
    private final WebDriver driver;
    // локатор имя
    private By firstName = By.xpath(".//input[@placeholder='* Имя']");
    // локатор фамилия
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор адрес
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор станция метро
    private By metro = By.className("select-search__input");
    // выпадающий список
    private By dropDownList = By.xpath(".//li[@class='select-search__row']");
    // локатор телефон
    private By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка далее
    private By next = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public InputInfo(WebDriver driver) {
        this.driver = driver;
    }

    //методы для заполнения формы
    public void setUsername(String userName) {
        driver.findElement(firstName).sendKeys(userName);
    }

    public void setSurName(String surName) {
        driver.findElement(lastName).sendKeys(surName);
    }

    public void setAddressHouse(String addressHouse) {
        driver.findElement(address).sendKeys(addressHouse);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(metro).sendKeys(metroStation);
        driver.findElement(dropDownList).click();

    }

    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(telephone).sendKeys(telephoneNumber);
    }

    public void clickNextButton() {

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(next)).click();
    }

    public void login(String username, String surName, String addressHouse, String metroStation, String telephoneNumber) {
        setUsername(username);
        setSurName(surName);
        setAddressHouse(addressHouse);
        setMetroStation(metroStation);
        setTelephoneNumber(telephoneNumber);
    }
}
