package com.example.plugins

import com.example.Greeting
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }

    routing {
        post("/greet") {
            val name = call.receive<String>()
            val greeting = Greeting("Hello, $name!")
            call.respond(HttpStatusCode.OK, greeting)
        }
    }
}
