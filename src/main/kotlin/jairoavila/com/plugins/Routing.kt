package jairoavila.com.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRoutingOne() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}

fun Application.configureRoutingTwo() {

    routing {
        get("/book") {
            call.respondText("Hello World2!")
        }
    }
}
