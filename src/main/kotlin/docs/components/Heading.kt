package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Heading(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "Heading", topicDesc = """
            Renders a generic HTML heading (`<h1>` to `<h6>`) based on the provided level.  
        """.trimIndent(), topicSignature = """
            fun FlowContent.Heading(
                level: Int,
                text: String,
                className: String? = null,
                id: String? = null,
                onThisElement: FlowOrHeadingContent.() -> Unit = {}
            )
        """.trimIndent(), paramsExplanation = """
            ${Codeblock("level")}: Heading level (1 to 6). Maps to <h1> through <h6>.

            ${Codeblock("text")}: The visible heading content.

            ${Codeblock("className")}: Optional CSS class for the heading.

            ${Codeblock("id")}: Optional ID attribute for the heading.

            ${Codeblock("onThisElement")}: Hook to apply extra attributes or nested elements inside the heading tag.
        """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/BreakFlow", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/Image", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "BreakFlow", nextBtnTxt = "Image"
    )
}