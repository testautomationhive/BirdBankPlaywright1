package runner;

import com.pythonanywhere.birdbank.utils.BrowserUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestRunner {
    @BeforeSuite
    public void beforeSuite(){}

    @AfterSuite
    public void afterSuite(){
        BrowserUtils.endSession();
    }
}
