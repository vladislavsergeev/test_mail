package org.example.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProfilePage {

    protected WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickOnElement(String string) {
        driver.findElement(By.xpath(string)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitForElement(String string) {
        clickOnElement(string);
    }

    public void checkName(String string) {
        String text = driver.findElement(By.xpath(string)).getText();
        Assert.assertEquals(text, "Владислав Сергеев");
    }

    public void checkDoCreateMail(String string) {
        driver.findElement(By.xpath(string)).isDisplayed();
    }

}
