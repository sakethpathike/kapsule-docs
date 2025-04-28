package docs.common.ui

import kotlinx.html.DIV
import kotlinx.html.HTML
import kotlinx.html.onClick
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

fun HTML.CommonScaffold(currentRoute: String, content: DIV.() -> Unit) {
    val components = listOf(
        "Surface",
        "Text",
        "Column",
        "Row",
        "Spacer",
        "Box",
        "Button",
        "TextInputField",
        "BreakFlow",
        "Heading",
        "Image",
        "StaggeredGrid"
    )
    val userSelectMod = Modifier().custom(
        """
          user-select: none;
        """.trimIndent()
    )
    Surface(
        fonts = listOf("https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Poppins&family=JetBrains+Mono&display=swap"),
        modifier = Modifier().padding(0.px).margin(0).backgroundColor("#292929")
    ) {
        Row(
            modifier = Modifier().fillMaxWidth().height(65.px).backgroundColor("#1b1b1b"),
            verticalAlignment = VerticalAlignment.SpaceBetween,
            horizontalAlignment = HorizontalAlignment.Center
        ) {
            Text(
                modifier = Modifier().margin(start = 15.px).then(userSelectMod),
                text = "kapsule",
                fontFamily = "Abril Fatface",
                color = "white",
                fontSize = 25.px,
                fontWeight = 45.px
            )
            Button(
                modifier = Modifier().cursor(Cursor.Pointer).margin(end = 15.px).height(35.px)
                    .clip(shape = Shape.RoundedRectangle(12.px)).backgroundColor("#d6d6d6"), onClick = {
                    """
                        window.open("https://github.com/sakethpathike/kapsule", "_blank");
                    """.trimIndent()
                }) {
                Text(
                    text = "⭐ on Github", fontFamily = "Poppins", color = "black", fontSize = 14.px, fontWeight = "0"
                )
            }
        }
        Spacer(modifier = Modifier().fillMaxWidth().height(1.25.px).backgroundColor("#ffffff"))
        Row(modifier = Modifier().fillMaxSize()) {
            Column(
                Modifier().fillMaxHeight().width((20.vw)).padding(value = 15.px).backgroundColor(color = "#1b1b1b")
            ) {
                (currentRoute == "/").let {
                    SidebarSelectedTextComponent(selected = it, text = "Getting started", onThisElement = {
                        onClick = """
                                    window.open("/", "_self");
                                  """.trimIndent()
                    })
                    Spacer(modifier = Modifier().height(if (it) 18.px else 15.px))
                }
                Row(
                    modifier = Modifier().cursor(Cursor.Pointer).then(userSelectMod),
                    horizontalAlignment = HorizontalAlignment.Center,
                    onThisElement = {
                        onClick = """
                                const components = document.getElementById("components");
                                const expandEmoji = document.getElementById("expandEmoji");
                                if (components.style.display === "none") {
                                    expandEmoji.textContent = "⬇️";
                                    components.style.display = "block";
                                } else {
                                    expandEmoji.textContent = "➡️";
                                    components.style.display = "none";
                                }
                            """.trimIndent()
                    }) {
                    Text(
                        text = "➡\uFE0F",
                        fontSize = 20.px,
                        id = "expandEmoji",
                    )
                    Spacer(modifier = Modifier().width(10.px))
                    Text(
                        text = "Components",
                        fontSize = 20.px,
                        fontWeight = "bold",
                        fontFamily = "Poppins",
                        color = "white"
                    )
                }
                Spacer(modifier = Modifier().height(10.px))
                Column(
                    id = "components"
                ) {
                    components.forEach { component ->
                        ("components/$component" == currentRoute).let {
                            SidebarSelectedTextComponent(selected = it, text = component, onThisElement = {
                                onClick = """
                        window.open("/components/${component}", "_self");
                    """.trimIndent()
                            })
                            Spacer(modifier = Modifier().height(if (it) 18.px else 15.px))
                        }
                    }
                }

                Spacer(modifier = Modifier().height(10.px))
            }
            content()
        }
    }
}