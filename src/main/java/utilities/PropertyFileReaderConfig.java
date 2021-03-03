package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileReaderConfig {



    public static Properties fileRead(String property) throws IOException {
        Properties prop = new Properties();

        if(property.equalsIgnoreCase("basicData")) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Configs/data.properties");
            prop.load(fis);
        }
        return prop;

    }
}
