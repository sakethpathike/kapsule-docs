package io.github.sakethpathike.docs

import docs.common.ui.CommonScaffold
import kotlinx.html.HTML
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

fun HTML.GettingStarted(currentRoute: String) {
    CommonScaffold(currentRoute = currentRoute) {
        Column(
            modifier = Modifier().padding(25.px).custom(
                """
                  flex: 1;
                  overflow-y: auto;
            """.trimIndent()
            )
        ) {
            Text(
                text = """
            Jetpack Compose's declarative approach with Kotlin DSL is one of my best experiences writing Compose/Kotlin code.

            Well, that wasn’t quite the case when handling HTML sent from the server for simple static sites like the one you’re currently on. kotlinx.html solves this, but since I'm more familiar with Compose, I thought there should be a library that just does this. There are solutions like Kobweb and Kweb, but they're quite heavy/full-stack-based, rather than just HTML generation.

            ANDDDD... I have a plan.
        """.trimIndent(), color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins"
            )
            Box(Modifier().margin(top = 10.px, bottom = 10.px)) {
                Image(
                    alignment = ObjectPosition.Predefined.Top,
                    modifier = Modifier().border(radius = 15, color = "#ffffff").width(450.px)
                        .clip(Shape.RoundedRectangle(15.px)),
                    src = "https://i.ibb.co/TDT8Kzkp/tYzOOun.jpg"
                )
            }
            Text(
                text = "Guess what? Mine actually works — unlike Vander Linde’s. This site’s built with Kapsule \uD83E\uDD20",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )
            Box(
                modifier = Modifier().margin(top = 10.px, bottom = 10.px).height(2.5.px).opacity(0.25).fillMaxWidth()
                    .backgroundColor("#ffffff"), init = {})

            Text(
                text = "When to use Kapsule?",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins",
                fontWeight = 45.px,
                modifier = Modifier().margin(bottom = 10.px)
            )
            listOf(
                "Server-side rendering static HTML",
                "Generating raw HTML+styling without writing manual markup",
                "Building static/simple pages with Compose-style Kotlin DSL"
            ).forEach {
                Text(
                    text = Typography.bullet + " " + it,
                    color = "#ffffff",
                    fontSize = 18.px,
                    fontFamily = "Poppins",
                    display = Display.Block
                )
            }
            Text(
                text = "Not a fullstack framework",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins",
                fontWeight = 45.px,
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = "Kapsule's motto isn't to be \"yet another fullstack solution\" or overengineer beyond its core goal — it strictly focuses on HTML/CSS generation with a Compose-like feel. If you need more than this, you're probably looking for Kobweb/Kweb instead.",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )
            Text(
                text = "Adding dependency",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins",
                fontWeight = 45.px,
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = """Kapsule is available on Maven Central.
Add the following to your build.gradle.kts dependencies block:""",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )

            val latestKapsuleVersion = "0.0.4"/*HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().GET()
                    .uri(URI.create("https://repo1.maven.org/maven2/io/github/sakethpathike/kapsule/maven-metadata.xml"))
                    .build(), HttpResponse.BodyHandlers.ofString()
            ).run {
                this.body() ?: "0.0.4"
            }.substringAfter("<latest>").substringBefore("</latest>")*/

            Row(
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center,
                modifier = Modifier().margin(top = 10.px, bottom = 150.px).padding(10.px).backgroundColor("#1b1b1b")
                    .border(5, color = "#ffffff")
            ) {
                Text(
                    modifier = Modifier(), text = """
                    implementation("io.github.sakethpathike:kapsule:${latestKapsuleVersion.trim()}")
                    """.trimIndent(), color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins"
                )
                Text(
                    modifier = Modifier().cursor(Cursor.Pointer),
                    text = "\uD83D\uDCCB",
                    color = "#ffffff",
                    fontSize = 18.px,
                    fontFamily = "Poppins"
                )
            }
        }
    }
}