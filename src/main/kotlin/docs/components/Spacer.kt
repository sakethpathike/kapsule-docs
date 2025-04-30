package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Spacer(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Spacer",
        topicDesc = "`Spacer` is a simple utility component in Kapsule that renders an empty `<code>div</code>` to occupy space. It behaves like an inline-block element and accepts all the usual modifiers, CSS classes, and IDs. Use it when you need precise control over spacing in your layout.",
        topicSignature = """fun FlowContent.Spacer(
    className: String? = null,
    id: String? = null,
    onThisElement: DIV.() -> Unit = {},
    modifier: Modifier = Modifier()
)""".trimIndent(),
        paramsExplanation = """
            (wrap spacer around box, if raw spacer doesnt work)
            
            ${Codeblock("className")}: Optional CSS class string to apply to the spacer <code>div</code>.

            ${Codeblock("id")}: Optional id attribute for the spacer <code>div</code>.

            ${Codeblock("onThisElement")}: A lambda on the raw DIV receiver. Use this to add extra attributes, event listeners, or nested DSL calls on the spacer element.

            ${Codeblock("modifier")}: A Compose-style Modifier that builds inline CSS for the spacer. By default it sets display: inline-block, and you can chain padding, margin, width, height, or any other CSS properties.
        """.trimIndent(),
        exampleCodeForCurrentTopic = "",
        onPreviousBtnClick = {
            """
                        window.open("/components/Row", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Box", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Row",
        nextBtnTxt = "Box"
    )
}