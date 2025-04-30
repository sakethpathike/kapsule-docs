package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Column(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Column",
        topicDesc = "The `Column` function is a layout component that arranges its child elements vertically, similar to the `Column` in Jetpack Compose. It provides alignment options and styling capabilities using the `Modifier` pattern, making it ideal for building structured vertical layouts.",
        topicSignature = """fun FlowContent.Column(
                        modifier: Modifier = Modifier(),
                        verticalAlignment: VerticalAlignment = VerticalAlignment.None,
                        horizontalAlignment: HorizontalAlignment = HorizontalAlignment.None, className: String? = null, id: String? = null,
                        onThisElement: DIV.() -> Unit = {},
                        content: DIV.() -> Unit
                    )""".trimIndent(),
        paramsExplanation = """${Codeblock("modifier")}: Applies inline CSS styles to the <code>div</code> element using the Modifier instance. This includes properties like padding, margin, background color, etc.

                    ${Codeblock("verticalAlignment")}: Specifies the vertical alignment of child elements within the column.

                    ${Codeblock("horizontalAlignment")}: Determines the horizontal alignment of child elements
                    
                    ${Codeblock("className")}: Optional CSS class to be applied to the <code>div</code> element.

                    ${Codeblock("id")}: Optional id attribute for the <code>div</code> element.

                    ${Codeblock("onThisElement")}: A lambda function that allows additional configurations or attributes to be applied directly to the <code>div</code> element.

                    ${Codeblock("content")}: A lambda function that defines the child elements to be placed inside the column.
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