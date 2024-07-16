package com.pythonanywhere.birdbank.utils;

import com.microsoft.playwright.*;

public class BrowserUtils {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static Page getPage(){
        if(page == null){
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
        }
        return page;
    }

    public static Page getNewPage(){
        return browser.newPage();
    }

    public static void closeBrowser(){
        if(browser!=null){
            browser.close();
            browser = null;
        }
    }

    public static void endSession(){
        if(playwright!=null){
            playwright.close();
            playwright = null;
        }
    }

}
