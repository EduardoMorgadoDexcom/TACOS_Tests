package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.CreatePostsSteps;
import tests.utils.BaseTest;
import tests.utils.Pages;

public class CreatePostsTests {
    BaseSteps baseSteps = new BaseSteps();

    @Test(description = "Scenario 1: User creates post.")
    public void userCreatesPostTest() {
        String title = "Title of the post";
        String subtitle = "Subtitle of the post";
        String body = "Body of the post.";

        baseSteps.logIn();
        baseSteps.navigateTo(Pages.NEWPOST);
        baseSteps.fillAndSubmitPost(title,subtitle,body);
        baseSteps.verifyFormSubmitted(title,subtitle,body);
        baseSteps.verifyAuthorAndDate();
    }

    @Test(description = "Scenario 2: User fails to create post because of missing title")
    public void userFailsCreatingPostByMissingTitleTest() {
        String title = "";
        String subtitle = "Subtitle of the post";
        String body = "Body of the post.";

        baseSteps.logIn();
        baseSteps.navigateTo(Pages.NEWPOST);
        baseSteps.fillAndSubmitPost(title,subtitle,body);
        baseSteps.verifyFormIncompleteByTitle();
    }

    @Test(description = "Scenario 3: User fails to create post because of missing subtitle")
    public void userFailsCreatingPostByMissingSubtitleTest() {
        String title = "Title of the post";
        String subtitle = "";
        String body = "Body of the post.";

        baseSteps.logIn();
        baseSteps.navigateTo(Pages.NEWPOST);
        baseSteps.fillAndSubmitPost(title,subtitle,body);
        baseSteps.verifyFormIncompleteBySubtitle();
    }
}
