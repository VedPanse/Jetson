package org.jetson;

import java.util.Arrays;

public class Application {
    private String name;
    private String path;
    private String scriptPath;
    private Action[] actions;

    public Application(String name, String path, String scriptPath, Action[] actions) {
        this.name = name;
        this.path = path;
        this.scriptPath = scriptPath;
        this.actions = Arrays.copyOf(actions, actions.length);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public Action[] getActions() {
        return Arrays.copyOf(actions, actions.length);
    }

    @Override
    public String toString() {
        return super.toString() + "name: " + name + ", path: " + path + ", scriptPath: " + scriptPath;
    }
}
