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
  <li>${Codeblock("onThisElement")}: lets you interact with the element's scope beyond what kapsule directly offers</li>  
</ul>  """.trimIndent(), exampleCodeForCurrentTopic = """Surface {
            Column {
                TextInputField(
                    id = "inputField",
                    value = "",
                    fontWeight = 12.px,
                    fontSize = 15.px,
                    modifier = Modifier().margin(top = 1.rem, bottom = 0.px, start = 0.px, end = 0.px)
                        .cursor(Cursor.Pointer).boxSizing(BoxSizing.BorderBox)
                        .border(width = 1, radius = 4, color = "rgba(208, 188, 255, 0.3)")
                        .backgroundColor("#2D2A31").width("100%").padding(0.75.rem)
                        .transition(TransitionBuilder().custom("all 0.3s ease")).color("white"),
                    fontFamily = "Poppins"
                )
                Spacer(modifier = Modifier().height(15.px))
                Button(
                    modifier = Modifier().custom(
                        ""${'"'}
                        align-self:flex-start;
                    ""${'"'}.trimIndent()
                    ).border(radius = 15, color = "black"), onClick = {
                        ""${'"'}
                        document.getElementById("inputFieldText").textContent = document.getElementById("inputField").value;
                    ""${'"'}.trimIndent()
                    }) {
                    Text(
                        text = "change text", fontFamily = "Poppins", modifier = Modifier()
                    )
                }
                Spacer(modifier = Modifier().height(5.px))
                Text(
                    id = "inputFieldText",
                    text = "",
                    fontFamily = "Poppins",
                    color = "black",
                    fontWeight = "bold",
                )
            }
        }""".trimIndent(), onPreviousBtnClick = {
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