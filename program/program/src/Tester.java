import java.awt.*;
import java.util.HashMap;

/**
 * This class is the main tester class where all the components are brought together and JSON is interpreted to test the
 * functioning.
 */
public class Tester {
    public static void main(String[] args) {
        // Get target app from JSON
        JSONParser parser = new JSONParser("../build.json");
        String targetPath = parser.getTarget();

        // Launch app
        Application app = new Application(targetPath);
        app.launchApp();

        // Get app data
        HashMap<String, String> appInfo = app.getAppData();

        for (String key : appInfo.keySet()) {
            System.out.println(key + ": " + appInfo.get(key));
        }
//        // Simulate clicks
//        try {
//            app.click(500, 200);
//        } catch (AWTException e) {
//            System.out.println("AWT Exception");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Simulate keyboard events
        try {
            app.type("Hello World");
        } catch (AWTException e) {
            System.out.println("AWTException");
        }
    }
}