package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private static BaseTest instance;
    protected WebDriver driver;
    protected String username;
    protected String password;

    protected String webPage;

    private BaseTest() {
        initialSetup();
    }

    public static BaseTest getInstance() {
        if(instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void initialSetup() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
            username = properties.get("username").toString();
            password = properties.get("password").toString();
            webPage = properties.get("webpage").toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error: properties file not found.");
        } catch (IOException e) {
            System.out.println("Error: unable to read properties file.");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(webPage);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void finishTest() {
        driver.close();
        driver.quit();
    }
}
