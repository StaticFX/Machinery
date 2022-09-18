package de.staticred.machinery.gui.renderer

import de.staticred.machinery.util.menu.Menu
import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import tornadofx.text
import kotlin.math.roundToInt

class MenuRenderer(private val textFlow: TextFlow, private val label: Label): Renderer<Menu> {


    private val maxTextLength = 100

    override fun render(t: Menu) {
        label.text = t.title

        val text = mutableListOf<Text>()
        textFlow.children.clear()

        for (option in t.options) {
            val optionText = Text("> ${option.title}\n")

            if (optionText.text.length > 14) {

                val sb = StringBuilder(optionText.text)
                var index = 14

                while(index < optionText.text.length) {
                    sb.insert(index, "\n  ")
                    index += 14
                }

                optionText.text = sb.toString()
            }

            optionText.fill = if(option.selected) Color.RED else Color.ORANGE
            text.add(optionText)
        }

        val count = text.count { it.text.contains("\n") }
        val index = text.indexOfFirst { it.fill == Color.RED }
        val height = textFlow.height

        val fitValues = (height / 17).roundToInt()

        if (count > fitValues) {
            textFlow.children.addAll(text.slice(index until text.size.coerceAtMost((index + fitValues))))
        } else {
            textFlow.children.addAll(text)
        }
    }
}