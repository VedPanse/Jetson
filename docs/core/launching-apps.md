# Launching Applications with Jetson using only JSON

This guide provides detailed instructions on how to configure and use the routine JSON file to automate the launching and interaction of applications, using only JSON architecture.

## Multiple ways of building routine JSON files
There are two ways of building routines:-
1. Writing JSON files manually (as covered on this page)
   - There is a long and a short way of writing routine JSON files. This page covers both.
2. Skipping the code, using a [wizard](../gui-wizard/launching-gui.md) to write routine JSON files


## Writing routine JSON files the long way
**Configuration:** example.routine.json

**Example Configuration**
The example configuration launches two applications and performs specified actions within them at 08:00 on Monday, Wednesday, and Friday.
The routine.json file should be structured as follows:

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
- time: Specifies the time to run the scripts (HH:MM format).
- days: Specifies the days of the week to run the scripts.

**Applications**
- name: Name of the software.
- path: Path to the application’s executable file.
- actions: A list of actions to perform within the application.
- type: Type of action (e.g., click, input, upload).
- target: Target element for the action in the form of [x_pixels, y_pixels].
- value (optional): Value to input, if applicable.

****

## Writing routine JSON files the short way

[Previous](start-project.md)
