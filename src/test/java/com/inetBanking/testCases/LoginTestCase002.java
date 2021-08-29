package com.inetBanking.testCases;

import com.inetBanking.Pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase002 extends  BaseClass {

    @Test
    public void loginDDT(){

    }

    //@DataProvider(name="LoginData")
   // getData(){

   // }


    @Test
    public void login() throws IOException {
        LoginPage lp = new LoginPage(driver);
        // driver.get(baseurl);
        logger.info("Url launched");
        lp.getUserID(username);
        logger.info("UserName is entered");
        lp.getPswd(password);
        logger.info("password is entered");
        lp.clickLogin();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage123")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            captureScreenshot(driver, "LoginTestCase001");
            Assert.assertTrue(false);
            logger.info("Login test failed");

        }

    }

    @Test
    public String generateRandonNum(){
       String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString;
    }
}
