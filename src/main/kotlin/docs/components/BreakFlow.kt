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
    """.trimIndent(), paramsExplanation = """<ul><li>${Codeblock("onThisElement")}: lets you interact with the element's scope beyond what kapsule directly offers</li>  
  <li>${Codeblock("className")}: Optional CSS class for the <code>&lt;br&gt;</code> tag</li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>&lt;br&gt;</code> element</li>  
</ul>""".trimIndent(), exampleCodeForCurrentTopic = """Surface {
            Text(
                text = "Text 1",
                fontFamily = "Poppins",
                color = "black",
                fontWeight = "bold",
            )
            BreakFlow()
            Text(
                text = "Text 2",
                fontFamily = "Poppins",
                color = "black",
                fontWeight = "bold",
            )
        }""".trimIndent(), onPreviousBtnClick = {
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