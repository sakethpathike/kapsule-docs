package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Box(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Box",
        topicDesc = "`Box` is a generic container component in Kapsule. It wraps a `<code>div</code>` and lets you apply modifiers, CSS classes, IDs, and raw DSL calls before placing any nested content. Use it whenever you need a flexible wrapper for styling or attaching attributes.",
        topicSignature = """fun FlowContent.Box(
    modifier: Modifier,
    className: String? = null,
    onThisElement: DIV.() -> Unit = {},
    id: String? = null,
    init: DIV.() -> Unit
) {
    div(classes = className) {
        if (id != null) {
            this.id = id
        }
        style = modifier.buildStyle()
        onThisElement()
        init()
    }
}""".trimIndent(),
        exampleCodeForCurrentTopic = "",
        paramsExplanation = """${Codeblock("modifier")}: A Compose-style Modifier that builds inline CSS for the <code>div</code> (padding, margin, size, background, flex, etc.).

            ${Codeblock("className")}: Optional CSS class string to apply to the <code>div</code> container.

            ${Codeblock("onThisElement")}: Lambda on the raw DIV receiver. Use this to add extra attributes, event listeners, data-attributes, or nested DSL calls before the content.

            ${Codeblock("id")}: Optional id attribute for the <code>div</code> container.
    
            ${Codeblock("init")}: Lambda defining the nested content inside the <code>div</code>. Write any Kapsule components or raw HTML DSL calls here.
        """.trimIndent(),
        onPreviousBtnClick = {
            """
                        window.open("/components/Spacer", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Button", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Spacer",
        nextBtnTxt = "Button"
    )
}