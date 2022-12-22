package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    private static BaseTest instance;
    protected WebDriver driver;
    public String username = "eduardomj99";
    public String password = "FTE2017!";

    private BaseTest() {
        initialSetup();
    }

    public static BaseTest getInstance() {
        if(instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    public void initialSetup() {
        System.out.println("Test");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void finishTest() {
        driver.close();
        driver.quit();
    }
}
