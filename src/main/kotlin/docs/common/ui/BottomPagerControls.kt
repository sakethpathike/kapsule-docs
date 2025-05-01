package io.github.sakethpathike.docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.DIV
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

fun DIV.BottomPagerControls(
    showPreviousBtn: Boolean,
    showNextBtn: Boolean,
    onPreviousBtnClick: () -> String,
    onNextBtnClick: () -> String,
    previousBtnTxt: String,
    nextBtnTxt: String
) {
    Row(
        verticalAlignment = VerticalAlignment.SpaceBetween,
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier().fillMaxWidth().margin(bottom = 150.px)
    ) {
        if (showPreviousBtn) {
            BottomButton(text = previousBtnTxt, label = "Previous page", onClick = onPreviousBtnClick)
        } else {
            Spacer(modifier = Modifier().display(Display.InlineBlock))
        }

        if (showNextBtn) {
            BottomButton(text = nextBtnTxt, onClick = onNextBtnClick, label = "Next page")
        } else {
            Spacer(modifier = Modifier().display(Display.InlineBlock))
        }
    }
}

private fun DIV.BottomButton(label: String, text: String, onClick: () -> String) {
    Button(
        modifier = Modifier().cursor(Cursor.Pointer).border(radius = 15, color = Colors.primaryContainerDark)
            .backgroundColor(Colors.ButtonContentColor).display(Display.InlineBlock), onClick = onClick
    ) {
        Column(modifier = Modifier().padding(5.px)) {
            Text(
                text = label,
                fontFamily = "Inter",
                color = Colors.ButtonContainerColor,
                fontSize = 12.px,
            )

            Text(
                text = text,
                fontFamily = "Inter",
                color = Colors.ButtonContainerColor,
                fontSize = 18.px,
                fontWeight = "bold"
            )
        }
    }
}