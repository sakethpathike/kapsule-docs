package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Box(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Box",
        topicDesc = "<code>Box</code> creates a flexible container using a <code>div</code> wrapper",
        topicSignature = """fun FlowContent.Box(
    modifier: Modifier,
    className: String? = null,
    onThisElement: DIV.() -> Unit = {},
    id: String? = null,
    init: DIV.() -> Unit
)""".trimIndent(),
        exampleCodeForCurrentTopic = "",
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: Builds inline CSS styles for the <code>div</code> (padding, margin, flex properties)</li>  
  <li>${Codeblock("className")}: Optional CSS class for the container <code>div</code></li>  
  <li>${Codeblock("onThisElement")}: Adds attributes/event listeners to the <code>div</code></li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>div</code></li>  
  <li>${Codeblock("init")}: Defines nested content inside the <code>div</code></li>  
</ul>  """.trimIndent(),
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