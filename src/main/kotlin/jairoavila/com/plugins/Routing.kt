package jairoavila.com.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {

    routing {
        install(CallLogging)
        install(ContentNegotiation) { json() }

        get("/") {
            call.respondText("Hello World!")
        }

        // Headers Reader, Add Header, Parameter Reader
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (username == "Admin") {
                call.response.header(name = "CustomHeader", value = "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $username with header: $header")
        }

        // Query Params Reader
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            call.respondText("Hello $name with age: $age")
        }

        // Try Catch + Serialization Data Class
        get("/person") {
            try {
                val person = Person(name = "Jairo", age = 28)
                call.respond(message = person, status = HttpStatusCode.OK)
            }catch (e: Exception) {
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }

        // Response Redirect
        get("/redirect") {
            call.respondRedirect(url = "/", permanent = false)
        }
    }
}

@Serializable
data class Person(val name: String, val age:Int)