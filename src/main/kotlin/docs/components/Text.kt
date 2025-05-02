package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Text(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Text",
        topicDesc = "Well... it's a text <code>\uD83E\uDD13</code>\n",
        topicSignature = """fun FlowContent.Text(
    text: String,
    fontSize: String = 12.px, fontFamily: String? = null, color: String? = null, fontWeight: String? = null,
    display: Display? = Display.Inline,
    className: String? = null,
    id: String? = null,
    textAlign: TextAlign = TextAlign.Start,
    onThisElement: DIV.() -> Unit = {},
    modifier: Modifier = Modifier()
)""".trimIndent(),
        paramsExplanation = """<ul><li>${Codeblock("text")}: Content string rendered inside a <code>&lt;div&gt;</code></li>  
  <li>${Codeblock("fontSize")}: Text size (default: "12px"). Accepts CSS units like "em" or "rem"</li>  
  <li>${Codeblock("fontFamily")}: Typeface name (e.g., "Arial") or browser default</li>  
  <li>${Codeblock("color")}: Text color using names, hex codes, or RGB values</li>  
  <li>${Codeblock("fontWeight")}: Thickness from <code>normal</code> to <code>bold</code> (or numeric values)</li>  
  <li>${Codeblock("display")}: Layout behavior (<code>Display.Inline</code>, <code>Display.Block</code>)</li>  
  <li>${Codeblock("className")}: Optional CSS class for the wrapper <code>&lt;div&gt;</code></li>  
  <li>${Codeblock("id")}: Unique identifier for the wrapper <code>&lt;div&gt;</code></li>  
  <li>${Codeblock("textAlign")}: Horizontal alignment (<code>TextAlign.Start</code>, <code>TextAlign.Center</code>)</li>  
  <li>${Codeblock("onThisElement")}: Directly configures the wrapper <code>&lt;div&gt;</code></li>  
  <li>${Codeblock("modifier")}: Applies Kapsule styles to the wrapper <code>&lt;div&gt;</code></li>  
</ul>  """.trimIndent(),
        exampleCodeForCurrentTopic = "",
        showPreviousBtn = true,
        showNextBtn = true,
        onPreviousBtnClick = {
            """
                        window.open("/components/Surface", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Column", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Surface", nextBtnTxt = "Column"
    )
}