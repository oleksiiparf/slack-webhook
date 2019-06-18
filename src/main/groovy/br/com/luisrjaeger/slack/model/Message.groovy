package br.com.luisrjaeger.slack.model

class Message {

    transient final String name

    transient String webHook

    String channel

    String iconUrl

    String iconEmoji

    String text

    String username

    String threadTs

    Boolean mrkdwn

    def attachments = []

    def blocks = []

    Message(String name) {
        this.name = name
    }

    void attachment(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        Attachment attachment = new Attachment()
        closure.delegate = attachment
        attachments << attachment
        closure()
    }

    void block(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        Block block = new Block()
        closure.delegate = block
        blockss << block
        closure()
    }

}