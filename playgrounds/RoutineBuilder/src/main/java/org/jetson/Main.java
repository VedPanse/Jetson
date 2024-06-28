package org.jetson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] JSONPaths) {
        // Take in all the JSON paths
        for (String path : JSONPaths) {
            Build build;
            // Parse all the JSON files
                // get a hashmap for routine, applications
            JsonParser parser = new JsonParser("file://" + path);
            System.out.println(parser.getRoutine());
            System.out.println(parser.getApplications());

            // Make a Routine type with the hashmap values
                // Make an Application type for each application in hashmap
                    // Make an Action type for each action in application
                // Add all actions to application
            // Add all applications to Routine
            // Add Routine list to Build type
            // Execute actions
        }
    }
}
