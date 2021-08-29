package com.inetBanking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver ldriver;
     public LoginPage(WebDriver rdriver){
       ldriver= rdriver;
       PageFactory.initElements(rdriver, this);
     }

     @FindBy(xpath="//input[@name='uid']")
     WebElement userId;

    @FindBy(xpath="//input[@name='password'] ")
    WebElement pswd;

    @FindBy(xpath="//input[@name='btnLogin'] ")
    WebElement loginBtn;

    public void getUserID(String username){
        userId.sendKeys(username);
    }

    public void getPswd(String password){
        pswd.sendKeys(password);

    }
    public void clickLogin(){
        loginBtn.click();
    }
}

