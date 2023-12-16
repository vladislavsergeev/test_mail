package org.example;

import org.example.ui.AuthPage;
import org.example.ui.ProfilePage;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MailTest {

    @Test
    public void Test() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AuthPage authPage = new AuthPage(driver);

        authPage.waitForElement("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big ihfknge-de8k2m']");
        authPage.switchFrame("//*[@class='ag-popup__frame__layout__iframe']");
        authPage.typeLogin("//*[@name='username']");
        authPage.waitForElement("//*[@class='base-0-2-79 primary-0-2-93']");
        authPage.typePassword("//*[@name='password']");
        authPage.waitForElement("//*[@class='base-0-2-79 primary-0-2-93']");

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.waitForElement("//*[@class='ph-avatar-img svelte-dfhuqc']");
        profilePage.checkName("//*[@class='ph-name svelte-1popff4']");
        profilePage.waitForElement("//*[@class='ph-item ph-item__social svelte-1popff4' and @tabindex='0']");
        profilePage.checkDoCreateMail("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big ihfknge-de8k2m']");

    }
}