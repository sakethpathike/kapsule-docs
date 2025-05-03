package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Row(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Row",
        topicDesc = "<code>Row</code> arranges items <em>horizontally</em>.",
        topicSignature = """fun FlowContent.Row(
                modifier: Modifier = Modifier(),
                verticalAlignment: VerticalAlignment = VerticalAlignment.None,
                horizontalAlignment: HorizontalAlignment = HorizontalAlignment.None, className: String? = null, id: String? = null,
                onThisElement: DIV.() -> Unit = {},
                content: DIV.() -> Unit
            )""".trimIndent(),
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: CSS styles for the <code>div</code> (padding, margin, flex)</li>  
              <li>${Codeblock("verticalAlignment")}: Child alignment <em>vertically</em> (Top/Center/Bottom)</li>  
              <li>${Codeblock("horizontalAlignment")}: Child spacing <em>horizontally</em> (Start/SpaceBetween/etc)</li>  
              <li>${Codeblock("className")}: Optional CSS class for the <code>div</code></li>  
              <li>${Codeblock("id")}: Unique identifier for the <code>div</code></li>  
              <li>${Codeblock("onThisElement")}: lets you interact with the element's scope beyond what kapsule directly offers</li>  
              <li>${Codeblock("content")}: Child elements inside the <code>div</code></li>  
            </ul>
        """.trimIndent(),
        exampleCodeForCurrentTopic = """Surface {
            Row(
                modifier = Modifier().fillMaxWidth(),
                verticalAlignment = VerticalAlignment.SpaceBetween,
                horizontalAlignment = HorizontalAlignment.Center
            ) {
                Text(
                    text = "Text 1",
                    modifier = Modifier().margin(15.px),
                    fontFamily = "Poppins",
                    color = "black",
                    fontWeight = "bold"
                )
                Text(
                    text = "Text 2",
                    modifier = Modifier().margin(15.px),
                    fontFamily = "Poppins",
                    color = "black",
                    fontWeight = "bold"
                )
            }
        }""".trimIndent(),
        onPreviousBtnClick = {
            """
                        window.open("/components/Column", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Spacer", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Column",
        nextBtnTxt = "Spacer"
    )
}