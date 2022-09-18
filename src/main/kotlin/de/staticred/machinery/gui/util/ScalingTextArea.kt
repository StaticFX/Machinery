package de.staticred.machinery.gui.util

import de.staticred.machinery.MAIN_WINDOW_MIN_HEIGHT
import javafx.scene.text.TextFlow

class ScalingTextArea(val textArea: TextFlow) {

    private var ratio = 1.0
    private var fontSize = 12.0

    fun setScalingHeight(new: Double) {
        ratio = new / MAIN_WINDOW_MIN_HEIGHT
        val finalFontSize = fontSize * ratio * 2
        textArea.style = "-fx-font-size: $finalFontSize;"
    }
}