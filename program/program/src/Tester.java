import java.awt.*;
import java.util.HashMap;

/**
 * This class is the main tester class where all the components are brought together and JSON is interpreted to test the functioning.
 */

public class Tester {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser("../manifest.json");
        String targetPath = parser.getTarget();

        Application app = new Application(targetPath); // Successful
        app.launchApp();

        HashMap<String, String> appInfo = app.getAppData();

        for (String key : appInfo.keySet()) {
            System.out.println(key + ": " + appInfo.get(key));
        }

        try {
            app.click(500, 300);
        } catch (AWTException e) {
            System.out.println("AWT Exception");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            app.type("Hello World");
        } catch (AWTException e) {
            System.out.println("AWTException");
        }
    }
}