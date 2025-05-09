package docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.DIV
import sakethh.kapsule.*
import sakethh.kapsule.utils.*

fun DIV.SidebarSelectableTextComponent(
    selected: Boolean,
    text: String,
    applyInitialPadding: Boolean = true,
    onThisElement: DIV.() -> Unit = {}
) {
    Row(
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier.cursor(Cursor.Pointer).padding(if (applyInitialPadding) 5.px else 0.px)
            .then(if (selected) Modifier.backgroundColor(Colors.NavbarUnSelectedContainerColor) else Modifier)
            .clip(Shape.RoundedRectangle(cornerRadius = 5.px)).custom(
                """
                user-select: none;
            """.trimIndent()
            ),
        onThisElement = {
            onThisElement()
        }) {
        if (selected) {
            Spacer(
                modifier = Modifier.margin(end = 5.px).height(25.px).clip(Shape.RoundedRectangle(cornerRadius = 5.px))
                    .width(5.px).backgroundColor(Colors.primaryDark)
            )
        }
        Text(
            modifier = Modifier.margin(end = 15.px),
            text = text,
            fontSize = 16.px,
            fontWeight = if (selected) FontWeight.Predefined.Medium else FontWeight.Predefined.Normal,
            fontFamily = "Inter",
            color = Colors.NavbarSelectedTextColor
        )
    }
}