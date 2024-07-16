package com.pythonanywhere.birdbank.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage{
    public LoginPage(Page page) {
        super(page);
    }

    public void doLogin(String username, String password){
        page.getByPlaceholder("username").fill("testuser1");
        page.getByPlaceholder("password").fill("testpassword");
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).click();
    }

}
