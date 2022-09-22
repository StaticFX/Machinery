package de.staticred.machinery.gui.renderer

import de.staticred.machinery.util.box.Box
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextFlow
import tornadofx.add
import kotlin.math.ceil
import kotlin.math.roundToInt

class SimpleBoxRenderer(private val textFlow: TextFlow): Renderer<Box> {

    override fun render(t: Box) {
        textFlow.children.clear()
        val test = Text("""
        ╭───╮
        │   ╳   │
        ╰───╯
        """.trimIndent())

        test.fill = Color.ORANGE

        textFlow.children.add(test)
    }

}