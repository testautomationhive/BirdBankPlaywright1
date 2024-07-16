package runner;

import com.pythonanywhere.birdbank.utils.BrowserUtils;
import io.cucumber.testng.*;
import org.testng.annotations.*;

public class TestRunnerClass extends BaseTestRunner{
    TestNGCucumberRunner testNGCucumberRunner;

    @BeforeMethod
    public void beforeMethod(){
    }

    @AfterMethod
    public void afterMethod() {
    }


    @Test(dataProvider = "transferAmount")
    public void testTransferAmount(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] transferAmount(){
        testNGCucumberRunner = new TestNGCucumberRunner(TransferAmount.class);
        return testNGCucumberRunner.provideScenarios();
    }
}

@CucumberOptions(features = "src/test/resources/features/transfer.feature",
                glue = "stepDefinitions",
                plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
class TransferAmount extends AbstractTestNGCucumberTests{

}

