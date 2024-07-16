package com.pythonanywhere.birdbank.pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page){
        this.page = page;
    }
    public void navigateTo(String url){
        page.navigate(url);
    }

    public String getTitle(){
        return page.title();
    }

    public void navigateToTab(String tabName){
        page.getByText(tabName).click();
    }
}
