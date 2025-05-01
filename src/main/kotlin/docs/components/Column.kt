package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Column(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Column", topicDesc = """
            The <code>Column</code> arranges items vertically in a layout.
        """.trimIndent(),
        topicSignature = """fun FlowContent.Column(
                        modifier: Modifier = Modifier(),
                        verticalAlignment: VerticalAlignment = VerticalAlignment.None,
                        horizontalAlignment: HorizontalAlignment = HorizontalAlignment.None, className: String? = null, id: String? = null,
                        onThisElement: DIV.() -> Unit = {},
                        content: DIV.() -> Unit
                    )""".trimIndent(),
        paramsExplanation = """<ul> <li>${Codeblock("modifier")}: Applies CSS styles (<code>padding</code>, <code>margin</code>, etc.) to the container</li>
  <li>${Codeblock("verticalAlignment")}: Sets <em>vertical positioning</em> of children</li>
  <li>${Codeblock("horizontalAlignment")}: Controls <em>horizontal arrangement</em> of children</li>
  <li>${Codeblock("className")}: Adds CSS class to the container <code>div</code></li>
  <li>${Codeblock("id")}: Sets DOM identifier for the <code>div</code></li>
  <li>${Codeblock("onThisElement")}: Directly configures the container <code>div</code></li>
  <li>${Codeblock("content")}: Defines child components in the column</li>
</ul>
                """.trimIndent(),
        exampleCodeForCurrentTopic = "",
        showPreviousBtn = true,
        showNextBtn = true,
        onPreviousBtnClick = {
            """
                        window.open("/components/Text", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Row", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Text",
        nextBtnTxt = "Row"
    )
}