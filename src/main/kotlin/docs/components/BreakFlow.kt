package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.BreakFlow(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "BreakFlow", topicDesc = """ 
          <li>Renders a <code>&lt;br&gt;</code> tag for manual line breaks</li>  
          <li>Used to separate components/elements vertically in layouts</li>  
    """.trimIndent(), topicSignature = """
        fun FlowContent.BreakFlow(
            onThisElement: BR.() -> Unit = {},
            className: String? = null,
            id: String? = null
        )
    """.trimIndent(), paramsExplanation = """<ul><li>${Codeblock("onThisElement")}: Configures the <code>&lt;br&gt;</code> element directly</li>  
  <li>${Codeblock("className")}: Optional CSS class for the <code>&lt;br&gt;</code> tag</li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>&lt;br&gt;</code> element</li>  
</ul>""".trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/TextInputField", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/Heading", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "TextInputField", nextBtnTxt = "Heading"
    )
}