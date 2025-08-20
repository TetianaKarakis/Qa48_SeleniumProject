package com.telran.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {
    WebDriver driver;
    @BeforeMethod
    public  void  setUp(){

        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app"); //открыли сайт
        driver.manage().window().maximize();// разворот на все окно
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// таймер 10 сек
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findElementByTagName(){
        //find element by tagName
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());


        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find list if elements
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());


    }
    @Test
    public void findElementBySimpleLocators(){
        //by id
        driver.findElement(By.id("root"));

        //by class name
        driver.findElement(By.className("mobile-header"));
    }
}
