package com.alessio.slack.model

class Block {

    String blockId

    String type

    Text text

    String imageUrl

    String altText

    Text title

    Accessory accessory

    def elements = []

    void accessory(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        accessory = new Accessory()
        closure.delegate = accessory
        closure()
    }

    void element(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        def element = new Element()
        closure.delegate = element
        elements << element
        closure()
    }

    void text(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        text = new Text()
        closure.delegate = text
        closure()
    }

    void title(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        title = new Text()
        closure.delegate = title
        closure()
    }

}
