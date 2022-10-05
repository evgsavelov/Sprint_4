package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FaqPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //First question
    private final static By CHECK_PRICE_ONE = By.id("accordion__heading-0");
    private final static By CHECK_PRICE_ANSW = By.cssSelector("div.accordion__panel > p");
    private final static By CHECK_FEW_TWO = By.id("accordion__heading-1");

    private final static By CHECK_FEW_ANSW = By.xpath(".//div[@id='accordion__panel-1']/p");

    private final static By CHECK_TIME_THREE = By.id("accordion__heading-2");
    private final static By CHECK_TIME_ANSW = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final static By CHECK_TODAY_FOUR = By.id("accordion__heading-3");
    private final static By CHECK_TODAY_ANSW = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final static By CHECK_CORRECT_ORDER_FIVE = By.id("accordion__heading-4");
    private final static By CHECK_CORRECT_ORDER_ANSW = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final static By CHECK_CHARGER_SIX = By.id("accordion__heading-5");
    private final static By CHECK_CHARGER_ANSW = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final static By CHECK_CANCEL_ORDER_SEVEN = By.id("accordion__heading-6");
    private final static By CHECK_CANCEL_ORDER_ANSW = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final static By CHECK_OUTSIDE_MKAD_EIGHT = By.id("accordion__heading-7");
    private final static By CHECK_OUTSIDE_MKAD_ANSW = By.xpath(".//div[@id='accordion__panel-7']/p");


    private final WebDriver driver;

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    //Перейти по URL
    public void open() {
        driver.get(PAGE_URL);
    }

    public String checkQuestOne() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_PRICE_ONE).click();
        //получаем текст ответа #1
        return driver.findElement(CHECK_PRICE_ANSW).getText();
    }

    public String checkQuestTwo() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_FEW_TWO).click();
        //получаем текст ответа #2
        return driver.findElement(CHECK_FEW_ANSW).getText();
    }

    public String checkQuestThree() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_TIME_THREE).click();
        //получаем текст ответа #3
        return driver.findElement(CHECK_TIME_ANSW).getText();
    }

    public String checkQuestFour() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_TODAY_FOUR).click();
        //получаем текст ответа #4
        return driver.findElement(CHECK_TODAY_ANSW).getText();
    }

    public String checkQuestFive() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_CORRECT_ORDER_FIVE).click();
        //получаем текст ответа #5
        return driver.findElement(CHECK_CORRECT_ORDER_ANSW).getText();
    }

    public String checkQuestSix() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_CHARGER_SIX).click();
        //получаем текст ответа #6
        return driver.findElement(CHECK_CHARGER_ANSW).getText();
    }

    public String checkQuestSeven() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_CANCEL_ORDER_SEVEN).click();
        //получаем текст ответа #7
        return driver.findElement(CHECK_CANCEL_ORDER_ANSW).getText();
    }

    public String checkQuestEight() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CHECK_PRICE_ONE));
        driver.findElement(CHECK_OUTSIDE_MKAD_EIGHT).click();
        //получаем текст ответа #8
        return driver.findElement(CHECK_OUTSIDE_MKAD_ANSW).getText();
    }


}
