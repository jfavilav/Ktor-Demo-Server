package jairoavila.com.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    install(CallLogging)
    routing {
        static {
            resources("assets")
        }

        get("/") {
            call.respondText("Hello World!")
        }

        get("/welcome") {
            val name = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title { +"Custom Title" }
                }
                body {
                    if(name.isNullOrEmpty()) {
                        h3 { +"Welcome" }
                    } else {
                        h3 { +"Welcome $name" }
                    }
                    img(src = "img.png")
                }
            }
        }
    }
}
