package io.github.sakethpathike.docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.DIV
import sakethh.kapsule.Modifier
import sakethh.kapsule.Row
import sakethh.kapsule.Text
import sakethh.kapsule.utils.*

fun Codeblock(code: String): String {
    return """
        <code style="background:${Colors.primaryDark}; padding:2px 4px; font-family: 'JetBrains Mono'; border-radius:4px;color: ${Colors.onPrimaryDark};">$code</code>
    """.trimIndent()
}

fun DIV.CustomCodeBlock(code: String) {
    Row(
        verticalAlignment = VerticalAlignment.SpaceBetween,
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier().margin(top = 10.px, bottom = 30.px).padding(10.px)
            .backgroundColor(Colors.surfaceContainerHighDarkHighContrast).clip(
                overflow = Overflow.Scroll,
                shape = Shape.RoundedRectangle(
                    15.px
                )
            )
    ) {
        Text(text = code, color = Colors.onSurfaceDark, fontSize = 18.px, fontFamily = "JetBrains Mono")
    }
}