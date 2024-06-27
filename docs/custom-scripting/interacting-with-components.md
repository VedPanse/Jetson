# Interacting with Application Components

Jetson provides a set of components designed to interact with applications, similar to how JavaScript DOM works for websites. This allows developers to automate tasks by interacting with various components of an application.

## Example: Searching for Best Restaurants with Safari

Let's break down the process into the following steps:
1. Launch Safari.
2. Locate the search bar.
3. Send the search query.

### Step-by-Step Guide

#### 1. Launch Safari

First, create a Java class to launch Safari.

```java
import com.jetson.api.*;

public class Search {
    public static void main(String[] args) {
        Jetson app = new Jetson("/Applications/Safari.app");

        app.launch();
    }
}
```

#### 2. Locate the Search Bar

To find the search bar, you can use the `allInputs()` method to get a list of all input components. Assign the first input (from the list) to a variable of type `Input`.

```java
import com.jetson.api.*;

public class Search {
    public static void main(String[] args) {
        Jetson app = new Jetson("/Applications/Safari.app");

        app.launch();

        Input searchBar = app.allInputs().at(0);
    }
}
```

For more specificity, use the `byPlaceholder` method to find the input component with a particular placeholder text. For Safari's search bar, the placeholder is "Search or enter website name".

```java
import com.jetson.api.*;

public class Search {
    public static void main(String[] args) {
        Jetson app = new Jetson("/Applications/Safari.app");

        app.launch();

        Input searchBar = app.allInputs().byPlaceholder("Search or enter website name");
    }
}
```

#### 3. Send the Search Query

Send text to the search bar using the `sendKeys` method.

```java
import com.jetson.api.*;

public class Search {
    public static void main(String[] args) {
        Jetson app = new Jetson("/Applications/Safari.app");

        app.launch();

        Input searchBar = app.allInputs().byPlaceholder("Search or enter website name");
        searchBar.sendKeys("Best restaurants around me");
    }
}
```

To send special keys like Enter, Cmd, Option, Shift, or Delete, use the enum defined in `KEYS`.

```java
import com.jetson.api.*;

public class Search {
    public static void main(String[] args) {
        Jetson app = new Jetson("/Applications/Safari.app");

        app.launch();

        Input searchBar = app.allInputs().byPlaceholder("Search or enter website name");
        searchBar.sendKeys("Best restaurants around me");
        searchBar.sendKeys(KEYS.ENTER);
    }
}
```

## Interacting with Web Components

For interacting with web components within the browser, you can use tools like Selenium or other web scraping tools. These tools provide a way to interact with web elements directly, allowing for more complex automation tasks.

### Example with Selenium

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebInteraction {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Best restaurants around me");
        searchBox.submit();

        // Add more interactions as needed

        driver.quit();
    }
}
```

## Conclusion

Jetson simplifies the process of interacting with application components, enabling developers to automate tasks effectively. By utilizing Jetson's component methods and combining them with web automation tools like Selenium, you can create powerful automation scripts tailored to your specific needs.