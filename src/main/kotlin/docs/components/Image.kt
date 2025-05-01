package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Image(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "Image", topicDesc = """
            Renders a styled `<img>` tag with support for alignment, scaling behavior, and layout via `Modifier`.  
            Useful for static or responsive images with full control over how they fit and align.
        """.trimIndent(), topicSignature = """fun FlowContent.Image(
    modifier: Modifier = Modifier(),
    alt: String? = null,
    src: String,
    id: String? = null,
    imgLoading: ImgLoading? = null,
    className: String? = null,
    contentScale: ContentScale = ContentScale.Cover,
    alignment: ObjectPosition = ObjectPosition.Predefined.Center,
    onThisElement: IMG.() -> Unit = {}
)""".trimIndent(), paramsExplanation = """
            ${Codeblock("modifier")}: Layout and visual styling (padding, margin, border, etc).

            ${Codeblock("alt")}: Alternate text for accessibility and fallback.

            ${Codeblock("src")}: Image URL or file path.

            ${Codeblock("id")}: Optional HTML ID for targeting.

            ${Codeblock("imgLoading")}: Sets native image loading attribute (lazy, eager, or null).

            ${Codeblock("className")}: Optional CSS class.

            ${Codeblock("contentScale")}: Defines how the image fits its box (Cover, Contain, etc).

            ${Codeblock("alignment")}: Controls image alignment inside the box (e.g., Top, Center, Bottom).

            ${Codeblock("onThisElement")}: Optional hook to modify the <img> tag (e.g., add referrerpolicy, decoding, etc).
        """.trimIndent(), exampleCodeForCurrentTopic = "", onPreviousBtnClick = {
        """
                        window.open("/components/Heading", "_self");
                    """.trimIndent()
    }, onNextBtnClick = {
        """
                        window.open("/components/StaggeredGrid", "_self");
                    """.trimIndent()
    }, previousBtnTxt = "Heading", nextBtnTxt = "StaggeredGrid"
    )
}