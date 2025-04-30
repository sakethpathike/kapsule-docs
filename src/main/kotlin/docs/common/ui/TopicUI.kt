package io.github.sakethpathike.docs.common.ui

import docs.common.ui.CommonScaffold
import kotlinx.html.HTML
import sakethh.kapsule.Column
import sakethh.kapsule.Modifier
import sakethh.kapsule.Text
import sakethh.kapsule.utils.px

fun HTML.TopicUI(
    currentRoute: String,
    topicName: String,
    topicDesc: String,
    topicSignature: String,
    paramsExplanation: String,
    exampleCodeForCurrentTopic: String,
    showPreviousBtn: Boolean,
    showNextBtn: Boolean,
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
            Text(text = topicName, color = "#ffffff", fontWeight = "bold", fontFamily = "Poppins", fontSize = 25.px)
            Text(
                text = topicDesc, color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins"
            )
            Text(text = "\nFunction Signature:", color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins")
            CustomCodeBlock(code = topicSignature)
            Text(
                text = """
                <b>Parameters</b>:

            $paramsExplanation
            """.trimIndent(), color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins"
            )

            Text(
                text = "\nHere's how you might use the ${Codeblock(topicName)} function",
                color = "#ffffff",
                fontSize = 18.px,
                fontFamily = "Poppins",
                fontWeight = "bold"
            )
            CustomCodeBlock(code = exampleCodeForCurrentTopic)
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