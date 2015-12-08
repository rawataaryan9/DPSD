package com.snapdeal.dis.services.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Utils {

    public static Properties loadPropertiesFromClassPath(String fileName){
        System.out.println("File name : "+fileName);
        Properties properties = new Properties();
        InputStream is = null;
        try {
            properties = new Properties();
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            System.out.println("Input Stream : "+is);
            properties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
