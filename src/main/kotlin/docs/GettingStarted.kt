package io.github.sakethpathike.docs

import docs.common.ui.CommonScaffold
import kotlinx.html.HTML
import sakethh.kapsule.Text

fun HTML.GettingStarted(currentRoute: String) {
    CommonScaffold(currentRoute = currentRoute) {
        Text(text = "Getting Started")
    }
}