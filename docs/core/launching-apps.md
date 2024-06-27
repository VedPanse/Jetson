# Using Jetson JSON to Launch Applications

This guide provides detailed instructions on how to configure and use routine JSON files to automate the launching and interaction of applications, using only JSON architecture.

## Multiple Ways of Building Routine JSON Files

There are two ways of building routines:

1. **Writing JSON files manually** (as covered on this page)
   - There is a [long](#writing-routine-json-files-the-long-way) and a [short](#writing-routine-json-files-the-short-way) way of writing routine JSON files. This page covers both.
2. **Skipping the code**, using a [wizard](../gui-wizard/launching-gui.md) to write routine JSON files.

## Writing Routine JSON Files the Long Way

**Configuration:** `example.routine.json`

**Example Configuration:**
The example configuration launches two applications and performs specified actions within them at 08:00 on Monday, Wednesday, and Friday. The routine JSON file should be structured as follows:

```json
{
  "routine": {
    "name": "first-project",
    "author": "John Doe",
    "description": "My First Project in Jetson"
  },
  "schedule": {
    "time": ["08:00", "23:00"],
    "days": ["Monday", "Wednesday", "Friday"]
  },
  "applications": [
    {
      "name": "Home automation",
      "path": "/Applications/Home.app",
      "actions": [
        {
          "type": "click",
          "target": [600, 200]
        },
        {
          "type": "input",
          "target": [20, 40],
          "value": "Sample text - this should go in the input field"
        }
      ]
    },
    {
      "name": "Food ordering automation",
      "path": "/Applications/Chrome.app",
      "actions": [
        {
          "type": "upload",
          "target": [200, 100],
          "files": ["/Users/example/file1.txt"]
        }
      ]
    }
  ]
}
```

## Key Elements

**Schedule**
- **time**: Specifies the time to run the scripts (HH:MM format).
- **days**: Specifies the days of the week to run the scripts.

**Applications**
- **name**: Name of the software.
- **path**: Path to the application’s executable file.
- **actions**: A list of actions to perform within the application.
- **type**: Type of action (e.g., click, input, upload).
- **target**: Target element for the action in the form of [x_pixels, y_pixels].
- **value (optional)**: Value to input, if applicable.

****

## Writing Routine JSON Files the Short Way

Writing JSON files the long way is optimal when writing simple automation scripts without dealing with complex components. However, it can be tedious when automating a large script. Jetson provides a better way to write routine JSON files by using a special key called 'script'. This tag should contain the path to the script you want to execute after launching the application. The best part about using a script is that you can run scripts in any programming language.

However, to use the special components we built to ease accessibility of target application components, you will have to use a Java file.

**Configuration:** `example.routine.json`

**Example Configuration:**
We can shorten the example.routine.json by replacing its contents with:

```json
{
  "routine": {
    "name": "first-project",
    "author": "John Doe",
    "description": "My First Project in Jetson"
  },
  "schedule": {
    "time": ["08:00", "23:00"],
    "days": ["Monday", "Wednesday", "Friday"]
  },
  "applications": [
    {
      "name": "Home automation",
      "path": "/Applications/Home.app",
      "script": "/Users/example/myProgram.kts"
    },
    {
      "name": "Food ordering automation",
      "path": "/Applications/Chrome.app",
      "actions": [
        {
          "type": "upload",
          "target": [200, 100],
          "files": ["/Users/example/file1.txt"]
        }
      ]
    }
  ]
}
```

## Key Elements

**Script**
- The script can be run in any programming language installed on your computer.
- To use the special components we wrote to increase the ease of accessing elements in the launched application, you will have to script in Java.

[Previous](start-project.md)<br>
[Next](../custom-scripting/custom-scripting.md)
