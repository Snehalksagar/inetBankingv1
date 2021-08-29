package com.inetBanking.testCases;

import com.inetBanking.Utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.logging.Logger;

public class BaseClass {
    WebDriver driver;
    public static Logger logger;
  /*  String url="http://demo.guru99.com/v4";
    String username= "mngr348956";
    String password="sUbesUp";*/
    ReadConfig readConfig= new ReadConfig();
    String baseurl=readConfig.getApplicationURl();
    String username= readConfig.getUserName();
    String password=readConfig.getPassword();

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            //  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver92.exe");
            driver = new ChromeDriver();
            logger = Logger.getLogger("eBanking");
            // PropertyConfigurator.configure("");
            PropertyConfigurator.configure("Log4j.properties");
        }
        if(br.equals("ff")){
            System.setProperty("webdriver.gecko.driver", readConfig.getFFPath());
            driver = new FirefoxDriver();
            logger = Logger.getLogger("eBanking");
        }
        if(br.equals("edge")){
            System.setProperty("webdriver.edge.driver", readConfig.getIEFPath());
            driver = new EdgeDriver();
            logger = Logger.getLogger("eBanking");
        }
        driver.get(baseurl);

    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String tcname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tcname + ".png");
        FileUtils.copyFile(src,target);
        System.out.println("Screenshot Taken");
    }
}
