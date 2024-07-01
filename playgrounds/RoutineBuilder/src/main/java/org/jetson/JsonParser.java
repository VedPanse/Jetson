package org.jetson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.InputStream;
import java.util.HashMap;

/**
 * The class that makes sense of a given JSON file.
 *
 * @author: Ved Panse
 */
public class JsonParser {
    private String url;
    private JSONObject mainJSONObject;

    /**
     * Creates a parser for a JSON file from the given path.
     * @param url of the JSON file
     */
    public JsonParser(String url) {
        this.url = url;

        String strJSON = this.getJSON();

        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJSON);
            this.mainJSONObject = (JSONObject) object;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Gets the contents of the JSON file
     * @return contents of the JSON file
     */
    public String getJSON() {
        StringBuilder jsonText = new StringBuilder();

        try {
            URL url = new URL(this.url);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText.toString();
    }

    /**
     * Creates a Routine from the JSON file. Since all the fields are mandatory,
     * it checks if any field is uninitialized and throws errors if null.
     *
     * @return Routine from the data in the JSON file
     */
    public Routine getRoutine() {
        String name;
        String author;
        String description;
        Application[] applications = getApplications();

        if (applications == null || applications.length == 0) {
            throw new IllegalArgumentException("\"applications\" array at " + this.url + " is null or empty.");
        }

        JSONObject routineParent = (JSONObject) mainJSONObject.get("routine");

        if (routineParent.get("name") == null) {
            throw new IllegalArgumentException("\"name\" attribute at " + this.url + " is null or empty.");
        }
        name = (String) routineParent.get("name");

        if (routineParent.get("author") == null) {
            throw new IllegalArgumentException("\"author\" attribute at " + this.url + " is null or empty.");
        }
        author = (String) routineParent.get("author");

        if (routineParent.get("description") == null) {
            throw new IllegalArgumentException("\"description\" attribute at " + this.url + " is null or empty.");
        }
        description = (String) routineParent.get("description");

        return new Routine(name, author, description, applications);
    }

    /**
     * Gets the array of Applications that are defined in the "applications" key of the json.
     * Handles both the cases when name, path, script and name, path, actions are entered.
     *
     * @return array of applications to be launched
     */
    private Application[] getApplications() {
        JSONArray applicationsJSON = (JSONArray) mainJSONObject.get("applications");
        Application[] applications = new Application[applicationsJSON.size()];

        int i = 0;
        for (Object obj : applicationsJSON) {
            JSONObject application = (JSONObject) obj;

            if (application.get("name") == null) {
                throw new IllegalArgumentException("\"name\" attribute in applications array at " + this.url + " is null or empty.");
            }
            String name = (String) application.get("name");

            if (application.get("path") == null) {
                throw new IllegalArgumentException("\"path\" attribute in applications array at " + this.url + " is null or empty.");
            }
            String path = (String) application.get("path");

            if ((application.get("actions") == null) ^ (application.get("script") == null)) {
                if (application.get("actions") == null) {
                    String script = (String) application.get("script");
                    applications[i++] = new Application(name, path, script);
                } else {
                    JSONArray actions = (JSONArray) application.get("actions");
                    Action[] actionArray = this.getActions(actions);
                    applications[i++] = new Application(name, path, actionArray);
                }
            } else {
                throw new IllegalArgumentException("Actions and script cannot be defined simultaneously at " + this.url + ".");
            }
        }

        return applications;
    }

    /**
     * Creates an Actions list from a JSONArray of objects with properties.
     *
     * @param allActionsArray the array of actions
     * @return an array of actions created from the array
     */
    private Action[] getActions(JSONArray allActionsArray) {
        Action[] actionsArray = new Action[allActionsArray.size()];

        for (int i = 0; i < allActionsArray.size(); i++) {
            JSONObject action = (JSONObject) allActionsArray.get(i);
            if (action.get("type") == null) {
                throw new IllegalArgumentException("\"type\" attribute at " + this.url + " is null or empty.");
            }
            String type = (String) action.get("type");

            if (action.get("target") == null) {
                throw new IllegalArgumentException("\"target\" attribute at " + this.url + " is null or empty.");
            }
            JSONArray targetArray = (JSONArray) action.get("target");

            int[] target = new int[2];

            for (int j = 0; j < 2; ++j) {
                target[j] = Integer.parseInt(targetArray.get(j).toString());
            }

            switch (type) {
                case "click":
                    actionsArray[i] = new Action(type, target);
                    break;
                case "input":
                    if (action.get("value") == null) {
                        throw new IllegalArgumentException("\"value\" attribute at " + this.url + " is null or empty.");
                    }
                    String value = (String) action.get("value");
                    actionsArray[i] = new Action(type, target, value);
                    break;
                case "upload":
                    if (action.get("files") == null) {
                        throw new IllegalArgumentException("\"files\" attribute at " + this.url + " is null or empty.");
                    }
                    JSONArray fileArray = (JSONArray) action.get("files");

                    String[] files = new String[fileArray.size()];
                    for (int j = 0; j < fileArray.size(); j++) {
                        files[j] = (String) fileArray.get(j);
                    }
                    actionsArray[i] = new Action(type, target, files);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown kind of \"type\" parameter " + this.url + " is null or empty.");
            }
        }

        return actionsArray;
    }
}