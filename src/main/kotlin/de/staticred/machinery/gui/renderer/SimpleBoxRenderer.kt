package de.staticred.machinery.gui.renderer

import de.staticred.machinery.util.box.Box
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextFlow
import tornadofx.add

class SimpleBoxRenderer(private val textFlow: TextFlow): Renderer<Box> {

    override fun render(t: Box) {
        textFlow.children.clear()

        if (t.width > 46) error("Box cant be wider than 46 units")

        val widthText = Text()
        widthText.fill = Color.WHITE

        widthText.text += "╔"
        for (i in 0 until t.width) {
            widthText.text += ("═")
        }


        widthText.text += "╗\n"
        textFlow.children.add(widthText)

        for (i in 0 until t.height / 2) {
            val heightText = Text().apply { fill = Color.WHITE }
            heightText.text += "║"

            textFlow.children.add(heightText)



            val filler = Text()
            for (j in 0 until t.width) {
                filler.text += "═"
            }
            textFlow.children.add(filler)
            val heightTextSec = Text().apply { fill = Color.WHITE }
            heightTextSec.text += "║\n"
            textFlow.children.add(heightTextSec)
        }

        val widthTextBottom = Text()
        widthTextBottom.fill = Color.WHITE

        widthTextBottom.text += "╚"
        for (i in 0 until t.width) {
            widthTextBottom.text += "═"
        }
        widthTextBottom.text += "╝"
        textFlow.children.add(widthTextBottom)


    }

    private fun getPixelWidthForFiller(fillerWidth: Int): Double {
        return getPixelWidthOf("═".repeat(fillerWidth))
    }

    private fun getPixelWidthOf(string: String): Double {
        val text = Text(string)
        return text.layoutBounds.width
    }

    private fun getPixelHeightOf(string: String): Double {
        val text = Text(string)
        return text.layoutBounds.height
    }

}