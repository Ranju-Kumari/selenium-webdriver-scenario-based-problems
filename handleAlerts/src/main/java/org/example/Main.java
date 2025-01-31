package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Handling alert window with only OK button
        driver.findElement(By.cssSelector("[onclick=\"jsAlert()\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        driver.close();
        }

}