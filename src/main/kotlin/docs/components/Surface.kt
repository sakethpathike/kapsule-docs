package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.Surface(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute, topicName = "Surface", topicDesc = """
              <strong>Surface</strong> is where you start building your web page with Kapsule. It’s like the <code>main</code> function in an app. It sets up the basic structure of the page, including the <code>&lt;head&gt;</code> and <code>&lt;body&gt;</code> sections, and lets you add your content inside.
              
              Before using <code>Surface</code>, you must call <code>createHTML().html { ... }</code> to provide the necessary HTML scope in which <code>Surface</code> operates.
       
         If you're using the ${Codeblock("MaterialIcon")} element, you must include <code>"https://fonts.googleapis.com/icon?family=Material+Icons"</code> in the <code>fonts</code> list passed to <code>Surface</code> so that the icons load properly.
          """.trimIndent(),
        topicSignature = """
            fun HTML.Surface(
                modifier: Modifier = Modifier(),
                fonts: List<String> = emptyList(),
                style: STYLE.() -> Unit = {},
                className: String? = null,
                id: String? = null,
                onTheHeadElement: HEAD.() -> Unit = {},
                onTheBodyElement: BODY.() -> Unit = {},
                content: BODY.() -> Unit = {}
            )
        """.trimIndent(),
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: Applies styles/layout via <code>Modifier</code> to <code>&lt;body&gt;</code> (default: empty modifier)</li>  
  <li>${Codeblock("fonts")}: List of font URLs added as <code>&lt;link&gt;</code> tags in <code>&lt;head&gt;</code> (requires "http" URLs)</li>  
  <li>${Codeblock("style")}: Defines CSS styles in a <code>&lt;style&gt;</code> tag using <code>STYLE</code> class properties</li>  
  <li>${Codeblock("className")}: Sets <code>class</code> attribute for <code>&lt;body&gt;</code> (optional)</li>  
  <li>${Codeblock("id")}: Sets unique <code>id</code> for <code>&lt;body&gt;</code> (optional)</li>  
  <li>${Codeblock("onTheHeadElement")}: lets you interact with the head's scope beyond what kapsule directly offers</li>  
  <li>${Codeblock("onTheBodyElement")}: lets you interact with the body's scope beyond what kapsule directly offers</li>  
  <li>${Codeblock("content")}: Main page content rendered inside <code>&lt;body&gt;</code></li>  
</ul>  
""".trimIndent(),
        exampleCodeForCurrentTopic = """
                <pre>createHTML().html {
        Surface(
            fonts = listOf(
                "https://fonts.googleapis.com/css2?family=family=Inter&family=JetBrains+Mono&display=swap"
            ), modifier = Modifier().padding(0.px).margin(0).backgroundColor("#292929").custom(
                ""${'"'} overflow : hidden
        ""${'"'}.trimIndent()
            )
        ) {
            Column(
                modifier = Modifier().custom(
                    ""${'"'} top :0
        ""${'"'}.trimIndent()
                ).position(Position.Sticky).zIndex(1000)
            ) {
                Row(
                    modifier = Modifier().fillMaxWidth().height(65.px).backgroundColor("#1b1b1b"),
                    verticalAlignment = VerticalAlignment.SpaceBetween,
                    horizontalAlignment = HorizontalAlignment.Center
                ) {
                    // <i>code</i>
                }
            }
        }
    }.let {
        println(it)
    }</pre>""".trimIndent(),
        showPreviousBtn = true,
        showNextBtn = true,
        onPreviousBtnClick = {
            """
                        window.open("/", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = {
            """
                        window.open("/components/Text", "_self");
                    """.trimIndent()
        },
        previousBtnTxt = "Getting Started", nextBtnTxt = "Text"
    )
}