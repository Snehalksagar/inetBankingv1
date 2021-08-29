package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
//to load each n every variable of properties file
        public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //to read each n every values from properites file
        // methods to read all values from properties file and return to baseclass
        public String getApplicationURl(){
            String baseurl=pro.getProperty("url");
            return baseurl;
        }

        public String getUserName(){
            String uName=pro.getProperty("username");
            return uName;
        }

        public String getPassword(){
        String password= pro.getProperty("password");
        return password;
        }

        public String getChromePath(){
            String chromepath= pro.getProperty("chromeDriver");
            return chromepath;
        }


    public String getFFPath(){
        String geckopath= pro.getProperty("geckoDriver");
        return geckopath;
    }

    public String getIEFPath(){
        String iePath= pro.getProperty("edgeDriver");
        return iePath;
    }

}
