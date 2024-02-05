package com.spartans.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class HerokuappStepDef extends BaseStepDef {

    @And("Navigate to the {string} Page")
    public void navigate_to_the(String button) {
        clickHerokuappButton(button);
    }

    @And("Upload file {string}")
    public void upload_file(String filePath) {
        uploadFile(filePath);
    }

    @Then("Verify file is upload successfully")
    public void verify_file_is_upload_successfully() {
        Assert.assertEquals("File Uploaded!", herokuappPage.uploadSuccessText.getText());
        Assert.assertEquals(expectedUploadedFileName, herokuappPage.uploadFileName.getText());
    }

    @Then("Verify Broken Images")
    public void verify_broken_images() {
        int numOfBrokenImages = 0;
        for (WebElement each : herokuappPage.images) {
            if (isImageBroken(each)) {
                numOfBrokenImages++;
            }
        }
        Assert.assertEquals("There are " + numOfBrokenImages + " broken images out of "+herokuappPage.images.size(),
                2, numOfBrokenImages);
    }
}
