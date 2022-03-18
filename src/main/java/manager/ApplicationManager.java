package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   // EventFiringWebDriver wd;
    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    HelperSearch search;
    String browser;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ApplicationManager() {
        super();
    }

    public void init(){
        //wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd =  new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests starts in 'Chrome' browser");
        } else  if(browser.equals(BrowserType.EDGE)){
            wd =  new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'Edge' browser");
        }else  if (browser.equals(BrowserType.FIREFOX)){
            wd =  new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'Firefox' browser");
        }
        //logger.info("All tests starts in Chrome browser");
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);
        search = new HelperSearch(wd);
       // wd.register(new MyListener());



    }

    public void stop(){
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCar() {
        return car;
    }

    public HelperSearch search(){
        return search;
    }


   // public CarHelper(WebDriver wd)
}
