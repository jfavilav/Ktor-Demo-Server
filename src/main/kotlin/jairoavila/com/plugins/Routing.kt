package jairoavila.com.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    install(CallLogging)
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
