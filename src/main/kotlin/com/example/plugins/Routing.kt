package com.example.plugins

import com.example.plugins.Article.Companion.articles
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondRedirect("Articles")
        }
        route("articles") {
            get {
                //Ira mostrar a lista de artigos ou articles
                call.respond(FreeMarkerContent("index.ftl", mapOf ( "articles" to articles)))
            }
            get ("new") {
                call.respond(FreeMarkerContent("new.ftl", model = null))
            }
            get("new") {
                // Mostra os campos para a criacao do artigo ou articles
            }
            post {
                //  Salva os artigos ou article
            }
            get ("{id}") {
                // Mostrara a pagina com os campos para editar o artigo
            }
            post ("{id}") {
                // Atualiza ou deleta os artigos ou articles
            }
            post {
                val formParameter = call.receiveParameters()
                val title = formParameter.getOrFail("title")
                val body = formParameter.getOrFail("body")
                val newEntry = Article.newEntry(title,body)
                articles.add(newEntry)
                call.respondRedirect("/articles/${newEntry.id}")
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("show.ftl", mapOf("articles" to articles.find {it.id == id})))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val index = articles.indexOf(articles.find{ it.id == id})
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        articles[index].title = title
                        articles[index].body = body
                        call.respondRedirect("/articles")
                    }
                }
            }
        }
    }
}
