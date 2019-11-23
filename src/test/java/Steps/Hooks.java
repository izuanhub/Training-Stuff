package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends BaseUtil {

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void IntializeTest() {
        System.out.println("Opening browser: Chrome");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Izuan\\Desktop\\Se\\chromedriver.exe");
        base.Driver = new ChromeDriver();
        base.Driver.manage().window().maximize();

    }

       @After
       public void AfterTest(){
           System.out.println("Closing browser: Chrome");
        base.Driver.quit();

    }
}
