# Getting Target Application Information

Often, you might want to pull basic data from the target application when you are using a [custom script](custom-scripting.md) to customize the application. You can achieve it by doing the following:-

```java
import com.jetson.api.*;

public class OrderFood {

    public static void main(String[] args) {
        JetsonApp app = new JetsonApp("/Applications/Google Chrome.app");
        app.launch();

        // Interact with the application
        app.findElementByName("Login").click();
        app.findElementByName("Username").sendKeys("your-username");
        app.findElementByName("Password").sendKeys("your-password");
        app.findElementByName("LoginButton").click();

        app.findElementByName("Search").sendKeys("Uber Eats");
        app.findElementByName("SearchButton").click();

        // Add more steps as needed to complete the order

        app.close();
    }
}
```