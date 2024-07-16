package stepDefinitions;

import com.microsoft.playwright.Page;
import com.pythonanywhere.birdbank.utils.BrowserUtils;
import io.cucumber.java.*;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class hooks {
    Page page;
    public hooks(){
        this.page = BrowserUtils.getPage();
    }

    @After
    public void doSomethingAfter(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = page.screenshot();
            Allure.addAttachment(scenario.getName(),new ByteArrayInputStream(screenshot));
        }
    }
}
