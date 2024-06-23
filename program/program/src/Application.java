import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.HashMap;

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

    /**
     * Get the details of the launched application in a HashMap<String, String>
     * @return HashMap containing {field: value}
     */
    public HashMap<String, String> getAppData() {
        HashMap<String, String> info = new HashMap<>();
        File file = new File(this.path);

        try {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime creationTime = attrs.creationTime();
            FileTime modifiedTime = attrs.lastModifiedTime();
            FileTime lastAccessTime = attrs.lastAccessTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            info.put("name", file.getName());
            info.put("kind", "application universal");  // Placeholder, could be more specific if needed
            info.put("absolutePath", file.getAbsolutePath());
            info.put("created", sdf.format(creationTime.toMillis()));
            info.put("modified", sdf.format(modifiedTime.toMillis()));
            info.put("lastOpened", sdf.format(lastAccessTime.toMillis()));
            info.put("extension", getFileExtension(file));
            info.put("permissions", getPermissions(file));
            info.put("hidden", Boolean.toString(this.hidden));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return info;
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // Empty extension
        }
        return name.substring(lastIndexOf);
    }

    private String getPermissions(File file) {
        StringBuilder permissions = new StringBuilder();

        if (file.canRead()) {
            permissions.append("r");
        } else {
            permissions.append("-");
        }

        if (file.canWrite()) {
            permissions.append("w");
        } else {
            permissions.append("-");
        }

        if (file.canExecute()) {
            permissions.append("x");
        } else {
            permissions.append("-");
        }

        return permissions.toString();
    }

    public void click(int x, int y) throws AWTException {
        Robot bot  = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("Clicked: " + x + ", " + y);
    }

    public void type(String text) throws AWTException {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        String OS = System.getProperty("os.name").toLowerCase();

        if (OS.contains("win")) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } else if (OS.contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
        } else {
            System.out.println("Unsupported OS: " + OS);
        }
    }

}