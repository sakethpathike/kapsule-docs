package io.github.sakethpathike.docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.DIV
import sakethh.kapsule.*
import sakethh.kapsule.utils.Cursor
import sakethh.kapsule.utils.Shape
import sakethh.kapsule.utils.em
import sakethh.kapsule.utils.px
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun Codeblock(code: String): String {
    return """
        <code style="background:${Colors.primaryDark}; padding:2px 4px; font-family: 'JetBrains Mono'; border-radius:4px;color: ${Colors.onPrimaryDark};">$code</code>
    """.trimIndent()
}

@OptIn(ExperimentalUuidApi::class)
fun DIV.CustomCodeBlock(code: String, codeBlockId: String = Uuid.random().toString()) {
    Column(
        modifier = Modifier().padding(1.em).borderRadius(10.px)
            .backgroundColor(Colors.surfaceContainerHighDarkHighContrast)
    ) {
        Text(
            id = codeBlockId,
            text = "<pre>${code.trim()}</pre>",
            color = Colors.onSurfaceDark,
            fontSize = 18.px,
            fontFamily = "JetBrains Mono",
            modifier = Modifier().custom(
                """
                    overflow-x: auto;
                    overflow-y: hidden; 
                    white-space: pre; 
            """.trimIndent()
            )
        )
        Spacer(
            modifier = Modifier().fillMaxWidth().margin(top = 15.px, bottom = 15.px).height(2.px)
                .backgroundColor(Colors.outlineDark).opacity(0.5)
                .clip(shape = Shape.RoundedRectangle(cornerRadius = 10.px))
        )
        MaterialIcon(
            iconCode = "content_copy", modifier = Modifier().custom(
                """
                                font-size: 20px
                            """.trimIndent()
            ).cursor(Cursor.Pointer).color(Colors.onSurfaceDark),
            onClick = """
  const div = document.getElementById('${codeBlockId}');
  const textToCopy = div.textContent;

  if (navigator.clipboard && navigator.clipboard.writeText) {
    navigator.clipboard.writeText(textToCopy)
      .then(() => console.log('Copied to clipboard!'))
      .catch(err => alert('Copy failed: ' + err));
  } else {
    const textarea = document.createElement('textarea');
    textarea.value = textToCopy;
    textarea.style.position = 'absolute';
    textarea.style.left = '-9999px';
    document.body.appendChild(textarea);
    textarea.select();
    try {
      document.execCommand('copy');
      console.log('Copied via execCommand');
    } catch (err) {
      alert('Fallback copy failed: ' + err);
    }
    document.body.removeChild(textarea);
  }""".trimIndent()
        )
    }
}