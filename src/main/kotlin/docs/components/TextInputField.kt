package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.TextInputField(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "TextInputField", topicDesc = """
            Renders a generic styled <code>input type="text"</code> element.  
        """.trimIndent(), topicSignature = """
            fun FlowContent.TextInputField(
                value: String,
                className: String? = null,
                id: String? = null,
                fontWeight: String,
                fontSize: String,
                fontFamily: String,
                modifier: Modifier, onThisElement: INPUT.() -> Unit = {}
            )
        """.trimIndent(), paramsExplanation = """<ul><li>${Codeblock("value")}: Content of the <code>&lt;input&gt;</code> element</li>  
  <li>${Codeblock("className")}: CSS class for the <code>&lt;input&gt;</code></li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>&lt;input&gt;</code></li>  
  <li>${Codeblock("fontWeight")}: CSS <code>font-weight</code> (e.g., "bold" or "500")</li>  
  <li>${Codeblock("fontSize")}: CSS <code>font-size</code> (e.g., "16px")</li>  
  <li>${Codeblock("fontFamily")}: CSS <code>font-family</code> (e.g., "Inter")</li>  
  <li>${Codeblock("modifier")}: Applies layout styles (padding, margin, background)</li>  
  <li>${Codeblock("onThisElement")}: Adds attributes like <code>placeholder</code> or <code>disabled</code></li>  
</ul>  """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/Button", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/BreakFlow", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "Button", nextBtnTxt = "BreakFlow"
    )
}