package com.inetBanking.testCases;

import com.beust.jcommander.Parameter;
import com.inetBanking.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase001 extends BaseClass{

    @Test
    public void login() throws IOException {
        LoginPage lp= new LoginPage(driver);
       // driver.get(baseurl);
        logger.info("Url launched");
        lp.getUserID(username);
        logger.info("UserName is entered");
        lp.getPswd(password);
        logger.info("password is entered");
        lp.clickLogin();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
          Assert.assertTrue(true);
          logger.info("Login test passed");
        }
        else
        {
            captureScreenshot(driver, "LoginTestCase001");
            Assert.assertTrue(false);
            logger.info("Login test failed");

        }


    }

}
