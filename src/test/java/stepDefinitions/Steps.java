package stepDefinitions;

import com.pythonanywhere.birdbank.pages.BasePage;
import com.pythonanywhere.birdbank.pages.HomePage;
import com.pythonanywhere.birdbank.pages.LoginPage;
import com.pythonanywhere.birdbank.pages.TransferPage;
import com.pythonanywhere.birdbank.utils.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Steps {

    private BasePage basePage;
    private HomePage homePage;
    private LoginPage loginPage;
    private TransferPage transferPage;

    public Steps() {
        this.basePage = new BasePage(BrowserUtils.getPage());
        this.homePage = new HomePage(BrowserUtils.getPage());
        this.loginPage = new LoginPage(BrowserUtils.getPage());
        this.transferPage = new TransferPage(BrowserUtils.getPage());
    }

    @Given("^User navigated to the home page$")
    public void userNavigatedToTheHomePage() {
        basePage.navigateTo("https://birdbank.pythonanywhere.com/");
    }

    @When("User navigate to login page")
    public void user_navigate_to_login_page() {
        homePage.navigateToLogin();
    }

    @When("^User login with \"(.*)\" and \"(.*)\"$")
    public void userLoinWith(String username, String password) {
        loginPage.doLogin(username, password);
        assertEquals(loginPage.getTitle(),"My Accounts - Bird Bank","User is not on the account page");
    }

    @When("User click on transfer tab")
    public void user_click_on_transfer_tab() {
        basePage.navigateToTab("TRANSFER");
    }

    @Given("User navigated to the transfer page")
    public void user_navigated_to_the_transfer_page() {
        assertEquals(transferPage.getTitle(), "Transfer - Bird Bank");
    }

    @When("User selects {string}")
    public void user_selects(String string) {
        transferPage.selectOwnAccount();
    }

    @When("User choose to account as {string}")
    public void user_choose_to_account_as(String string) {
        transferPage.selectToAccount(string);
    }

    @When("User selects from account as {string}")
    public void user_selects_from_account_as(String string) {
        transferPage.selectFromAccount(string);
    }

    @When("User provides Amount as {string} and Message as {string}")
    public void user_provides_amount_as_and_message_as(String string, String string2) {
        transferPage.enterTransferDetails(string, string2);

    }

    @When("User confirms the payment")
    public void user_confirms_the_payment() {
        transferPage.clickConfirmButton();
    }

    @Then("User navigated to the confirmation page and {string} message displayed")
    public void user_navigated_to_the_confirmation_page_and_message_displayed(String string) {
        assertEquals(transferPage.getConfirmationMessage(), string);
    }
}
