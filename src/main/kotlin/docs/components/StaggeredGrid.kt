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
                    "https://i.ytimg.com/vi/66OFYWBrg3o/maxresdefault.jpg",
                    "https://i.pinimg.com/736x/51/83/16/5183165c9a10c4c3c65f802b633d3cbe.jpg",
                    "https://store-images.s-microsoft.com/image/apps.34218.69361434237560300.08369373-2b5b-4056-89d1-c943a5bfd11b.e789f972-ce59-4e92-b7d5-5064c8121aa0",
                    "https://i.pinimg.com/474x/91/80/53/9180537435f5a767bc65966eb6802768.jpg",
                    "https://i.pinimg.com/474x/33/9f/d4/339fd4212cccd9902d9148eaa5d69ef9.jpg",
                    listOf(
                        "https://pbs.twimg.com/media/FUPM2TrWYAAQsXm?format=jpg",
                        "https://pbs.twimg.com/media/FLJx9epWYAADM0O?format=jpg",
                        "https://pbs.twimg.com/media/FAdLIY8WUAEgLRM?format=jpg",
                        "https://pbs.twimg.com/media/ETUI-RDWsAE2UYR?format=jpg",
                        "https://pbs.twimg.com/media/ET9J7vTWsAYVtvG?format=jpg",
                        "https://pbs.twimg.com/media/GRo2CKkWUAEsdEl?format=jpg",
                        "https://pbs.twimg.com/media/FezZxQYWQAQ4K3f?format=jpg",
                        "https://pbs.twimg.com/media/FezaHWkX0AIWvvU?format=jpg",
                        "https://i.redd.it/qoa6gk4ii8571.jpg",
                        "https://i.redd.it/8psapajhi8571.jpg"
                    ).random(),
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