package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Properties {

    private static java.util.Properties properties;

    static {
        properties = new java.util.Properties();
        try {
            properties.load(Properties.class.getClassLoader().getResourceAsStream("Properties"));
        } catch (FileNotFoundException e) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, e);
        } 
    }

    public static String get(String key) {
        return (String) properties.get(key);
    }
}
