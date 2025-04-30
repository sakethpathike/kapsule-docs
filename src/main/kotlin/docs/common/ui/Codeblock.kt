package io.github.sakethpathike.docs.common.ui

import kotlinx.html.DIV
import sakethh.kapsule.Modifier
import sakethh.kapsule.Row
import sakethh.kapsule.Text
import sakethh.kapsule.utils.HorizontalAlignment
import sakethh.kapsule.utils.VerticalAlignment
import sakethh.kapsule.utils.px

fun Codeblock(code: String): String {
    return """
        <code style="background:#f4f4f4; padding:2px 4px; border-radius:4px;color: #1b1b1b;">$code</code>
    """.trimIndent()
}

fun DIV.CustomCodeBlock(code: String) {
    Row(
        verticalAlignment = VerticalAlignment.SpaceBetween,
        horizontalAlignment = HorizontalAlignment.Center,
        modifier = Modifier().margin(top = 10.px, bottom = 30.px).padding(10.px).backgroundColor("#1b1b1b")
            .border(5, color = "#ffffff")
    ) {
        Text(text = code, color = "#ffffff", fontSize = 18.px, fontFamily = "Poppins")
    }
}