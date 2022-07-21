package com.alessio.slack.model

class Action {

    String name

    String text

    String style

    String type

    String value

    Confirm confirm

    def confirm(Closure closure) {
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        confirm = new Confirm()
        closure.delegate = confirm
        closure()
    }

}
