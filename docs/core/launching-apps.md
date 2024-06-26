# Launching Applications with Jetson using only JSON

This guide provides detailed instructions on how to configure and use the routine JSON file to automate the launching and interaction of applications, using only JSON architecture.

## Multiple ways of building routine JSON files
There are two ways of building routines:-
1. Writing JSON files manually (as covered on this page)
2. Skipping the code, using a [wizard](../gui-wizard/launching-gui.md) to write routine JSON files

**Configuration:** routine.json

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
    "time": "08:00",
    "days": ["Monday", "Wednesday", "Friday"]
  },
  "applications": [
    {
      "name": "Application 1",
      "path": "C:/path/to/application1.exe",
      "actions": [
        {
          "type": "click",
          "target": "button_id"
        },
        {
          "type": "input",
          "target": "text_field_id",
          "value": "Sample text"
        }
      ]
    },
    {
      "name": "Application 2",
      "path": "C:/path/to/application2.exe",
      "actions": [
        {
          "type": "open",
          "target": "file_menu"
        },
        {
          "type": "select",
          "target": "file_option"
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
- name: Name of the application.
- path: Path to the application’s executable file.
- actions: A list of actions to perform within the application.
- type: Type of action (e.g., click, input, open, select).
- target: Target element for the action.
- value (optional): Value to input, if applicable.

[Previous](start-project.md)
