package com.example.plugins

import java.util.concurrent.atomic.AtomicInteger

class Article
private  constructor(val id: Int, var title: String,var body: String) {
    companion object {
        private val idCounter = AtomicInteger()

        fun newEntry(title: String,body: String) = Article(idCounter.getAndIncrement(),title, body)
        val  articles = mutableListOf(
            newEntry(
            "The drive to develop!",
            "Its What keep me going."
        )
        )

    }
}