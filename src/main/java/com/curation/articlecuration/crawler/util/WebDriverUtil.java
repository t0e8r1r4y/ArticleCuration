package com.curation.articlecuration.crawler.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WebDriverUtil {

    private WebDriver driver;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/Users/terryakishin/pythonTest/webdriver/chromedriver";


    public void chrome() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--lang=ko");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setCapability("ignoreProtectedModeSettings", true);


        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void useDriver(String url, String id) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        log.info(driver.getTitle() + "-----------------------------");
        WebElement searchLabel = driver.findElement(By.id(id));
//        WebElement searchLabel = driver.findElement(By.cssSelector("#Sympathy222872024109 > div > span > em.u_cnt._count"));
        log.info(searchLabel.getText() + "-----------------------------");
        quitDriver();
    }

    private void quitDriver() {
        driver.quit();
    }
}
