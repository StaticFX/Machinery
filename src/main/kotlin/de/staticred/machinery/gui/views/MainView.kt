package de.staticred.machinery.gui.views

import de.staticred.machinery.gui.util.ScalingTextArea
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextFlow
import tornadofx.View

class MainView: View("Machinery") {

    override val root : Pane by fxml("/machinery.fxml")

    private val _textAreaMain: TextFlow by fxid("ta_main")
    private val _textAreaMenu: TextFlow by fxid("ta_menu")

    val menuLabel: Label by fxid("label_menu")

    val textAreaMain: ScalingTextArea = ScalingTextArea(_textAreaMain)
    val textAreaMenu: ScalingTextArea = ScalingTextArea(_textAreaMenu)

    init {
        textAreaMain.textArea.textAlignment = TextAlignment.CENTER
        textAreaMenu.textArea.textAlignment = TextAlignment.JUSTIFY

        textAreaMain.textArea.heightProperty().addListener { _,_,new -> run {
            textAreaMain.setScalingHeight(new.toDouble())
        } }
    }
}