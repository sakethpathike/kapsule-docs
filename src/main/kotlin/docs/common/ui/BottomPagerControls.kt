package io.github.sakethpathike.docs.common.ui

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
        modifier = Modifier().cursor(Cursor.Pointer).clip(shape = Shape.RoundedRectangle(12.px))
            .backgroundColor("#d6d6d6").display(Display.InlineBlock), onClick = onClick
    ) {
        Column(modifier = Modifier().padding(5.px)) {
            Text(
                text = label, fontFamily = "Poppins", color = "black", fontSize = 10.px, fontWeight = "0"
            )

            Text(
                text = text, fontFamily = "Poppins", color = "black", fontSize = 15.px, fontWeight = "bold"
            )
        }
    }
}