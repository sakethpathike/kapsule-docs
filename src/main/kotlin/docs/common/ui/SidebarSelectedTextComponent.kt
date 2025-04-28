package docs.common.ui

import kotlinx.html.DIV
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

fun DIV.SidebarSelectedTextComponent(selected: Boolean, text: String, onThisElement: DIV.() -> Unit = {}) {
    Row(
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier().cursor(Cursor.Pointer)
            .then(if (selected) Modifier().backgroundColor("#292929") else Modifier())
            .clip(Shape.RoundedRectangle(right = 15f, cornerRadius = 10.px)).custom(
                """
                user-select: none;
            """.trimIndent()
            ),
        onThisElement = {
            onThisElement()
        }) {
        if (selected) {
            Spacer(modifier = Modifier().margin(end = 15.px).height(25.px).width(4.px).backgroundColor("#ffffff"))
        } else {
            Text(
                text = Typography.bullet.toString(),
                fontSize = 16.px,
                fontWeight = "25",
                fontFamily = "Poppins",
                color = "white",
                modifier = Modifier().margin(end = 5.px),
            )
        }
        Text(
            modifier = Modifier().margin(end = 15.px),
            text = text,
            fontSize = 16.px,
            fontWeight = "25",
            fontFamily = "Poppins",
            color = "white"
        )
    }
}