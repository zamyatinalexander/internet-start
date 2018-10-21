import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseClass{



    public WebDriver driver;
    public WebDriverWait wait;

    public void start() throws InterruptedException{

        String browser = BrowserType.FIREFOX;
        if (browser == BrowserType.CHROME) {
            driver = new ChromeDriver();
        }else if(browser == BrowserType.FIREFOX){
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void getPage(String url){
        driver.get(url);
    }

    public void sleep(int sec) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sec);
    }

    @AfterMethod
    public void stop(){
        driver.quit();
    }


}