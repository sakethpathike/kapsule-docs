package io.github.sakethpathike.docs.common.ui

import io.github.sakethpathike.docs.common.Colors
import kotlinx.html.*
import sakethh.kapsule.Column
import sakethh.kapsule.Modifier
import sakethh.kapsule.Spacer
import sakethh.kapsule.Text
import sakethh.kapsule.utils.*
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
        horizontalAlignment = HorizontalAlignment.Start,
        modifier = Modifier().margin(top = 10.px, bottom = 30.px).padding(10.px)
            .backgroundColor(Colors.surfaceContainerHighDarkHighContrast).clip(
                overflow = Overflow.Clip,
                shape = Shape.RoundedRectangle(
                    10.px
                )
            )
    ) {
        Text(
            id = codeBlockId,
            text = "<pre>${code.trim()}</pre>",
            color = Colors.onSurfaceDark,
            fontSize = 18.px,
            fontFamily = "JetBrains Mono"
        )
        Spacer(
            modifier = Modifier().fillMaxWidth().margin(top = 15.px, bottom = 15.px).height(2.px)
                .backgroundColor(Colors.outlineDark).opacity(0.5)
                .clip(shape = Shape.RoundedRectangle(cornerRadius = 10.px))
        )
        span(classes = "material-icons") {
            id = "componentsExpandEmoji"
            style = Modifier().custom(
                """
                                font-size: 20px
                            """.trimIndent()
            ).cursor(Cursor.Pointer).color(Colors.onSurfaceDark).buildStyle()

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
  }

                        """.trimIndent()
            +"content_copy"
        }
    }
}