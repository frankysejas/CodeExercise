package code.automation.pageobjects.Common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    public String getProperty(String properties, String property){
        Properties prop = new Properties();
        String propFileName = properties;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if(inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String urlApp = prop.getProperty(property);
        return urlApp;
    }
}

