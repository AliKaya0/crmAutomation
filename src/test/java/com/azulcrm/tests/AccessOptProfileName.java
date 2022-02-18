package com.azulcrm.tests;

import com.azulcrm.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccessOptProfileName {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to home page
        driver.get("https://login2.nextbasecrm.com/auth/?backurl=%2Fstream%2F");

        WebElement loginInputBox = driver.findElement(By.name("USER_LOGIN"));
        loginInputBox.sendKeys("hr25@cydeo.com");

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

    }

    @Test
    public void AccessOptProfileName() throws InterruptedException {
// Step 1: User on the homepage
// Step 2: Click the profile name
        Thread.sleep(3000);
      WebElement userProfileBtn = driver.findElement(By.id("user-name"));
      userProfileBtn.click();

        List<WebElement> options = driver.findElements(By.className("menu-popup-items"));

        for (WebElement each : options) {
            String eachOption = each.getText();

            System.out.println( eachOption  );

            }
        }




    @AfterMethod
    public void tearDownMethod(){
      driver.close();
    }

}


