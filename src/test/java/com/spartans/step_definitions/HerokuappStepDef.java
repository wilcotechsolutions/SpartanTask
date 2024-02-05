package com.spartans.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class HerokuappStepDef extends BaseStepDef {

    @And("Navigate to the {string} Page")
    public void navigate_to_the(String buttonName) {
        clickHerokuAppButton(buttonName);
    }

    @And("Upload file {string}")
    public void upload_file(String filePath) {
        uploadFile(filePath);
    }

    @Then("Verify file is uploaded successfully {string}")
    public void verify_file_is_uploaded_successfully(String expectedFileName) {
        Assert.assertEquals("File Uploaded!", herokuAppPage.uploadSuccessText.getText());
        Assert.assertEquals(expectedFileName, herokuAppPage.uploadedFileName.getText());
    }

    @Then("Verify there is no broken images")
    public void verify_broken_images() {
        for (WebElement each : herokuAppPage.images) {
            Assert.assertFalse(isImageBroken(each));
        }
    }

    @Then("Verify additional information is shown when hover over")
    public void verifyAdditionalInformationIsShownWhenHoverOver(String expectedAdditionalInfo) {
        Assert.assertEquals(expectedAdditionalInfo, herokuAppPage.getActualAdditionalInformation());
    }
}
