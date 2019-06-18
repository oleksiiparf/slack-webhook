package br.com.luisrjaeger.slack

import br.com.luisrjaeger.slack.model.Message
import br.com.luisrjaeger.slack.task.SlackTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class SlackMessagingPlugin implements Plugin<Project> {

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