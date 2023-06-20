package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static FileInputStream fs;
    static Properties prop = new Properties();


    public static void Load(String path) throws IOException {
        fs = new FileInputStream(path);
        prop.load(fs);
    }

    public static String GetValue(String name){
        String url= prop.getProperty(name);
        return url;
    }
}
