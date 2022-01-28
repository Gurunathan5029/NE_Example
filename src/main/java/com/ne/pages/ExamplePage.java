package com.ne.pages;

import com.ne.utils.ActionsUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://devexpress.github.io/testcafe/example/")
public class ExamplePage extends PageObject {
    @FindBy(id = "developer-name")
    WebElementFacade nameTxt;

    @FindBy(xpath = "//legend[contains(text(),'Which features are important to you:')]//parent::fieldset//input[@type='checkbox']")
    List<WebElementFacade> importantFeaturesCbx;

    private String osType= "//legend[contains(text(),'What is your primary Operating System:')]//parent::fieldset//input[@id='%s']";


    @FindBy(id = "preferred-interface")
    WebElementFacade selectInterfaceList;

    @FindBy(id = "tried-test-cafe")
    WebElementFacade triedTestCafeCbx;

    @FindBy(css = "span.ui-slider-handle")
    WebElementFacade sliderBtn;

    @FindBy(id = "comments")
    WebElementFacade commentsTbx;

    @FindBy(id = "submit-button")
    WebElementFacade summitBtn;

    public void clickOnSubmitButton()
    {
        summitBtn.click();
    }

    public void enterUserName(String userName)
    {
        this.nameTxt.type(userName);
    }

    public void checkAllTheImportantFeatures()
    {
        this.importantFeaturesCbx.forEach(cbx->{cbx.click();});
    }

    public void selectOSType(String os)
    {
        this.element(String.format(this.osType,os)).click();
    }

    public void selectInterfaceList(String interfaceType)
    {
        //This use Select class and perform respective actions
        selectInterfaceList.selectByVisibleText(interfaceType);
    }

    public void enableTestCafeTriedCheckBox()
    {
        this.triedTestCafeCbx.click();
    }

    public WebElement returnSliderBtn()
    {
        return this.sliderBtn;
    }

    public void enterWhatYouThink(String comment)
    {
        this.commentsTbx.type(comment);
    }

    public Boolean getSubmitButtionStatus()
    {
        return this.summitBtn.isEnabled();
    }
}
