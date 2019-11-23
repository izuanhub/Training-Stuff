package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page of the application$")
    public void iNavigateToTheLoginPageOfTheApplication() {

        System.out.println("Navigate to login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the following details for login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) throws Throwable{
        //Create an arraylist
        List<User> users = new ArrayList<User>();
        //Store all users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user: users)
        {
            page.Login(user.username, user.password);
        }

    }


    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        System.out.println("The username is " + username);
        System.out.println("The password is " + password);
    }

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton() {

        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        Assert.assertEquals(base.Driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @Then("I should see the userform page wrongly")
    public void iShouldSeeTheUserformPageWrongly() {
        Assert.assertEquals(base.Driver.findElement(By.id("wwww")).isDisplayed(), true);
    }


    public class User
    {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
