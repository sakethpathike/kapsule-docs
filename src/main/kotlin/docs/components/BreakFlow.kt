package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.BreakFlow(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "BreakFlow", topicDesc = """
        Renders a generic `<br>` tag to break flow in the layout.  
        Useful when you want to manually add line breaks between components or elements.
    """.trimIndent(), topicSignature = """
        fun FlowContent.BreakFlow(
            onThisElement: BR.() -> Unit = {},
            className: String? = null,
            id: String? = null
        )
    """.trimIndent(), paramsExplanation = """
        ${Codeblock("onThisElement")}: Optional hook to modify the <br> element directly.

        ${Codeblock("className")}: Optional CSS class for the <br> tag.

        ${Codeblock("id")}: Optional ID attribute.
    """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/TextInputField", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/Heading", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "TextInputField", nextBtnTxt = "Heading"
    )
}