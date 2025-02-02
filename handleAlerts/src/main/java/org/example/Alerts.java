package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Handling alert window with only OK button
        driver.findElement(By.cssSelector("[onclick=\"jsAlert()\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //Handling alert window with OK and Cancel button
        driver.findElement(By.cssSelector("[onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // Close alert by clicking on OK button
        driver.switchTo().alert().dismiss(); // Close alert by clicking on Cancel button

        Thread.sleep(10000);

        //Handling alert window with input box and capturing text from the alert
        driver.findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();
        Thread.sleep(2000);

        Alert alertWindow = driver.switchTo().alert();
        System.out.println("Alert text : "+alertWindow.getText());
        alertWindow.sendKeys("Hello");
        alertWindow.accept();
        
        driver.close();
        }

}
