import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * This class provides functionality to parse the manifest.json file.
 */
public class JSONParser {
    private final String jsonPath;
    private String target;

    /**
     * This constructor initializes the JSONParser and sets the value of target application path
     *
     * @param jsonPath path to the JSON file
     */
    public JSONParser(String jsonPath) {
        this.jsonPath = jsonPath;
        this.setTarget();
    }

    /**
     * Gets the path of the application to be launched.
     *
     * @return path of the application to be launched
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * Sets the target for this JSON file
     */
    private void setTarget() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonPath)));
            JSONObject jsonObject = new JSONObject(content);
            this.target = jsonObject.getString("target");
        } catch (IOException e) {
            System.out.println("Could not read the JSON file: " + this.jsonPath);
            e.printStackTrace();
            this.target = null;
        }
    }
}