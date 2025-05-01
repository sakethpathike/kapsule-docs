package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.TextInputField(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "TextInputField", topicDesc = """
            Renders a generic styled <code>input type="text"</code> element.  
        """.trimIndent(), topicSignature = """
            fun FlowContent.TextInputField(
                value: String,
                className: String? = null,
                id: String? = null,
                fontWeight: String,
                fontSize: String,
                fontFamily: String,
                modifier: Modifier, onThisElement: INPUT.() -> Unit = {}
            )
        """.trimIndent(), paramsExplanation = """
            ${Codeblock("value")}: Text content of the input.

            ${Codeblock("className")}: Optional CSS class.

            ${Codeblock("id")}: Optional element ID.

            ${Codeblock("fontWeight")}: CSS font-weight (e.g., "500", "bold").

            ${Codeblock("fontSize")}: CSS font-size (e.g., "16px").

            ${Codeblock("fontFamily")}: CSS font-family (e.g., "Poppins").

            ${Codeblock("modifier")}: Adds layout/style like padding, margin, background, etc.

            ${Codeblock("onThisElement")}: Hook to add attributes like placeholder, name, disabled, etc.
        """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/Button", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/BreakFlow", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "Button", nextBtnTxt = "BreakFlow"
    )
}