# Launching Applications

Launching applications with Jetson is easy. All you need to do is define a key called target in build.json and set its value to the absolute patrh of the application that youu want to launch. Building on the first project example from [writing a basic project](start-project.md), the code should look like this:-

build.json:-
```json
{
    "name": "first-project",
    "author": "John Doe",
    "description": "My First Project in Jetson",
    "target": "/Applications/Safari.app"
}
```

Be aware of the fact that applications in the 'Macintosh HD/Applications' folder on Mac should start with '/Applications'. Let's say you want to launch Safari. If you go to applications, right click on Safari, and click Get Info to get the absolute path, you will most likely find the path to be
```bash
Macintosh HD/Applications/Safari.app
```

You must ignore the Macintosh HD from the path and use the path as
```bash
/Applications/Safari.app
```

[Previous](start-project.md)
[Next](getting-app-info.md)