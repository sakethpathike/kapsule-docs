package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Spacer(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Spacer",
        topicDesc = "<code>Spacer</code> creates an empty <code>div</code> for layout spacing.\n<li>Wrap in ${Codeblock("Box")} if raw spacer needs container behavior.</li>",
        topicSignature = """fun FlowContent.Spacer(
    className: String? = null,
    id: String? = null,
    onThisElement: DIV.() -> Unit = {},
    modifier: Modifier = Modifier()
)""".trimIndent(),
        paramsExplanation = """<ul class><li>${Codeblock("className")}: CSS class for spacer <code>div</code></li>  
  <li>${Codeblock("id")}: Unique identifier for spacer <code>div</code></li>  
  <li>${Codeblock("onThisElement")}: Configure spacer <code>div</code> attributes/listeners</li>  
  <li>${Codeblock("modifier")}: Builds CSS styles (default: <code>display: inline-block</code>)</li>  
</ul>  """.trimIndent(),
        exampleCodeForCurrentTopic = """Surface {
            Row {
                Text(
                    text = "Text 1",
                    fontFamily = "Poppins",
                    color = "black",
                    fontWeight = "bold"
                )
                Spacer(modifier = Modifier().width(15.px))
                Text(
                    text = "Text 2",
                    fontFamily = "Poppins",
                    color = "black",
                    fontWeight = "bold"
                )
            }
        }""".trimIndent(),
        onPreviousBtnClick = {
            """
                        window.open("/components/Row", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Box", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Row",
        nextBtnTxt = "Box"
    )
}