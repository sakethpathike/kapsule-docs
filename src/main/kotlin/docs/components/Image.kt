package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Image(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "Image", topicDesc = """
              <li>Renders a configurable <code>&lt;img&gt;</code> element for displaying images</li>  
              <li>Controls alignment and scaling via <code>Modifier</code> properties</li>  
              <li>Supports both fixed layouts and responsive image behavior</li>  
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
)""".trimIndent(), paramsExplanation = """<ul><li>${Codeblock("modifier")}: Applies layout styles (padding, margin, border)</li>  
  <li>${Codeblock("alt")}: Descriptive text for accessibility</li>  
  <li>${Codeblock("src")}: Image source URL</li>  
  <li>${Codeblock("id")}: Unique identifier for the <code>&lt;img&gt;</code></li>  
  <li>${Codeblock("imgLoading")}: Native loading behavior (<code>lazy</code>/<code>eager</code>)</li>  
  <li>${Codeblock("className")}: CSS class for the <code>&lt;img&gt;</code></li>  
  <li>${Codeblock("contentScale")}: Image fitting mode (Cover/Contain)</li>  
  <li>${Codeblock("alignment")}: Position within container (Top/Center/Bottom)</li>  
  <li>${Codeblock("onThisElement")}: lets you interact with the element's scope beyond what kapsule directly offers</li>  
</ul>  """.trimIndent(), exampleCodeForCurrentTopic = """Image(
                    alignment = ObjectPosition.Predefined.Top,
                    modifier = Modifier().border(radius = 15.px, color = "black", width = 1.5.px)
                        .width(100.percent)
                        .clip(Shape.RoundedRectangle(15.px)),
                    src = "https://media-rockstargames-com.akamaized.net/mfe6/prod/__common/img/a5f10e6551f8214688a9600f50e5ad65.jpg?im=Resize=1920"
                )""".trimIndent(), onPreviousBtnClick = {
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