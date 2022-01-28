package com.ne.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SubmittedPage extends PageObject {
    @FindBy(id = "article-header")
    WebElementFacade submitVerifyLbl;

    public String getSubmitVerifyLabel()
    {
        return submitVerifyLbl.getText();
    }
}
