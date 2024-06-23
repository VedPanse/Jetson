import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * This class simulates an application and offers methods for users to interact with the target application.
 */
public class Application {
    private final String path;
    private boolean hidden;

    /**
     * Initializes path of this application and sets hidden to false.
     * @param path path of the target application
     */
    public Application(String path) {
        this(path, false);
    }

    /**
     * Initializes path and hidden
     *
     * @param path path of the target application
     * @param hidden whether the application must be hidden when launched
     */
    public Application(String path, boolean hidden) {
        this.path = path;
        this.hidden = hidden;
    }

    /**
     * Gets the path of this application
     *
     * @return The path of this application
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Whether the application launched must be hidden
     * @return whether the launched application must be hidden
     */
    public boolean getHidden() {
        return this.hidden;
    }

    /**
     * Mutator method to change whether the launched application must be hidden
     * @param hidden whether the launched application must be hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Launches the application on the target path.
     */
    public void launchApp() {
        File file = new File(this.path);

        try {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported on this platform.");
                return;
            }

            if (!file.exists()) {
                System.out.println("File does not exist: " + this.path);
                return;
            }

            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.out.println("Could not open file: " + this.path);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}