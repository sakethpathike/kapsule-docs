package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.StaggeredGrid(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "StaggeredGrid",
        topicDesc = """Renders a CSS column-based **staggered grid layout** using `<div>`.""",
        topicSignature = """fun FlowContent.StaggeredGrid(
    modifier: Modifier = Modifier(),
    columnCount: Int,
    columnGap: String = 16.px,
    className: String? = null,
    id: String? = null,
    onThisElement: DIV.() -> Unit = {},
    content: DIV.() -> Unit
)""",
        paramsExplanation = """${Codeblock("modifier")}: Layout and styling (margin, padding, etc).

${Codeblock("columnCount")}: Number of vertical columns.

${Codeblock("columnGap")}: Space between columns (default 16px).

${Codeblock("className")}: Optional CSS class for the container.

${Codeblock("id")}: Optional ID for the grid container.

${Codeblock("onThisElement")}: Hook to modify the container directly.

${Codeblock("content")}: Grid items/content to be placed inside the staggered layout.""",
        exampleCodeForCurrentTopic = "TODO()",
        showNextBtn = false,
        onPreviousBtnClick = {
            """
                        window.open("/components/Image", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = { "" },
        previousBtnTxt = "Image",
        nextBtnTxt = ""
    )
}