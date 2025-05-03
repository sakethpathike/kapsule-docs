package io.github.sakethpathike.docs.common.ui

import docs.common.ui.CommonScaffold
import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.HTML
import kotlinx.html.IframeSandbox
import kotlinx.html.iframe
import kotlinx.html.style
import sakethh.kapsule.*
import sakethh.kapsule.utils.px

fun HTML.TopicUI(
    currentRoute: String,
    topicName: String,
    topicDesc: String,
    topicSignature: String,
    paramsExplanation: String,
    exampleCodeForCurrentTopic: String,
    showPreviousBtn: Boolean = true,
    showNextBtn: Boolean = true,
    onPreviousBtnClick: () -> String,
    onNextBtnClick: () -> String,
    previousBtnTxt: String,
    nextBtnTxt: String
) {
    CommonScaffold(currentRoute = currentRoute) {
        Column(
            modifier = Modifier().fillMaxSize().padding(25.px).custom(
                """
                  flex: 1;
                  overflow-y: auto;
            """.trimIndent()
            )
        ) {
            Text(
                text = topicName,
                color = Colors.Primary,
                fontWeight = "bold",
                fontFamily = "Inter",
                fontSize = 25.px
            )
            Box(modifier = Modifier()) {
                Spacer(modifier = Modifier().height(10.px))
            }
            Text(
                text = topicDesc, color = Colors.OnBackground, fontSize = 18.px, fontFamily = "Inter"
            )
            Text(text = "\nFunction Signature:", color = Colors.onSurfaceDark, fontSize = 18.px, fontFamily = "Inter")
            CustomCodeBlock(code = topicSignature)
            Text(
                text = """
                <b>Parameters</b>:
            """.trimIndent(), color = Colors.onSurfaceDark, fontSize = 18.px, fontFamily = "Inter"
            )
            Text(
                text = paramsExplanation.trimIndent(),
                color = Colors.onSurfaceDark,
                fontSize = 18.px,
                fontFamily = "Inter"
            )

            if (exampleCodeForCurrentTopic.isNotBlank()) {
                Text(
                    text = "Here's how you might use the ${Codeblock(topicName)} function",
                    color = Colors.onSurfaceDark,
                    fontSize = 18.px,
                    fontFamily = "Inter",
                    fontWeight = "bold"
                )

                CustomCodeBlock(code = exampleCodeForCurrentTopic)

                if (topicName !in listOf("Surface", "Box")) {
                    Text(
                        text = "Resulting Web View:",
                        color = Colors.onSurfaceDark,
                        fontSize = 18.px,
                        fontFamily = "Inter",
                    )
                    Box(modifier = Modifier()) {
                        Spacer(modifier = Modifier().height(10.px))
                    }
                    iframe(sandbox = IframeSandbox.allowScripts) {
                        this.style = Modifier().border(radius = 10.px, color = Colors.surfaceDark, width = 4.px)
                            .backgroundColor("white").buildStyle()
                        this.src = "/static/examples/${topicName}.html"
                    }
                    Box(modifier = Modifier()) {
                        Spacer(modifier = Modifier().height(25.px))
                    }
                }
            }
            BottomPagerControls(
                showPreviousBtn = showPreviousBtn,
                showNextBtn = showNextBtn,
                onPreviousBtnClick = onPreviousBtnClick,
                onNextBtnClick = onNextBtnClick,
                previousBtnTxt = previousBtnTxt,
                nextBtnTxt = nextBtnTxt
            )
        }
    }
}