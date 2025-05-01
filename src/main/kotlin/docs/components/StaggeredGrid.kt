package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.StaggeredGrid(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "StaggeredGrid",
        topicDesc = "Creates staggered grid layouts using CSS column-based flow.",
        topicSignature = """fun FlowContent.StaggeredGrid(
    modifier: Modifier = Modifier(),
    columnCount: Int,
    columnGap: String = 16.px,
    className: String? = null,
    id: String? = null,
    onThisElement: DIV.() -> Unit = {},
    content: DIV.() -> Unit
)""",
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: Applies layout styles (margin, padding) to the grid</li>  
              <li>${Codeblock("columnCount")}: Number of vertical columns in the layout</li>  
              <li>${Codeblock("columnGap")}: Space between columns (default: 16px)</li>  
              <li>${Codeblock("className")}: CSS class for the container <code>&lt;div&gt;</code></li>  
              <li>${Codeblock("id")}: Unique ID for the grid container</li>  
              <li>${Codeblock("onThisElement")}: Adds attributes/configurations to the container</li>  
              <li>${Codeblock("content")}: Items to display in the staggered grid</li>  
            </ul>""".trimIndent(),
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