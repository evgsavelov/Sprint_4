package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FaqPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    //Перейти по URL
    public void open() {
        driver.get(PAGE_URL);
    }

    public String checkQuest(int quest) {
        By id = By.id("accordion__heading-" + quest);
        By answ = By.xpath(".//div[@id='accordion__panel-" + quest + "']/p");

        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(id));
        driver.findElement(id).click();
        //получаем текст ответа
        return driver.findElement(answ).getText();
    }

}
