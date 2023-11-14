package browsertesting;
/*Project-5 - ProjectName : com-utimateqa
BaseUrl = https://courses.ultimateqa.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Sign In’ link
7. Print the current url
8. Enter the email to email field.
9. Enter the password to password field.
10. Click on Login Button.
11. Navigate to baseUrl.
12. Navigate forward to Homepage.
13. Navigate back to baseUrl.
14. Refresh the page.
15. Close the browser.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MutliBrowserTesting {

    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //1. Setup browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2. Open URL
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //3. Print the title of the page.
        System.out.println("Title of the page: " + driver.getTitle());
        //4. Print the current url.
        System.out.println("Current Url: " + driver.getCurrentUrl());
        //5. Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());
        //6. Click on ‘Sign In’ link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        //7. Print the current url
        System.out.println("Current Url: " + driver.getCurrentUrl());
        //8. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Abc@gmail.com");
        //9. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("12345");
        //10. Click on Login Button.
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='sign-in__wrapper']//div[1]//input[1]"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //11. Navigate to baseUrl.
        driver.navigate().to(baseUrl);
        //12. Navigate forward to Homepage.
        driver.navigate().forward();
        //13. Navigate back to baseUrl.
        driver.get(baseUrl);
        //14. Refresh the page.
        driver.navigate().refresh();
        //15. Close the browser.
        driver.quit();
    }
}
