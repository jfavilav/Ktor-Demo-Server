package jairoavila.com

import io.ktor.application.*
import jairoavila.com.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRoutingOne()
}

@Suppress("unused")
fun Application.module2() {
    configureRoutingTwo()
}
