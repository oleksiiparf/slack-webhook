# slack-webhook
Slack plugin for Gradle

https://plugins.gradle.org/plugin/io.github.oleksiiparf.slack-webhook

# Usage
This plugin supports whole message structure of current slack. You can find full docs here: https://api.slack.com/docs/messages

It creates a task for each message you place on DSL as this example shows.
It takes advantage of preconfigured WebHook informations on Slack.

```
slack {
    publishedPlugin {
        webHook = "https://hooks.slack.com/services/xxxxxxx"
        attachment {
            fallback = "New version successfully published."
            pretext = "New version successfully published."
            color = "good"
            field {
                title = "Module"
                value = project.name
                shortValue = true
            }
            field {
                title = "Version"
                value = project.version
                shortValue = true
            }
        }
        attachment {
            fallback = "Another line on sent together."
            pretext = "Another line on sent together."
            color = "good"
            field {
                title = "Something"
                value = "Something text"
            }
        }
    }
    builtSucceed {
        webHook = "https://hooks.slack.com/services/xxxxxxx"
        attachment {
            fallback = "Project successfully built."
            pretext = "Project successfully built."
            field {
                title = "Module"
                value = project.name
                shortValue = true
            }
            field {
                title = "Version"
                value = project.version
                shortValue = true
            }
        }
    }
}
```

These DSL will generate two tasks `postPublishedPluginToSlack` and `postBuiltSucceedToSlack`.
