package org.jetson;

import java.util.Arrays;

/**
 * Defines the properties of an application. This class also deals with Application launching.
 */
public class Application {
    private final String name;
    private final String path;
    private String scriptPath;
    private Action[] actions;

    /**
     * Creates an Application class with the given name, path, and actions.
     * @param name name of the Application
     * @param path path of the Application
     * @param actions an array of actions to be performed on the application.
     */
    public Application(String name, String path, Action[] actions) {
        this.name = name;
        this.path = path;
        this.actions = Arrays.copyOf(actions, actions.length);
    }

    /**
     * Creates an Application class with the given name, path, and scriptPath.
     * @param name name of the Application
     * @param path path of the Application
     * @param scriptPath path of the script file that should be executed.
     */
    public Application(String name, String path, String scriptPath) {
        this.name = name;
        this.path = path;
        this.scriptPath = scriptPath;
    }

    /**
     * Gets the name of the Application
     * @return name of the Application
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the path of the Application
     * @return path of the Application
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the script path of the Application
     * @return path to the script of the Application
     */
    public String getScriptPath() {
        return scriptPath;
    }

    /**
     * Gets a deep copy of the actions array
     * @return deep copy of the actions array
     */
    public Action[] getActions() {
        return Arrays.copyOf(actions, actions.length);
    }

    /**
     * Executes the script if it is not null;
     */
    public void executeScript() {
        if (getScriptPath() != null) {
            System.out.println("Should execute script " + scriptPath);
        }
    }

    /**
     * Gets the string representation of this Application
     * @return string representation of this Application
     */
    @Override
    public String toString() {
        return super.toString() + "name: " + name + ", path: " + path + ", scriptPath: " + scriptPath;
    }
}
