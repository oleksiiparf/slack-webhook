package com.alessio.slack

import com.alessio.slack.model.Message
import com.alessio.slack.task.SlackTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class SlackWebhookPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def messages = project.container(Message)
        project.extensions.add("slack", messages)

        messages.all { message ->
            project.tasks.create("post${message.name.capitalize()}ToSlack", SlackTask) { task ->
                messageToSend = message

                group 'slack'
                description "Publish ${message.name} message to slack"
            }
        }
    }

}