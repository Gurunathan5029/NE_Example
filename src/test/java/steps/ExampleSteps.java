package steps;

import com.ne.constants.Constants;
import com.ne.constants.StoryContextKeys;
import com.ne.pages.ExamplePage;
import com.ne.pages.SubmittedPage;
import com.ne.utils.ActionsUtility;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static jxl.biff.FormatRecord.logger;

public class ExampleSteps {
    ExamplePage examplePage;
    SubmittedPage submitPage;
    ActionsUtility action = null;

    @Step
    public void launchExamplesUrl() {
        this.examplePage.open();
           this.examplePage.getDriver().manage().window().maximize();
    }

    @Step
    public void enterUserName(Constants.InputTextType type) {
        this.examplePage.enterUserName(type.getTextType());
        Serenity.getCurrentSession().put(StoryContextKeys.userName, type);
    }

    @Step
    public void clickOnSubmitButton() {
        this.examplePage.clickOnSubmitButton();
    }

    @Step
    public void verifyUserSubmission() {
        Assert.assertEquals("Verify submission label is displayed as user entered", String.format(Constants.verifySubmitLabel, ((Constants.InputTextType) Serenity.getCurrentSession().get(StoryContextKeys.userName)).getTextType()), this.submitPage.getSubmitVerifyLabel());
    }

    @Step
    public void selectAllFeatures() {
        this.examplePage.checkAllTheImportantFeatures();
    }

    @Step
    public void selectOSType(Constants.OSTYPE os) {
        this.examplePage.selectOSType(os.getOsType());
    }

    @Step
    public void selectInterfaceType(Constants.INTERFACETYPE interfaceType) {
        this.examplePage.selectInterfaceList(interfaceType.getInterfaceType());
    }

    @Step
    public void enableTestCafe() {

        this.examplePage.enableTestCafeTriedCheckBox();
    }

    @Step
    public void rateTestCafe(int rating) {
        if (!(rating > 10)) {
            action = new ActionsUtility(examplePage.getDriver());
            action.moveElementToTheRight(this.examplePage.returnSliderBtn(), rating - 1);
        } else
            logger.info("Rating should not exceed 1to 10");
    }

    @Step
    public void validateSubMitButtonStatus(Constants.SUBMITSTATUS status) {
        /* can be implemented in more precise way
        if ((Constants.InputTextType) Serenity.getCurrentSession().get(StoryContextKeys.userName) != null)
            Assert.assertTrue("Submit button should be in enabled state",this.examplePage.getSubmitButtionStatus());
        else
            Assert.assertFalse("Submit button should not be in enabled state",this.examplePage.getSubmitButtionStatus());*/
        Assert.assertEquals("Verify submit button status is " + status.getStatus(), this.examplePage.getSubmitButtionStatus(), status.getStatus());
    }

    @Step
    public void enterAboutTestCafe(String about) {
        this.examplePage.enterWhatYouThink(about);
    }
}
