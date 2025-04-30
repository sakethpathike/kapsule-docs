package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Button(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Button",
        topicDesc = "`Button` is a clickable element in Kapsule, built on top of the <code>kotlinx.html</code> DSL. It renders a <code>button</code> with your supplied styles, attributes, and click handler, letting you treat HTML buttons like Compose components.",
        topicSignature = """
            fun FlowContent.Button(
                modifier: Modifier,
                className: String? = null,
                onThisElement: BUTTON.() -> Unit = {},
                id: String? = null,
                onClick: () -> String,
                content: BUTTON.() -> Unit
            )
        """.trimIndent(),
        paramsExplanation = """
            ${Codeblock("modifier")}: A Compose-style Modifier that builds inline CSS for the <code>button</code> (padding, margin, background, size, etc.).

            ${Codeblock("className")}: Optional CSS class string to apply to the <code>button</code> element.

            ${Codeblock("onThisElement")}: A lambda on the raw BUTTON receiver. Use this to add extra attributes, event listeners, ARIA tags, or nested DSL calls before the content.

            ${Codeblock("id")}: Optional id attribute for the <code>button</code> element.

            ${Codeblock("onClick")}: A function returning the JavaScript snippet (as a String) to set as the button’s onclick attribute.

            ${Codeblock("content")}: A lambda on the BUTTON receiver defining the inner content—text, icons, or other nested components.
        """.trimIndent(),
        exampleCodeForCurrentTopic = "",
        onPreviousBtnClick = {
            """
                        window.open("/components/Box", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/TextInputField", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Box",
        nextBtnTxt = "TextInputField"
    )
}