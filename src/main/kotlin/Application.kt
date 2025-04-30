package io.github.sakethpathike

import io.github.sakethpathike.docs.GettingStarted
import io.github.sakethpathike.docs.components.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.HTML
import kotlinx.html.html
import kotlinx.html.stream.createHTML

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val allRoutes = listOf(
        Route(route = "/", content = { htmlScope, route ->
            with(htmlScope) {
                GettingStarted(route)
            }
        }),
        Route(route = "/components/Surface", content = { htmlScope, route ->
            with(htmlScope) {
                Surface(currentRoute = route)
            }
        }),
        Route(route = "/components/Text", content = { htmlScope, route ->
            with(htmlScope) {
                Text(currentRoute = route)
            }
        }),
        Route(route = "/components/Column", content = { htmlScope, route ->
            with(htmlScope) {
                Column(currentRoute = route)
            }
        }),
        Route(route = "/components/Row", content = { htmlScope, route ->
            with(htmlScope) {
                Row(currentRoute = route)
            }
        }),
        Route(route = "/components/Spacer", content = { htmlScope, route ->
            with(htmlScope) {
                Spacer(currentRoute = route)
            }
        }),
        Route(route = "/components/Box", content = { htmlScope, route ->
            with(htmlScope) {
                Box(currentRoute = route)
            }
        }),
    )

    routing {
        allRoutes.forEach { currentRoute ->
            get(currentRoute.route) {
                call.respondText(contentType = ContentType.Text.Html, text = createHTML().html {
                    currentRoute.content(this, currentRoute.route)
                }.toString())
            }
        }
    }
}

data class Route(val route: String, val content: (HTML, route: String) -> Unit)