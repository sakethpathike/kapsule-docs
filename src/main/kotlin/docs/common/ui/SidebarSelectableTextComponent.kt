package docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.DIV
import sakethh.kapsule.Modifier
import sakethh.kapsule.Row
import sakethh.kapsule.Spacer
import sakethh.kapsule.Text
import sakethh.kapsule.utils.Cursor
import sakethh.kapsule.utils.HorizontalAlignment
import sakethh.kapsule.utils.Shape
import sakethh.kapsule.utils.px

fun DIV.SidebarSelectableTextComponent(selected: Boolean, text: String, onThisElement: DIV.() -> Unit = {}) {
    Row(
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier().cursor(Cursor.Pointer)
            .then(if (selected) Modifier().backgroundColor(Colors.NavbarUnSelectedContainerColor) else Modifier())
            .clip(Shape.RoundedRectangle(right = 15f, cornerRadius = 10.px)).custom(
                """
                user-select: none;
            """.trimIndent()
            ),
        onThisElement = {
            onThisElement()
        }) {
        if (selected) {
            Spacer(
                modifier = Modifier().margin(end = 15.px).height(25.px).width(4.px)
                    .backgroundColor(Colors.NavbarUnSelectedTextColor)
            )
        } else {
            Text(
                text = Typography.bullet.toString(),
                fontSize = 16.px,
                fontWeight = "regular",
                fontFamily = "Inter",
                color = Colors.NavbarSelectedTextColor,
                modifier = Modifier().margin(end = 5.px),
            )
        }
        Text(
            modifier = Modifier().margin(end = 15.px),
            text = text,
            fontSize = 16.px,
            fontWeight = if (selected) "bold" else "regular",
            fontFamily = "Inter",
            color = Colors.NavbarSelectedTextColor
        )
    }
}