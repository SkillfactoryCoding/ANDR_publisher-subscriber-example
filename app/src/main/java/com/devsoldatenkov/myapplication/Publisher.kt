package com.devsoldatenkov.myapplication

class Publisher {
    private val subscribers = mutableListOf<Subscriber>()

    fun subscribe(subscriber: Subscriber) {
        subscribers.add(subscriber)
        println("VVV $subscribers")
    }

    fun unsubscribe(subscriber: Subscriber) {
        subscribers.remove(subscriber)
        println("VVV $subscribers")
    }

    fun post(data: String) {
        subscribers.forEach {
            it.update(data)
        }
    }
}