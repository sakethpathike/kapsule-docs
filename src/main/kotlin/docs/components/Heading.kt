package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Heading(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "Heading", topicDesc = """Creates heading tags from <code>&lt;h1&gt;</code> to <code>&lt;h6&gt;</code> based on specified level.""".trimIndent(), topicSignature = """
            fun FlowContent.Heading(
                level: Int,
                text: String,
                className: String? = null,
                id: String? = null,
                onThisElement: FlowOrHeadingContent.() -> Unit = {}
            )
        """.trimIndent(), paramsExplanation = """<ul><li>${Codeblock("level")}: Creates <code>&lt;h1&gt;</code> to <code>&lt;h6&gt;</code> based on value (1-6)</li>  
  <li>${Codeblock("text")}: Visible heading content</li>  
  <li>${Codeblock("className")}: Optional CSS class for the heading</li>  
  <li>${Codeblock("id")}: Unique identifier for the heading</li>  
  <li>${Codeblock("onThisElement")}: Adds attributes/elements to the heading tag</li>  
</ul>  """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/BreakFlow", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/Image", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "BreakFlow", nextBtnTxt = "Image"
    )
}