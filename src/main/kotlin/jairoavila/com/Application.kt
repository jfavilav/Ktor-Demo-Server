package jairoavila.com

import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import jairoavila.com.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    configureRouting()
}
