package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Button(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Button",
        topicDesc = "Well... it's a button <code>\uD83E\uDD13</code>\n",
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
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: Applies CSS styles to the <code>button</code> (padding, background, etc.)</li>  
  <li>${Codeblock("className")}: Optional CSS class for the <code>button</code></li>  
  <li>${Codeblock("onThisElement")}: Adds attributes/event listeners to the <code>button</code></li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>button</code></li>  
  <li>${Codeblock("onClick")}: Defines JavaScript click handler as a string</li>  
  <li>${Codeblock("content")}: Defines inner content (text/icons) within the <code>button</code></li>  
</ul>""".trimIndent(),
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