/**
 * This class is the main class where all the components are brought together for testing purposes.
 */

public class Tester {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser("../manifest.json");
        String targetPath = parser.getTarget();

        Application safari = new Application(targetPath);
        safari.launchApp();
    }
}