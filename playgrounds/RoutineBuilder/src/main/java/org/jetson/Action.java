package org.jetson;

import java.util.Arrays;

public class Action {
    private String type;
    private int[] target;
    private String[] files;
    private String value;

    public Action(String type, int[] target, String[] files, String value) {
        this.type = type;
        this.target = Arrays.copyOf(target, target.length);
        this.files = Arrays.copyOf(files, files.length);
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int[] getTarget() {
        return target;
    }

    public String[] getFiles() {
        return files;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "type: " + type + "\n" + "target: " + Arrays.toString(target) + "\n" +
                "files: " + Arrays.toString(files);
    }
}
