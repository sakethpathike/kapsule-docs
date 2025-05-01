package docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.*
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
        fonts = listOf(
            "https://fonts.googleapis.com/icon?family=Material+Icons",
            "https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Poppins&family=JetBrains+Mono&display=swap"
        ), modifier = Modifier().padding(0.px).margin(0).backgroundColor(Colors.Background).custom(
            """
            overflow: hidden;
        """.trimIndent()
        )
    ) {
        Column(
            modifier = Modifier().custom(
                """
                top:0;
            """.trimIndent()
            ).position(Position.Sticky).zIndex(1000)
        ) {
            Row(
                modifier = Modifier().fillMaxWidth().height(65.px)
                    .backgroundColor(Colors.TopAppBarScrolledContainerColor),
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center
            ) {
                Row(horizontalAlignment = HorizontalAlignment.Center) {
                    span(classes = "material-icons") {
                        id = "kapsuleExpandEmoji"
                        style = Modifier().custom(
                            """
                            font-size: 45px;
                        """.trimIndent()
                        ).color(Colors.TopAppBarTitleContentColor).cursor(Cursor.Pointer).buildStyle()
                        onClick = """
                            const components = document.getElementById("topics-panel");
                                const kapsuleExpandEmoji = document.getElementById("kapsuleExpandEmoji");
                                if (components.style.display === "none") {
                                    kapsuleExpandEmoji.textContent = "arrow_left";
                                    components.style.display = "block";
                                } else {
                                    kapsuleExpandEmoji.textContent = "arrow_right";
                                    components.style.display = "none";
                                }""".trimIndent()
                        +"arrow_left"
                    }
                    Text(
                        modifier = userSelectMod,
                        text = "kapsule",
                        fontFamily = "Abril Fatface", color = Colors.TopAppBarTitleContentColor,
                        fontSize = 25.px,
                        fontWeight = 45.px
                    )
                }
                Row(
                    horizontalAlignment = HorizontalAlignment.Center,
                    modifier = Modifier().cursor(Cursor.Pointer).margin(end = 15.px).height(35.px),
                    onThisElement = {
                        onClick = """
                        window.open("https://github.com/sakethpathike/kapsule", "_blank");
                    """.trimIndent()
                    }) {
                    span(classes = "material-icons") {
                        style = Modifier().custom(
                            """
                                font-size: 20px
                            """.trimIndent()
                        ).color(Colors.TopAppBarTitleContentColor).buildStyle()
                        +"star"
                    }
                    Spacer(modifier = Modifier().width(5.px))
                    Text(
                        text = " on Github", fontFamily = "Poppins", color = Colors.TopAppBarTitleContentColor,
                        fontSize = 14.px,
                    )
                    Spacer(modifier = Modifier().width(5.px))
                }
            }
            Spacer(modifier = Modifier().fillMaxWidth().height(1.25.px).backgroundColor("#ffffff"))
        }
        Row(modifier = Modifier().fillMaxSize()) {
            Column(
                id = "topics-panel", modifier = Modifier().fillMaxHeight().custom(
                    """
                          overflow-y: auto;
                    """.trimIndent()
                ).position(Position.Sticky).zIndex(999).height(100.vh).width(20.vw)
                    .backgroundColor(color = Colors.NavigationBarColor)
                    .padding(value = 15.px)
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
                                const componentsExpandEmoji = document.getElementById("componentsExpandEmoji");
                                if (components.style.display === "none") {
                                    componentsExpandEmoji.textContent = "⬇️";
                                    components.style.display = "block";
                                } else {
                                    componentsExpandEmoji.textContent = "➡️";
                                    components.style.display = "none";
                                }
                            """.trimIndent()
                    }) {
                    Text(
                        text = "⬇\uFE0F",
                        fontSize = 20.px,
                        id = "componentsExpandEmoji",
                    )
                    Spacer(modifier = Modifier().width(10.px))
                    Text(
                        text = "Components",
                        fontSize = 20.px,
                        fontWeight = "bold",
                        fontFamily = "Poppins", color = Colors.NavbarSelectedTextColor
                    )
                }
                Spacer(modifier = Modifier().height(10.px))
                Column(
                    id = "components"
                ) {
                    components.forEach { component ->
                        ("/components/$component" == currentRoute).let {
                            SidebarSelectedTextComponent(selected = it, text = component, onThisElement = {
                                onClick = """
                        window.open("/components/${component}", "_self");
                    """.trimIndent()
                            })
                            Spacer(modifier = Modifier().height(if (it) 18.px else 15.px))
                        }
                    }
                }
            }
            content()
        }
    }
}