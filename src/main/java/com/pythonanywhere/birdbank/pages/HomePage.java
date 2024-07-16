package com.pythonanywhere.birdbank.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage{

    public HomePage(Page page) {
        super(page);
    }

    public void navigateToLogin(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).click();
    }
}
