package docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.*
import sakethh.kapsule.*
import sakethh.kapsule.utils.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

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
    val userSelectMod = Modifier.custom(
        """
          user-select: none;
        """.trimIndent()
    )
    Surface(
        style = {
            unsafe {
                +"""
                    ::selection {
                      background: ${Colors.primaryDark};
                      color: ${Colors.onPrimaryDark};
                    }
                    """.trimIndent()
            }
        },
        fonts = listOf(
                "https://fonts.googleapis.com/icon?family=Material+Icons",
            "https://fonts.googleapis.com/css2?family=Inter&family=JetBrains+Mono&family=Megrim&display=swap"
        ), modifier = Modifier.padding(0.px).margin(0).backgroundColor(Colors.Background).custom(
            """
            overflow: hidden;
        """.trimIndent()
        ), onTheHeadElement = {
            unsafe {
                raw(
                    """
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                """.trimIndent()
                )
            }
        }, onTheBodyElement = {
            script(type = ScriptType.textJavaScript) {
                unsafe {
                    +"""
      document.addEventListener("DOMContentLoaded", () => {
        const I_HAD_A_GODDAMNN_PLAN = document.getElementById("I_HAD_A_GODDAMNN_PLAN");
        const isMobile = window.matchMedia("(max-width: 767px)").matches;
        
        const topicPanel = document.getElementById("topics-panel")
        if(isMobile){
            kapsuleExpandEmoji.textContent = "arrow_right";
            topicPanel.style.display = "none";
            topicPanel.style.width = "100vw";
        }else{
            kapsuleExpandEmoji.textContent = "arrow_left";
            topicPanel.style.display = "block";
        }
        
        if (I_HAD_A_GODDAMNN_PLAN) I_HAD_A_GODDAMNN_PLAN.style.width = isMobile ? "100%" : "450px";
      });
      """.trimIndent()
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.custom(
                """
                top:0;
            """.trimIndent()
            ).position(Position.Sticky).zIndex(1000)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().height(65.px)
                    .backgroundColor(Colors.TopAppBarScrolledContainerColor),
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center
            ) {
                Row(horizontalAlignment = HorizontalAlignment.Center) {
                    span(classes = "material-icons") {
                        id = "kapsuleExpandEmoji"
                        style = Modifier.custom(
                            """
                            font-size: 45px;
                        """.trimIndent()
                        ).color(Colors.TopAppBarTitleContentColor).cursor(Cursor.Pointer).toString()
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
                    Row {
                        Text(
                            modifier = userSelectMod,
                            text = "kapsule",
                            fontFamily = "Megrim",
                            color = Colors.TopAppBarTitleContentColor,
                            fontSize = 25.px,
                            fontWeight = FontWeight.Predefined.Bold
                        )
                        val kapsuleVersion = HttpClient.newHttpClient().send(
                            HttpRequest.newBuilder().GET()
                                .uri(URI.create("https://repo1.maven.org/maven2/io/github/sakethpathike/kapsule/maven-metadata.xml"))
                                .build(), HttpResponse.BodyHandlers.ofString()
                        ).run {
                            this.body() ?: "0.0.5"
                        }.substringAfter("<latest>").substringBefore("</latest>")

                        Text(
                            modifier = userSelectMod.opacity(0.5),
                            text = kapsuleVersion,
                            fontFamily = "Inter",
                            color = Colors.TopAppBarTitleContentColor,
                            fontSize = 14.px,
                            fontWeight = FontWeight.Predefined.Light
                        )
                    }

                }
                Row(
                    horizontalAlignment = HorizontalAlignment.Center,
                    modifier = Modifier.cursor(Cursor.Pointer).margin(end = 15.px).height(35.px),
                    onThisElement = {
                        onClick = """
                        window.open("https://github.com/sakethpathike/kapsule", "_blank");
                    """.trimIndent()
                    }) {
                    span(classes = "material-icons") {
                        style = Modifier.custom(
                            """
                                font-size: 20px
                            """.trimIndent()
                        ).color(Colors.TopAppBarTitleContentColor).toString()
                        +"star"
                    }
                    Spacer(modifier = Modifier.width(5.px))
                    Text(
                        text = " on Github", fontFamily = "Inter", fontWeight = FontWeight.Predefined.Bold, color = Colors.TopAppBarTitleContentColor,
                        fontSize = 14.px,
                    )
                    Spacer(modifier = Modifier.width(5.px))
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(1.25.px).backgroundColor("#ffffff"))
        }
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                id = "topics-panel", modifier = Modifier.fillMaxHeight().custom(
                    """
                          overflow-y: auto;
                    """.trimIndent()
                ).position(Position.Sticky).zIndex(999).height(100.vh).width(20.vw)
                    .backgroundColor(color = Colors.NavigationBarColor)
                    .padding(value = 15.px)
            ) {
                (currentRoute == "/").let {
                    SidebarSelectableTextComponent(selected = it, text = "Getting started", onThisElement = {
                        onClick = """
                                    window.open("/", "_self");
                                  """.trimIndent()
                    })
                    Spacer(modifier = Modifier.height(if (it) 18.px else 15.px))
                }
                Row(
                    modifier = Modifier.cursor(Cursor.Pointer).then(userSelectMod),
                    horizontalAlignment = HorizontalAlignment.Center,
                    onThisElement = {
                        onClick = """
                                const components = document.getElementById("components");
                                const componentsExpandEmoji = document.getElementById("componentsExpandEmoji");
                                if (components.style.display === "none") {
                                    componentsExpandEmoji.textContent = "keyboard_arrow_up";
                                    components.style.display = "block";
                                } else {
                                    componentsExpandEmoji.textContent = "keyboard_arrow_down";
                                    components.style.display = "none";
                                }
                            """.trimIndent()
                    }) {
                    span(classes = "material-icons"){
                        id = "componentsExpandEmoji"
                        style = Modifier.custom(
                            """
                                font-size: 20px
                            """.trimIndent()
                        ).color(Colors.TopAppBarTitleContentColor).toString()
                        +"keyboard_arrow_up"
                    }
                    Spacer(modifier = Modifier.width(10.px))
                    Text(
                        text = "Components",
                        fontSize = 20.px,
                        fontWeight = FontWeight.Predefined.Bold,
                        fontFamily = "Inter", color = Colors.NavbarSelectedTextColor
                    )
                }
                Spacer(modifier = Modifier.height(10.px))
                Column(
                    id = "components"
                ) {
                    components.forEach { component ->
                        ("/components/$component" == currentRoute).let {
                            SidebarSelectableTextComponent(selected = it, text = component, onThisElement = {
                                onClick = """
                        window.open("/components/${component}", "_self");
                    """.trimIndent()
                            })
                            Spacer(modifier = Modifier.height(if (it) 18.px else 15.px))
                        }
                    }
                }
            }
            content()
        }
    }
}