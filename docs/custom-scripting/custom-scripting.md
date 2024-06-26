# Custom Scripting

Instead of managing a really long JSON file, you can put all the code in a script and run it in the JSON file. The best thing about this custom script is that it can be in any programming language you want! Let's say you want to automate chrome so that you order food from Uber Eats's website every weekend at 7PM and you build a custom script in Python to achieve the desired functionality. You can write your JSON file like this:-

> build.routine.json
```json
{
    "routine": {
        "name": "Example Project",
        "author": "John Doe",
        "description": "An example project run with custom scripting,"
    },
    "schedule": {
        "time": ["19:00"],
        "days" ["Saturday", "Sunday"]
    },
    "applications": [
        {
            "name": "Order food from Google Chrome",
            "path": "/Applications/Google Chrome.app",
            "script": "/Users/johndoe/my-scripts/order-food.py"
        }
    ]
}
```