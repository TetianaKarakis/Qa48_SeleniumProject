package com.telran.qa48;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;

    //before method
    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();  //открытие полного окна


        //driver.get("https://www.tel-ran.com"); // без истории как будто первый раз

        driver.navigate().to("https://www.google.com");// с историей

        //wait for all elements on the site to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    //test
    @Test
    public void openGoogleTest() {
        System.out.println("Google opened");
    }

    //after  -tearDown
@AfterMethod
    public  void  tearDown(){
       // driver.quit(); //закрывает все сылки и браузер
    driver.close(); // закрывает только одну вкладку текущую

}
}
