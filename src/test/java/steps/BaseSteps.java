package steps;

import elements.DetailsPageElements;
import elements.HomePageElements;
import elements.LoginElements;
import elements.NewPostElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.utils.BaseTest;
import tests.utils.Pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class BaseSteps {

    protected LoginElements loginElements = new LoginElements();
    protected HomePageElements homePageElements = new HomePageElements();
    protected NewPostElements newPostElements = new NewPostElements();
    protected DetailsPageElements detailsPageElements = new DetailsPageElements();
    protected BaseTest baseTest = BaseTest.getInstance();

    public void logIn() {
        baseTest.getDriver().findElement(By.id(loginElements.getUsernameTxt())).click();
        baseTest.getDriver().findElement(By.id(loginElements.getUsernameTxt())).sendKeys(baseTest.username);
        baseTest.getDriver().findElement(By.id(loginElements.getPasswordTxt())).click();
        baseTest.getDriver().findElement(By.id(loginElements.getPasswordTxt())).sendKeys(baseTest.password);
        baseTest.getDriver().findElement(By.xpath(loginElements.getLoginBtn())).click();
    }

    public void navigateTo(Pages page) {
        switch (page){
            case POSTS:
                baseTest.getDriver().findElement(By.xpath(homePageElements.getPostsNavbar())).click();
                break;
            case NEWPOST:
                baseTest.getDriver().findElement(By.xpath(homePageElements.getNewPostNavbar())).click();
                break;
            case LOGOUT:
                baseTest.getDriver().findElement(By.xpath(homePageElements.getLogOutNavbar())).click();
                break;
        }
    }

    public void fillAndSubmitPost(String title, String subtitle, String body) {
        baseTest.getDriver().findElement(By.id(newPostElements.getTitleTxt())).click();
        baseTest.getDriver().findElement(By.id(newPostElements.getTitleTxt())).sendKeys(title);
        baseTest.getDriver().findElement(By.id(newPostElements.getSubtitleTxt())).click();
        baseTest.getDriver().findElement(By.id(newPostElements.getSubtitleTxt())).sendKeys(subtitle);
        baseTest.getDriver().findElement(By.id(newPostElements.getBodyTxt())).click();
        baseTest.getDriver().findElement(By.id(newPostElements.getBodyTxt())).sendKeys(body);
        baseTest.getDriver().findElement(By.xpath(newPostElements.getCreateBtn())).click();
    }

    public void verifyFormSubmitted(String title, String subtitle, String body) {
        //We verify if the user is not on the same page, meaning the form has been submitted.
        Assert.assertTrue(baseTest.getDriver().findElement(By.xpath(newPostElements.getPageTitle())).isDisplayed());
        String titleSubmitted = baseTest.getDriver().findElement(By.xpath(detailsPageElements.getTitleTxt())).getText();
        String subtitleSubmitted = baseTest.getDriver().findElement(By.xpath(detailsPageElements.getSubtitleTxt())).getText();
        String bodySubmitted = baseTest.getDriver().findElement(By.xpath(detailsPageElements.getBodyTxt())).getText();
        Assert.assertEquals(titleSubmitted, title);
        Assert.assertEquals(subtitleSubmitted, subtitle);
        Assert.assertEquals(bodySubmitted, body);
    }

    public void verifyAuthorAndDate() {
        String authorAndDate = baseTest.getDriver().findElement(By.xpath(detailsPageElements.getAuthorAndDate())).getText();
        Assert.assertTrue(isSameAuthor(authorAndDate, baseTest.username));
        Assert.assertTrue(isSameDate(authorAndDate));
    }

    private boolean isSameAuthor(String author, String username) {
        if (author.contains(username)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSameDate(String date) {
        //Not enough time to figure out a solution.
        int point = date.indexOf("On:");
        String Date = date.substring(point+4);
        try {
            Date date1 = new SimpleDateFormat("Mon. DD, YYYY, HH:MM").parse(Date);
        }
        catch (Exception ex) {
            System.out.println("Error");
        }

        //Returning false for the moment.
        return false;
    }

    public void verifyFormIncompleteByTitle() {
        //We verify if the user still on the same page, meaning the form has not been submitted.
        Assert.assertTrue(baseTest.getDriver().findElement(By.xpath(newPostElements.getPageTitle())).isDisplayed());
        WebElement titleTxt = baseTest.getDriver().findElement(By.id(newPostElements.getTitleTxt()));
        //We verify if the Title TextBox has the focus, meaning the system indicates that is required.
        Assert.assertTrue(titleTxt.equals(baseTest.getDriver().switchTo().activeElement()));
    }

    public void verifyFormIncompleteBySubtitle() {
        //We verify if the user still on the same page, meaning the form has not been submitted.
        Assert.assertTrue(baseTest.getDriver().findElement(By.xpath(newPostElements.getPageTitle())).isDisplayed());
        WebElement subtitleTxt = baseTest.getDriver().findElement(By.id(newPostElements.getSubtitleTxt()));
        //We verify if the Title TextBox has the focus, meaning the system indicates that is required.
        Assert.assertTrue(subtitleTxt.equals(baseTest.getDriver().switchTo().activeElement()));
    }
}
