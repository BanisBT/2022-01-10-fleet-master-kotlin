package com.tbarauskas

import io.ktor.server.engine.*
import io.ktor.server.jetty.*
import com.tbarauskas.plugins.*

fun main() {
    embeddedServer(Jetty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureMonitoring()
        configureTemplating()
        configureSerialization()
    }.start(wait = true)
}
