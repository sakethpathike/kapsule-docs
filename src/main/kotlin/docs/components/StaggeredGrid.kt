package io.github.sakethpathike.docs.components

import io.github.sakethpathike.docs.common.ui.Codeblock
import io.github.sakethpathike.docs.common.ui.TopicUI
import kotlinx.html.HTML

fun HTML.StaggeredGrid(currentRoute: String) {
    TopicUI(
        currentRoute = currentRoute,
        topicName = "StaggeredGrid",
        topicDesc = "Creates staggered grid layouts using CSS column-based flow.",
        topicSignature = """fun FlowContent.StaggeredGrid(
    modifier: Modifier = Modifier(),
    columnCount: Int,
    columnGap: String = 16.px,
    className: String? = null,
    id: String? = null,
    onThisElement: DIV.() -> Unit = {},
    content: DIV.() -> Unit
)""",
        paramsExplanation = """<ul><li>${Codeblock("modifier")}: Applies layout styles (margin, padding) to the grid</li>  
              <li>${Codeblock("columnCount")}: Number of vertical columns in the layout</li>  
              <li>${Codeblock("columnGap")}: Space between columns (default: 16px)</li>  
              <li>${Codeblock("className")}: CSS class for the container <code>&lt;div&gt;</code></li>  
              <li>${Codeblock("id")}: Unique ID for the grid container</li>  
              <li>${Codeblock("onThisElement")}: Adds attributes/configurations to the container</li>  
              <li>${Codeblock("content")}: Items to display in the staggered grid</li>  
            </ul>""".trimIndent(),
        exampleCodeForCurrentTopic = """Surface {
            StaggeredGrid(
                columnCount = 4, columnGap = 5.px
            ) {
                listOf(
                    "https://i.pinimg.com/474x/89/df/25/89df257c964ebb170535a793f8f30ca3.jpg",
                    "https://i.pinimg.com/736x/51/83/16/5183165c9a10c4c3c65f802b633d3cbe.jpg",
                    "https://i.pinimg.com/474x/e7/87/4a/e7874a10123250c01738a11b785adab7.jpg",
                    "https://i.pinimg.com/474x/91/80/53/9180537435f5a767bc65966eb6802768.jpg",
                    "https://i.pinimg.com/474x/33/9f/d4/339fd4212cccd9902d9148eaa5d69ef9.jpg",
                    "https://i.pinimg.com/474x/88/66/2d/88662d39010f03ae12ddc6d63dea1184.jpg",
                    "https://i.pinimg.com/474x/9b/8e/a4/9b8ea43f6c3d46a155cb74846a1d24ab.jpg",
                    "https://i.pinimg.com/474x/bb/49/9d/bb499de6de32f0d83a79f9fcd5fe6f0c.jpg",
                    "https://i.pinimg.com/736x/19/65/c6/1965c6557dea0404b79236bdc58ae3e9.jpg",
                ).run { this + this + this }.forEach {
                    Image(
                        modifier = Modifier().width(24.vw).clip(
                            Shape.RoundedRectangle(25.px)
                        ).display(Display.InlineBlock).margin(5).custom(
                            ""${'"'}
                            vertical-align: top;
                        ""${'"'}.trimIndent()
                        ),
                        src = it,
                    )
                }
            }
        }""".trimIndent(),
        showNextBtn = false,
        onPreviousBtnClick = {
            """
                        window.open("/components/Image", "_self");
                    """.trimIndent()
        },
        onNextBtnClick = { "" },
        previousBtnTxt = "Image",
        nextBtnTxt = ""
    )
}