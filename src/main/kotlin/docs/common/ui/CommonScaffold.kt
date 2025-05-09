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
            "https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded",
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
                modifier = Modifier.fillMaxWidth().height(65.px).backgroundColor(Colors.surfaceDark),
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center
            ) {
                Row(horizontalAlignment = HorizontalAlignment.Center) {
                    span(classes = "material-symbols-rounded") {
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
                    Text(
                        modifier = userSelectMod,
                        text = "kapsule",
                        fontFamily = "Megrim",
                        color = Colors.TopAppBarTitleContentColor,
                        fontSize = 25.px,
                        fontWeight = FontWeight.Predefined.Bold
                    )

                }
                Button(
                    modifier = Modifier.padding(5.px).backgroundColor(Colors.ButtonContainerColor).cursor(Cursor.Pointer)
                        .margin(end = 10.px).height(35.px).borderRadius(15.px), onClick = {
                        """
                        window.open("https://github.com/sakethpathike/kapsule", "_blank");
                """.trimIndent()
                    }) {
                    Row(
                        horizontalAlignment = HorizontalAlignment.Center
                    ) {
                        Text(
                            text = "kapsule on",
                            fontWeight = FontWeight.Predefined.Medium,
                            fontFamily = "Inter",
                            color = Colors.ButtonContentColor
                        )
                        Spacer(modifier = Modifier.width(5.px))
                        Image(
                            src = "/static/images/github.png",
                            modifier = Modifier.size(18.px).color(Colors.ButtonContentColor)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(1.px).backgroundColor(Colors.outlineDark))
        }
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                id = "topics-panel", modifier = Modifier.custom(
                    """
                          overflow-y: auto;
                    """.trimIndent()
                ).position(Position.Sticky).zIndex(999).width(20.vw)
                    .backgroundColor(color = Colors.surfaceDark)
                    .padding(value = 15.px)
            ) {
                SidebarSelectableTextComponent(
                    applyInitialPadding = currentRoute == "/",
                    selected = (currentRoute == "/"),
                    text = "Getting started",
                    onThisElement = {
                        onClick = """
                                window.open("/", "_self");
                              """.trimIndent()
                    })
                Spacer(modifier = Modifier.height(25.px))
                Row(
                    modifier = Modifier.then(userSelectMod),
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
                    /* span(classes = "material-icons"){
                         id = "componentsExpandEmoji"
                         style = Modifier.custom(
                             """
                                 font-size: 20px
                             """.trimIndent()
                         ).color(Colors.TopAppBarTitleContentColor).toString()
                         +"keyboard_arrow_up"
                     }
                     Spacer(modifier = Modifier.width(10.px))*/
                    Text(
                        text = "Components", fontSize = 16.px,
                        fontWeight = FontWeight.Predefined.Bold,
                        fontFamily = "Inter", color = Colors.NavbarSelectedTextColor
                    )
                }
                Spacer(modifier = Modifier.height(15.px))
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
                            Spacer(modifier = Modifier.height(15.px))
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(10.px)
                        .border(width = 2.5.px, radius = 15.px, color = Colors.primaryDark),
                ) {
                    MaterialIcon(iconCode = "info", modifier = Modifier.color(Colors.primaryDark))
                    Spacer(modifier = Modifier.height(5.px))
                    Text(
                        color = Colors.onSurfaceDark,
                        fontFamily = "Inter",
                        fontSize = 16.px,
                        text = "<strong> Docs are a work-in-progress.</strong> But if you're familiar with Jetpack Compose, kapsule will feel instantly familiar. I’ve included comments in the code for most modifiers, so your IDE's doc preview should help you out."
                    )
                }
                Spacer(modifier = Modifier.height(150.px))
            }
            content()
        }
    }
}