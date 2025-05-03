package io.github.sakethpathike.docs

import docs.common.ui.CommonScaffold
import io.github.sakethpathike.docs.common.Colors
import io.github.sakethpathike.docs.common.ui.BottomPagerControls
import kotlinx.html.*
import sakethh.kapsule.*
import sakethh.kapsule.utils.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

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
            <strong>Jetpack Compose's declarative approach</strong> with <strong>Kotlin DSL</strong> is one of my best experiences writing Compose/Kotlin code.

Well, that wasn’t quite the case when handling HTML sent from the server for simple static sites like the one you’re currently on. <code>kotlinx.html</code> solves this, but since I'm more familiar with <strong>Compose</strong>, <a style = "color: ${Colors.primaryDark};" href="https://github.com/sakethpathike">I</a> thought <em>a library should just do this</em>. Some solutions like <strong>Kobweb</strong> and <strong>Kweb</strong> are quite heavy/full-stack-based, rather than just HTML generation.

<strong>ANDDDD... <a style = "color: ${Colors.primaryDark};" href="https://github.com/sakethpathike">I</a> have a plan.</strong>
        """.trimIndent(), color = Colors.onSurfaceDark, fontSize = 18.px, fontFamily = "Inter"
            )
            Box(Modifier().margin(top = 10.px, bottom = 10.px)) {
                Image(
                    alignment = ObjectPosition.Predefined.Top,
                    modifier = Modifier().border(radius = 15.px, color = Colors.primaryDark, width = 1.5.px)
                        .width(100.percent)
                        .clip(Shape.RoundedRectangle(15.px)),
                    src = "/static/images/I_HAD_A_GODDAMNN_PLAN.jpg",
                    id = "I_HAD_A_GODDAMNN_PLAN"
                )
            }
            Text(
                text = "<strong>Guess what?</strong> <em>Mine actually works</em> — unlike <strong>Vander Linde’s</strong>. This site’s built with <code>kapsule</code> \uD83E\uDD20",
                color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter"
            )

            Box(Modifier().fillMaxWidth().padding(top = 10.px, bottom = 10.px)) {
                Spacer(
                    modifier = Modifier().height(2.5.px).opacity(0.25).fillMaxWidth()
                        .backgroundColor(Colors.onSurfaceDark)
                        .clip(Shape.RoundedRectangle(cornerRadius = 5.px))
                )
            }

            Text(
                text = "<strong>kapsule</strong> is a <strong>Kotlin Multiplatform</strong> library, wrapping <code>kotlinx.html</code> with <strong>Jetpack Compose-style modifiers</strong> and <strong>layout semantics</strong> to simplify static HTML generation.",
                color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter"
            )
            Text(
                text = "When to use kapsule?", color = Colors.primaryDark,
                fontSize = 24.px,
                fontFamily = "Inter",
                fontWeight = "bold",
                modifier = Modifier().margin(top = 10.px, bottom = 10.px)
            )
            listOf(
                "Server-side rendering static HTML",
                "Generating raw HTML+styling without writing manual markup",
                "Building static/simple pages with Compose-style Kotlin DSL"
            ).forEach {
                Text(
                    text = Typography.bullet + " " + it, color = Colors.onSurfaceDark,
                    fontSize = 18.px,
                    fontFamily = "Inter",
                    display = Display.Block
                )
            }
            Text(
                text = "Not a fullstack framework", color = Colors.primaryDark,
                fontSize = 24.px,
                fontFamily = "Inter", fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = "<strong>kapsule's</strong> motto isn't to be <em>\"yet another fullstack solution\"</em> or overengineer beyond its core goal — it strictly focuses on <strong>HTML/CSS generation</strong> with a <strong>Compose-like feel</strong>. If you need more than this, you're probably looking for <strong>Kobweb</strong>/<strong>Kweb</strong> instead.",
                color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter"
            )
            Text(
                text = "Compose-style not Compose-behavior", color = Colors.primaryDark,
                fontSize = 24.px,
                fontFamily = "Inter",
                fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = "<strong>kapsule</strong> only uses <strong>Compose-style</strong>, not <strong>Compose-behavior</strong>. The behaviour still depends on <strong>HTML/CSS</strong> (and <strong>JS</strong> if you add raw scripts). You should look up <em>MDN docs</em> or <em>Stack Overflow</em> when something doesn't behave like <strong>Jetpack Compose</strong> — that's the <em>web dev experience</em>.",
                color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter",
            )
            Text(
                text = "Adding dependency", color = Colors.primaryDark,
                fontSize = 24.px,
                fontFamily = "Inter", fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = """<strong>kapsule</strong> is available on <strong>Maven Central</strong>.<br>
Add the following to your <code>build.gradle.kts</code> <strong>dependencies</strong> block:
""", color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter"
            )

            val latestkapsuleVersion = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().GET()
                    .uri(URI.create("https://repo1.maven.org/maven2/io/github/sakethpathike/kapsule/maven-metadata.xml"))
                    .build(), HttpResponse.BodyHandlers.ofString()
            ).run {
                this.body() ?: "0.0.5"
            }.substringAfter("<latest>").substringBefore("</latest>")

            Column(
                horizontalAlignment = HorizontalAlignment.Start,
                modifier = Modifier().margin(top = 10.px, bottom = 30.px).padding(10.px)
                    .backgroundColor(Colors.surfaceContainerHighDarkHighContrast)
                    .clip(shape = Shape.RoundedRectangle(cornerRadius = 10.px), overflow = Overflow.Clip)
            ) {
                val kapsuleDependency = "io.github.sakethpathike:kapsule:${latestkapsuleVersion.trim()}"
                Text(
                    id = "dependency",
                    modifier = Modifier(), text = """
                    implementation("$kapsuleDependency")
                    """.trimIndent(), color = Colors.onSurfaceDark, fontSize = 18.px, fontFamily = "Jetbrains Mono"
                )
                Spacer(
                    modifier = Modifier().fillMaxWidth().margin(top = 15.px, bottom = 15.px).height(2.px)
                        .backgroundColor(Colors.outlineDark).opacity(0.5).clip(shape = Shape.RoundedRectangle(cornerRadius = 10.px))
                )
                span(classes = "material-icons"){
                    id = "componentsExpandEmoji"
                    style = Modifier().custom(
                        """
                                font-size: 20px
                            """.trimIndent()
                    ).cursor(Cursor.Pointer).color(Colors.onSurfaceDark).buildStyle()

                    onClick = """
  const div = document.getElementById('dependency');
  const textToCopy = div.textContent;

  if (navigator.clipboard && navigator.clipboard.writeText) {
    navigator.clipboard.writeText(textToCopy)
      .then(() => console.log('Copied to clipboard!'))
      .catch(err => alert('Copy failed: ' + err));
  } else {
    const textarea = document.createElement('textarea');
    textarea.value = textToCopy;
    textarea.style.position = 'absolute';
    textarea.style.left = '-9999px';
    document.body.appendChild(textarea);
    textarea.select();
    try {
      document.execCommand('copy');
      console.log('Copied via execCommand');
    } catch (err) {
      alert('Fallback copy failed: ' + err);
    }
    document.body.removeChild(textarea);
  }

                        """.trimIndent()
                    +"content_copy"
                }
            }
            BottomPagerControls(
                showPreviousBtn = false,
                showNextBtn = true,
                onPreviousBtnClick = { "" },
                onNextBtnClick = {
                    """
                        window.open("/components/Surface", "_self");
                    """.trimIndent()
                },
                previousBtnTxt = "",
                nextBtnTxt = "Surface"
            )
        }
    }
}