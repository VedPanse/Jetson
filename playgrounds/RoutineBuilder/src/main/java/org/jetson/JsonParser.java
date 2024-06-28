package org.jetson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.InputStream;
import java.util.HashMap;

public class JsonParser {
    private String url;
    private JSONObject mainJSONObject;

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
            System.out.println("Error: " + e.getMessage());
        }

        return jsonText.toString();
    }

    public HashMap<String, String> getRoutine() {
        HashMap<String, String> routine = new HashMap<>();

        JSONObject routineParent = (JSONObject) mainJSONObject.get("routine");

        for (Object key : routineParent.keySet()) {
            routine.put((String) key, (String) routineParent.get(key));
        }

        return routine;
    }

    public Application[] getApplications() {
        JSONArray applicationsArray = (JSONArray) mainJSONObject.get("applications");
        Application[] applications = new Application[applicationsArray.size()];

        for (int i = 0; i < applicationsArray.size(); i++) {
            JSONObject applicationObject = (JSONObject) applicationsArray.get(i);
            applications[i] = this.makeApplication(applicationObject);
        }

        return null;
    }

    private Application makeApplication(JSONObject applicationObject) {
        JSONArray actionsArray = (JSONArray) applicationObject.get("actions");
        Action[] actions = new Action[actionsArray.size()];

        for (int i = 0; i < actionsArray.size(); i++) {
            JSONObject actionObject = (JSONObject) actionsArray.get(i);
            actions[i] = this.makeAction(actionObject);
        }

        return null;
    }
    private Action makeAction(JSONObject actionObject) {
        String type = (String) actionObject.get("type");
        String value = (String) actionObject.get("value");
        JSONArray targetArray = (JSONArray) actionObject.get("target");
        JSONArray filesArray = (JSONArray) actionObject.get("files");

        int[] target = targetArray != null ? new int[targetArray.size()] : null;
        String[] files = filesArray != null ? new String[filesArray.size()] : null;

        if (target != null) {
            for (int i = 0; i < targetArray.size(); i++) {
                target[i] = (int) targetArray.get(i);
            }
        }

        if (files != null) {
            for (int i = 0; i < filesArray.size(); i++) {
                files[i] = (String) filesArray.get(i);
            }
        }

        return new Action(type, target, files, value);
    }
}