# Writing a basic project

Writing a Basic Project

Automation scripts are referred to as routines. To define a routine, you need to start by specifying the name of the project, the author, and a brief description. This can be achieved in Jetson by creating a JSON file with "routine" as the compound extension and including the following content:

test.routine.json:-
```json
{
  "routine": {
    "name": "first-project",
    "author": "John Doe",
    "description": "My First Project in Jetson"
  }
}
```

This JSON file should compile successfully when you run Main.java.

[Next Page](launching-apps.md)
