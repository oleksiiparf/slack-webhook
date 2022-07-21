package com.alessio.slack.model

class Attachment {

    String authorName

    String authorLink

    String authorIcon

    String fallback

    String pretext

    String color

    String footer

    String footerIcon

    String imageUrl

    String text

    String thumbUrl

    String title

    String titleLink

    Long ts = System.currentTimeSeconds()

    def fields = []

    def blocks = []

    def actions = []

    def field(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        Field field = new Field()
        closure.delegate = field
        fields << field
        closure()
    }

    def action(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        Action action = new Action()
        closure.delegate = action
        actions << action
        closure()
    }

    void block(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        Block block = new Block()
        closure.delegate = block
        blocks << block
        closure()
    }

}