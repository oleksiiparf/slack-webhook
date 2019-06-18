package br.com.luisrjaeger.slack.model

class Option {

    String value

    Text text

    String dismissText

    void text(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        text = new Text()
        closure.delegate = text
        closure()
    }

}
