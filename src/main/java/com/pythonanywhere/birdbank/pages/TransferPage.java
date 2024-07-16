package com.pythonanywhere.birdbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class TransferPage extends BasePage{
    public TransferPage(Page page) {
        super(page);
    }

    public void selectOwnAccount(){
        page.locator("xpath=//input[@id='ownacc']").check();
    }

    public void selectToAccount(String toAccount){
        page.locator("//td[@id='"+toAccount+"']").click();
    }

    public void selectFromAccount(String fromAccount){
        Locator from_acc_loc = page.locator("xpath=//select[@id='fromaccount']");
        from_acc_loc.selectOption(new SelectOption().setLabel(fromAccount));
    }

    public void enterTransferDetails(String amount, String description){
        page.getByPlaceholder("Enter the amount").fill("1000");
        page.getByPlaceholder("What's this for").fill("Payment");
    }

    public void clickConfirmButton(){
        page.locator("//button[@id='confirm_payment']").click();
    }

    public String getConfirmationMessage(){
        return page.locator("#confirmationMessage").innerText();
    }
}
