package org.jetson;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Defines the properties of a Routine, which is a Jetson program executable.
 */
public class Routine {
    private final String name;
    private final String author;
    private final String description;
    private final Application[] targetApplications;

    /**
     * Creates Routine object from the passed in data
     * @param name name of the Routine / project
     * @param author author of the Routine / project
     * @param description Description of the Routine / project
     * @param targetApplications A list of Applications that need to be automated with the script
     */
    public Routine(String name, String author, String description, Application[] targetApplications) {
        this.name = name;
        this.author = author;
        this.description = description;

        this.targetApplications = Arrays.copyOf(targetApplications, targetApplications.length);
    }

    /**
     * Gets the name of the Routine
     * @return name of the Routine
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the author of the Routine
     * @return author of the Routine
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the description of the Routine
     * @return description of the Routine
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets a deep copy of the target applications array
     * @return deep copy of the target applications array
     */
    public Application[] getTargetApplications() {
        return Arrays.copyOf(targetApplications, targetApplications.length);
    }

    /**
     * Launches all the applications
     */
    public void launchAll() throws FileNotFoundException {
        for (Application targetApplication : targetApplications) {
            targetApplication.launch();
        }
    }

    /**
     * Gets the string representation of the Routine object
     * @return string representation of the Routine object
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "name: " + name + "\n" + "author: " + author + "\n" +
                "description: " + description + "\n" + "targetApplications: " +
                Arrays.toString(targetApplications);
    }
}
