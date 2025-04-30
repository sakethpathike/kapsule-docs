package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Surface(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Surface",
        topicDesc = "The Surface function is the primary entry point for building web pages using Kapsule. You can think of it as the starting point, like the main entry function in a typical application. It sets up the basic structure of your HTML page, including the head and body sections, and allows you to define the content within.",
        topicSignature = """
            fun HTML.Surface(
                modifier: Modifier = Modifier(),
                fonts: List<String> = emptyList(),
                style: STYLE.() -> Unit = {},
                className: String? = null,
                id: String? = null,
                onTheHeadElement: HEAD.() -> Unit = {},
                onTheBodyElement: BODY.() -> Unit = {},
                content: BODY.() -> Unit = {}
            )
        """.trimIndent(),
        paramsExplanation = """${Codeblock("modifier")}: This parameter takes a Modifier object.  A Modifier is used to apply styling and layout properties to the <code>body</code> of your HTML page.  If you don't provide a Modifier, it defaults to an empty Modifier, meaning no extra styles will be applied directly.

   ${Codeblock("fonts")}: This is a list of strings (List<String>).  It allows you to specify URLs for any fonts you want to include in your webpage.  These are typically links to font files hosted on services like Google Fonts.  The Surface function will automatically add these font URLs as <link> tags within the <head> section of your HTML. Only URLs starting with "http" will be added.

    ${Codeblock("style")}: This parameter is a lambda function (a block of code) that lets you define CSS styles for the entire page.  The code you write inside this block will be placed within a <code>style</code> tag in the <head> section of your HTML.  You use the STYLE class and its properties to define your CSS.
    
    ${Codeblock("className")}: A string (String?) that allows you to set the class attribute of the <code>body</code> element.  This is useful for applying CSS styles that are defined in an external stylesheet or within the <code>style</code> tag.  If you don't provide a value, the <code>body</code> element won't have a class attribute.

    ${Codeblock("id")}: A string (String?) that allows you to set the id attribute of the <code>body</code> element.  The id attribute provides a unique identifier for the <code>body</code> element, which can be useful for JavaScript manipulation or specific CSS styling. If you don't provide a value, the <code>body</code> element won't have an id attribute.

    ${Codeblock("onTheHeadElement")}:  This is a lambda function that lets you add elements directly into the <head> section of your HTML page.  The code inside this block operates within the context of the HEAD element, allowing you to add tags like <code>meta</code>, <code>title</code>, or any other valid head elements.

    ${Codeblock("onTheBodyElement")}: This is a lambda function that lets you add attributes directly to the <code>body</code> section of your HTML page.

    ${Codeblock("content")}:  This is the most important lambda function.  It's where you define the actual content of your webpage.  The code you write here will be placed inside the <code>body</code> section of your HTML. The code inside this block operates within the context of the BODY element.
            """.trimIndent(),
        exampleCodeForCurrentTopic = """
                <pre>Surface(
    fonts =
        listOf(
            "https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Poppins&family=JetBrains+Mono&display=swap"
        ),
    modifier =
        Modifier()
            .padding(0.px)
            .margin(0)
            .backgroundColor("#292929")
            .custom(
                ""${'"'}
            overflow: hidden;
        ""${'"'}.trimIndent()
            )
) {
    Column(
        modifier =
            Modifier()
                .custom(
                    ""${'"'}
                top:0;
            ""${'"'}.trimIndent()
                )
                .position(Position.Sticky)
                .zIndex(1000)
    ) {
        Row(
            modifier = Modifier().fillMaxWidth().height(65.px).backgroundColor("#1b1b1b"),
            verticalAlignment = VerticalAlignment.SpaceBetween,
            horizontalAlignment = HorizontalAlignment.Center
        ) {
            // <i>code</i>
        }
    }
}</pre>""".trimIndent(),
        showPreviousBtn = true,
        showNextBtn = true,
        onPreviousBtnClick = {
            """
                        window.open("/", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Text", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Getting Started", nextBtnTxt = "Text"
    )
}