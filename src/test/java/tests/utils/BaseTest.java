package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    public String username = "eduardomj99";
    public String password = "FTE2017!";

    public BaseTest() {
        initialSetup();
    }

    @BeforeTest
    public void initialSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void finishTest() {
        driver.close();
        driver.quit();
    }
}
