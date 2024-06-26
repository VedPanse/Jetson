# Getting Target Application Information

When customizing an application using a [custom script](custom-scripting.md), you might need to retrieve basic information about the target application. Jetson provides a simple way to access this information through its API.

## Example: Retrieving Application Information with Java

Below is an example of how to pull basic data from the target application using a Java script.

### Java Script Example

```java
import com.jetson.api.*;

public class OrderFood {

    public static void main(String[] args) {
        JetsonApp app = new JetsonApp("/Applications/Google Chrome.app");
        app.launch();

        // Get application info
        HashMap<String, String> appInfo = app.getInfo();

        // Print application info
        appInfo.forEach((key, value) -> System.out.println(key + ": " + value));

        // Add more steps as needed to complete the order

        app.close();
    }
}
```

### Description

- **app.getInfo()**: This method retrieves a `HashMap` containing the following details about the target application:
  1. **Application Name**: The name of the application.
  2. **Application Kind**: The type of application (e.g., universal, application).
  3. **Absolute Path**: The absolute file path to the application.
  4. **Date Created**: The date the application was created.
  5. **Date Modified**: The date the application was last modified.
  6. **Date Last Opened**: The date the application was last opened.
  7. **Extension**: The file extension of the application.
  8. **Permissions**: The permissions associated with the application (e.g., rwx).
  9. **Hidden**: Whether the application is hidden or not.

### Example Output

Running the above script will output the application information in the console. For instance:

```
Application Name: Google Chrome
Application Kind: application
Absolute Path: /Applications/Google Chrome.app
Date Created: 2022-01-01
Date Modified: 2023-06-01
Date Last Opened: 2024-06-01
Extension: app
Permissions: rwxr-xr-x
Hidden: false
```

## Conclusion

Retrieving basic information about the target application can help you customize and interact with it more effectively using Jetson. By leveraging the `getInfo()` method, you can easily access essential details about the application, allowing for more informed and dynamic scripting.