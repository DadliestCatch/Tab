package Tab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Tab.Main;

public class Config {
    static Properties prop = new Properties();
    static OutputStream output = null;
    static File config = new File("mods/Tab/config.properties");

    public static boolean readConfig() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            try {
                input = new FileInputStream(config);
            } catch (FileNotFoundException e) {
                createConfig();
                return false;
            }

            prop.load(input);

            Main.header = prop.getProperty("header");
            Main.footer = prop.getProperty("footer");

        } catch (IOException ex) {
            System.out.println("[Tab/WARN]: Disabled! Configuration error. " + ex.getMessage());
        }
        try {
            input.close();
        } catch (IOException e) {
        	System.out.println("[Tab/WARN]: Disabled! Configuration error. " + e.getMessage());
            return false;
        }
        System.out.println("[Tab/INFO]: Config: OK");
        return true;
    }

    public static void createConfig() {
        try {
            config.getParentFile().mkdirs();

            output = new FileOutputStream(config);

            prop.setProperty("header", "&6Username: %player%");
            prop.setProperty("footer", "&bHealth: %player_health%");

            prop.store(output, "Tab Configuration");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                    System.out.println("[Tab/INFO]: Configuration file created.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
