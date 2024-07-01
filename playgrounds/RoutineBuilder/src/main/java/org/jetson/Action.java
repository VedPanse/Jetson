package org.jetson;

import java.util.Arrays;

/**
 * Simulates an Action that can be performed on a file
 */
public class Action {
    private final String type;
    private final int[] target;
    private String[] files;
    private String value;

    /**
     * Creates an action given a type and target. Useful for creating click events:-
     * @param type type of input
     * @param target position in [x, y] co-ordinates.
     */
    public Action(String type, int[] target) {
        this.type = type;

        if (target.length != 2)
            throw new IllegalArgumentException("Target array must have exactly 2 elements ([x_pixels, y_pixels]).");
        this.target = Arrays.copyOf(target, target.length);
    }

    /**
     * Creates an action given a type, target, and value. Useful for creating an input event.
     *
     * @param type type of the event
     * @param target position in [x, y] co-ordinates
     * @param value value passed to the input
     */
    public Action(String type, int[] target, String value) {
        this.type = type;
        this.target = Arrays.copyOf(target, target.length);
        this.value = value;
    }

    /**
     * Creates an action given a type, target, and array of file paths. Useful for creating an upload event.
     *
     * @param type type of the event
     * @param target position in [x, y] co-ordinates
     * @param files an array of file paths that will be uploaded
     */
    public Action(String type, int[] target, String[] files) {
        this.type = type;
        this.target = Arrays.copyOf(target, target.length);
        this.files = Arrays.copyOf(files, files.length);
    }

    /**
     * Getter method for the type of the action
     * @return type of the action
     */
    public String getType() {
        return type;
    }

    /**
     * Getter method for the target of the action
     * @return target of the action
     */
    public int[] getTarget() {
        return target;
    }

    /**
     * Getter method for the array of file paths
     * @return the array of file paths
     */
    public String[] getFiles() {
        return files;
    }

    /**
     * Gets the value (in case of input event)
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the string representation of this action
     * @return string representation of this action
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "type: " + type + "\n" + "target: " + Arrays.toString(target) + "\n" +
                "files: " + Arrays.toString(files);
    }
}
