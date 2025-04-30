package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Text(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "Text",
        topicDesc = "well...it's a text \uD83E\uDD13",
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
        paramsExplanation = """${Codeblock("text")}:  The actual text string (String) that you want to display.  This is the content that will be rendered on the page.

            ${Codeblock("fontSize")}:  The size of the text.  It defaults to "12.px".  You can use any valid CSS size unit (e.g., "16px", "1em", "0.8rem").

            ${Codeblock("fontFamily")}:  The font family to use for the text (e.g., "Arial", "Verdana", "Poppins").  If not provided, the browser's default font will be used.

            ${Codeblock("color")}:  The color of the text.  You can specify this using a named color (e.g., "red", "blue"), a hexadecimal value (e.g., "#ff0000"), or an RGB/RGBA value.

            ${Codeblock("fontWeight")}: The weight of the text (e.g., "normal", "bold", "bolder", "lighter", or numeric values like "400", "700").

            ${Codeblock("display")}:  The display property of the text.  It defaults to Display.Inline.  Other possible values include Display.Block, Display.InlineBlock, etc., which affect how the text is rendered within the surrounding HTML.

            ${Codeblock("className")}:  A string (String?) that allows you to set the class attribute of the <div> element that wraps the text.  This is useful for applying CSS styles defined elsewhere.

            ${Codeblock("id")}:  A string (String?) that allows you to set the id attribute of the <div> element that wraps the text.  This provides a unique identifier for the text element.

            ${Codeblock("textAlign")}: The horizontal alignment of the text. It defaults to TextAlign.Start. Other possible values are TextAlign.Center, TextAlign.End, TextAlign.Left, and TextAlign.Right.

            ${Codeblock("onThisElement")}: A lambda function that lets you add further configurations to the <div> element.

            ${Codeblock("modifier")}:  A Modifier object that allows you to apply Kapsule styling to the <div> element that wraps the text.
        """.trimIndent(),
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