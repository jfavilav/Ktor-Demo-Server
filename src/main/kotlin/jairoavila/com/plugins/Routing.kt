package jairoavila.com.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    install(CallLogging)
    routing {
        static(remotePath = "assets") {
            resources("static")
        }

        get("/") {
            call.respondText("Hello World!")
        }
    }
}
