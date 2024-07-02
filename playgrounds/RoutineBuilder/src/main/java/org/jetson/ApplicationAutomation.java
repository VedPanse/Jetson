package org.jetson;
import org.sikuli.script.*;

/**
 * A playground to test Application Component Interaction.
 *
 * @author Ved Panse
 * @bugs to tackle a loadlib error, use brew install opencv
 */
public class ApplicationAutomation {

    public static void main(String[] args) {
        try {
            // Path to the App Store application
            String appPath = "/Applications/App Store.app";

            // Search query
            String searchText = "Your search query";

            // Launch the application
            App.open(appPath);

            // Wait for the application window to appear
            Screen screen = new Screen();
            Pattern searchBoxPattern = new Pattern("/Users/vedpanse/Jetson/playgrounds/RoutineBuilder/src/main/resources/temp.png");

            // Click on the search box
            screen.click(searchBoxPattern);

            // Type the search text
            screen.type(searchText);
            screen.type(Key.ENTER); // Press Enter to perform the search

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}