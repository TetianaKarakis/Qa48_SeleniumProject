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

        //by link Text    ищет текст
        driver.findElement(By.linkText("Let car work"));

        //by partialLink ищет часть текста
        driver.findElement(By.partialLinkText("car"));


    }
    @Test
    public void findElementByCssSelectorTest() {

        //tagName ==css
        driver.findElement(By.cssSelector("h1"));

        //id->css(#)
        //driver.findElement(By.id("root"));
        driver.findElement(By.cssSelector("#root"));

        driver.findElement(By.cssSelector(".mobile-header"));


// точное совпадение
        driver.findElement(By.cssSelector("[href='/login']"));

        //частичное совпадение
        driver.findElement(By.cssSelector("[href*='/let']"));

        //ищем чтото в начале
        driver.findElement(By.cssSelector("[href^='/le']"));

        //ищем чтото в конце
        driver.findElement(By.cssSelector("[href$='work']"));
//tag + id
        driver.findElement(By.cssSelector("div#root"));
        // tag + class
        driver.findElement(By.cssSelector("div.search-card"));
    }

        //    //*[@attr='value'] х-пас выглядит всегда так

        @Test
        public void findElementByXpath() {
            //tag->xpath - //tag
            //driver.findElement(By.tagName("h1"));
            driver.findElement(By.xpath("//h1"));
            //id->xpath - //*[@id='value']
            //driver.findElement(By.id("#root"));
            driver.findElement(By.xpath("//div[@id='root']"));

            //class name-> xpath //*[@class='value']
            //driver.findElement(By.className("mobile-header"));
            driver.findElement(By.xpath("//div[@class='mobile-header']"));

            //contains->//*[contains(.,'Text')] частичное совпадения текста
            driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));


            //equal-> //*[text()='Text'] два одинаковых варианта второй писать более профисионально
            driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
            driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

            //start-> //*[starts-with(@attr,'Text')]
            driver.findElement(By.xpath("//label[starts-with(@for,'c')]"));

            //move up
            driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

            //parent
            driver.findElement(By.xpath("//h1/parent::*"));
            driver.findElement(By.xpath("//h1/parent::div"));
            driver.findElement(By.xpath("//h1/.."));

            //ancestor предки
            driver.findElement(By.xpath("//h1/ancestor::*"));//all
            driver.findElement(By.xpath("//h1/ancestor::div"));//two options
            driver.findElement(By.xpath("//h1/ancestor::div[2]"));//one option

            //following-sibling   брат сестра
            driver.findElement(By.xpath("//h1/following-sibling::form"));

            //preceding-sibling
            driver.findElement(By.xpath("//h2/preceding-sibling::*"));


        }
    }


