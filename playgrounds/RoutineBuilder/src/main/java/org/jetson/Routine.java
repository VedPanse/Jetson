package org.jetson;

import java.util.Arrays;

public class Routine {
    private final String name;
    private final String author;
    private final String description;
    private final Application[] targetApplications;

    public Routine(String name, String author, String description, Application[] targetApplications) {
        this.name = name;
        this.author = author;
        this.description = description;

        this.targetApplications = Arrays.copyOf(targetApplications, targetApplications.length);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Application[] getTargetApplications() {
        return Arrays.copyOf(targetApplications, targetApplications.length);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "name: " + name + "\n" + "author: " + author + "\n" +
                "description: " + description + "\n" + "targetApplications: " +
                Arrays.toString(targetApplications);
    }
}
