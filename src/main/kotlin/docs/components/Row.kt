package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Row(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Row",
        topicDesc = "`Row` is a horizontal layout container in Kapsule. It wraps a `<code>div</code>` and places child elements side by side. You can set spacing, alignment, CSS classes, IDs, and inline styles with the same `Modifier` system you know from Compose.",
        topicSignature = """fun FlowContent.Row(
                modifier: Modifier = Modifier(),
                verticalAlignment: VerticalAlignment = VerticalAlignment.None,
                horizontalAlignment: HorizontalAlignment = HorizontalAlignment.None, className: String? = null, id: String? = null,
                onThisElement: DIV.() -> Unit = {},
                content: DIV.() -> Unit
            )""".trimIndent(),
        paramsExplanation = """
${Codeblock("modifier")}: Build inline CSS for the <code>div</code> (padding, margin, background, flex, etc.).

${Codeblock("verticalAlignment")}: How children line up vertically inside the row (Top, Center, Bottom, or None).

${Codeblock("horizontalAlignment")}:How children space out horizontally (Start, Center, End, SpaceBetween, SpaceAround, SpaceEvenly, or None).

${Codeblock("className")}: Optional CSS class string for the <code>div</code>.

${Codeblock("id")}: Optional ID attribute for the <code>div</code>.

${Codeblock("onThisElement")}: A small DSL block to add extra attributes or listeners on the <code>div</code>.

${Codeblock("content")}: The block where you place child elements.""",
        exampleCodeForCurrentTopic = "",
        onPreviousBtnClick = {
            """
                        window.open("/components/Column", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Spacer", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Column",
        nextBtnTxt = "Spacer"
    )
}