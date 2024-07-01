package org.jetson;


import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] JSONPaths) throws FileNotFoundException {
        // Take in all the JSON paths
        for (String path : JSONPaths) {
            Build build;
            // Parse all the JSON files
                // get a hashmap for routine, applications
            JsonParser parser = new JsonParser("file://" + path);
            Routine routine = parser.getRoutine();
            System.out.println(routine);

            routine.launchAll();
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
