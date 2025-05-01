package io.github.sakethpathike

import io.github.sakethpathike.docs.GettingStarted
import io.github.sakethpathike.docs.components.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

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
        Route(route = "/components/Button", content = { htmlScope, route ->
            with(htmlScope) {
                Button(currentRoute = route)
            }
        }),
        Route(route = "/components/TextInputField", content = { htmlScope, route ->
            with(htmlScope) {
                TextInputField(currentRoute = route)
            }
        }),
        Route(route = "/components/BreakFlow", content = { htmlScope, route ->
            with(htmlScope) {
                BreakFlow(currentRoute = route)
            }
        }),
        Route(route = "/components/Heading", content = { htmlScope, route ->
            with(htmlScope) {
                Heading(currentRoute = route)
            }
        }),
        Route(route = "/components/Image", content = { htmlScope, route ->
            with(htmlScope) {
                Image(currentRoute = route)
            }
        }),
        Route(route = "/components/StaggeredGrid", content = { htmlScope, route ->
            with(htmlScope) {
                StaggeredGrid(currentRoute = route)
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
        static("/static") {
            resources("static")
        }
        route("{...}") {
            handle {
                call.respondText(contentType = ContentType.Text.Html, text = createHTML().html {
                    Surface(
                        modifier = Modifier().backgroundColor("#1b1b1b"),
                        onTheHeadElement = {
                            unsafe {
                                raw(
                                    """
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                """.trimIndent()
                                )
                            }
                            style {
                                unsafe {
                                    raw(
                                        """
                                    @font-face {
                font-family: 'KingDisease404';
                src: url('/static/fonts/KingDisease404.woff2') format('woff2');
            }
                                """.trimIndent()
                                    )
                                }
                            }
                        }
                    ) {
                        Column(
                            modifier = Modifier().fillMaxSize(),
                            verticalAlignment = VerticalAlignment.Center,
                            horizontalAlignment = HorizontalAlignment.Center
                        ) {
                            Text(
                                textAlign = TextAlign.Center,
                                text = listOf(
                                    """
                                     The good news is, buddy, you came a long way.
                                     The bad news is, buddy, you came the wrong way.
                                    """.trimIndent(),
                                    """
                                        404: UNDYING LINK (LOVE LOCKDOWN)
                                        “Undying love... but the URL died.”
                                    """.trimIndent(),
                                    "#LifeIsGood #KingDisease404 #ItWasNOTWritten",
                                    "404: LOST IN THE WORLD",
                                    "#LostInTheServer #YeezyTaughtMeButTheLinkFaded",
                                    "The world is yours, just not this little corner of it.",
                                    "Page not found. Rumor has it it’s partying in Tahiti."
                                ).random(),
                                fontFamily = "KingDisease404",
                                color = "white",
                                fontSize = 75.px,
                                fontWeight = 45.px
                            )
                            Spacer(modifier = Modifier().height(50.px).fillMaxWidth())
                            Text(
                                modifier = Modifier().cursor(Cursor.Pointer).display(Display.InlineBlock),
                                text = "go to home",
                                fontFamily = "KingDisease404",
                                fontSize = 28.px,
                                color = "white",
                                onThisElement = {
                                    onClick = """
                        window.open("/", "_self");
                    """.trimIndent()
                                })
                        }
                    }
                })
            }
        }
    }
}

data class Route(val route: String, val content: (HTML, route: String) -> Unit)