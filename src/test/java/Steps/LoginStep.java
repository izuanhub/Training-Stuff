package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base)
    {
        this.base = base;
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable{

        Assert.assertEquals(base.Driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @Given("^I navigate to the login page of the application$")
    public void iNavigateToTheLoginPageOfTheApplication() throws Throwable{

        System.out.println("Navigate to login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the following details for login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) {
        //Create an arraylist

        List<User> users = new ArrayList<User>();
        //Store all users
        users = table.asList(User.class);

        for (User user: users)
        {
            base.Driver.findElement(By.xpath("//form[@id='userName']//input[@name='UserName']")).sendKeys(user.username);
            base.Driver.findElement(By.xpath("//form[@id='userName']//input[@name='Password']")).sendKeys(user.password);
        }
    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        System.out.println("The username is " + username);
        System.out.println("The password is " + password);
    }

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton() {

        base.Driver.findElement(By.xpath("//form[@id='userName']//input[@name='Login']")).click();
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
