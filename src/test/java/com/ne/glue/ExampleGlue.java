package com.ne.glue;

import com.ne.constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ExampleSteps;

public class ExampleGlue {
    @Steps
    ExampleSteps exampleSteps;
    @Given("example page is launched")
    public void examplePageIsLaunched() {
        exampleSteps.launchExamplesUrl();
    }

    @When("user enter the name in (.+) format$")
    public void userEnterTheNameInFormatFormat(Constants.InputTextType inputTextType) {
        exampleSteps.enterUserName(inputTextType);
    }

    @And("click on submit button")
    public void clickOnSubmitButton() {
        exampleSteps.clickOnSubmitButton();
    }

    @Then("valid success message should be displayed")
    public void validSuccessMessageShouldBeDisplayed() {
        exampleSteps.verifyUserSubmission();
    }


    @And("select all the IMPORTANT_FEATURES")
    public void selectAllTheIMPORTANT_FEATURES() {
        exampleSteps.selectAllFeatures();
    }

    @And("select an (.+) OS$")
    public void selectAllTheOPERATING_SYSTEMS(Constants.OSTYPE os) {
        exampleSteps.selectOSType(os);
    }

    @And("user select TestCafe Interface as (.+)$")
    public void userSelectTestCafeInterfaceAsCOMMAND_LINE(Constants.INTERFACETYPE interfaceType) {
        exampleSteps.selectInterfaceType(interfaceType);
    }

    @And("user enable TestCafe and rate the TestCafe with value (\\d+)$")
    public void userEnableTestCafeAndRate(int rating) {
        exampleSteps.enableTestCafe();
        exampleSteps.rateTestCafe(rating);
    }

    @Then("submit button should be in (.+) state$")
    public void verifySubmitButtonState(Constants.SUBMITSTATUS status) {
        exampleSteps.validateSubMitButtonStatus(status);
    }

    @And("specify I think {string} about TestCafe")
    public void specifyIThinkAboutTestCafe(String about) {
        exampleSteps.enterAboutTestCafe(about);
    }
}
