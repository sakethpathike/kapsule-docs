package io.github.sakethpathike.docs

import docs.common.ui.CommonScaffold
import io.github.sakethpathike.docs.common.ui.BottomPagerControls
import kotlinx.html.HTML
import kotlinx.html.onClick
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

            Well, that wasn’t quite the case when handling HTML sent from the server for simple static sites like the one you’re currently on. <code>kotlinx.html</code> solves this, but since I'm more familiar with Compose, I thought there should be a library that just does this. There are solutions like Kobweb and Kweb, but they're quite heavy/full-stack-based, rather than just HTML generation.

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
                text = "Guess what? Mine actually works — unlike Vander Linde’s. This site’s built with kapsule \uD83E\uDD20",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )

            Box(Modifier().fillMaxWidth().padding(top = 10.px, bottom = 10.px)) {
                Spacer(
                    modifier = Modifier().height(2.5.px).opacity(0.25).fillMaxWidth().backgroundColor("#ffffff")
                        .clip(Shape.RoundedRectangle(cornerRadius = 5.px))
                )
            }

            Text(
                text = " kapsule is a Kotlin Multiplatform library, wrapping <code>kotlinx.html</code> with Jetpack Compose-style modifiers and layout semantics to simplify static HTML generation.",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )
            Text(
                text = "When to use kapsule?",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins",
                fontWeight = "bold",
                modifier = Modifier().margin(top = 10.px, bottom = 10.px)
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
                fontFamily = "Poppins", fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = "kapsule's motto isn't to be \"yet another fullstack solution\" or overengineer beyond its core goal — it strictly focuses on HTML/CSS generation with a Compose-like feel. If you need more than this, you're probably looking for Kobweb/Kweb instead.",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )
            Text(
                text = "Compose-style not Compose-behavior",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins",
                fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = "kapsule only uses Compose-style not Compose-behavior. The behaviour still depends on HTML/CSS (and JS if you add raw scripts). You should look up MDN docs or Stack Overflow when something doesn't behave like Jetpack Compose - that's the web dev experience.",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins",
            )
            Text(
                text = "Adding dependency",
                color = "#ffffff",
                fontSize = 24.px,
                fontFamily = "Poppins", fontWeight = "bold",
                modifier = Modifier().margin(top = 15.px, bottom = 10.px)
            )
            Text(
                text = """kapsule is available on Maven Central.
Add the following to your build.gradle.kts dependencies block:""",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins"
            )

            val latestkapsuleVersion = "0.0.4"/*HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().GET()
                    .uri(URI.create("https://repo1.maven.org/maven2/io/github/sakethpathike/kapsule/maven-metadata.xml"))
                    .build(), HttpResponse.BodyHandlers.ofString()
            ).run {
                this.body() ?: "0.0.4"
            }.substringAfter("<latest>").substringBefore("</latest>")*/

            Row(
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center,
                modifier = Modifier().margin(top = 10.px, bottom = 30.px).padding(10.px).backgroundColor("#1b1b1b")
                    .border(5, color = "#ffffff")
            ) {
                val kapsuleDependency = "io.github.sakethpathike:kapsule:${latestkapsuleVersion.trim()}"
                Text(
                    id = "dependency",
                    modifier = Modifier(), text = """
                    implementation("$kapsuleDependency")
                    """.trimIndent(), color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins"
                )
                Text(
                    modifier = Modifier().cursor(Cursor.Pointer),
                    text = "\uD83D\uDCCB",
                    color = "#ffffff",
                    fontSize = 18.px, fontFamily = "Poppins", onThisElement = {
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
                    }
                )
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