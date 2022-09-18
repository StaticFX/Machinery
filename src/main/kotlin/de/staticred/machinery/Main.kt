package de.staticred.machinery

import de.staticred.machinery.gui.views.MainView
import de.staticred.machinery.io.KeyManager
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

const val MAIN_WINDOW_MIN_HEIGHT = 400.0
const val MAIN_WINDOW_MIN_WIDTH = 600.0

fun main(args: Array<String>) {
    launch<Machinery>()
}

class Machinery: App(MainView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.minWidth = MAIN_WINDOW_MIN_WIDTH
        stage.minHeight = MAIN_WINDOW_MIN_HEIGHT

        stage.addEventHandler(KeyEvent.KEY_PRESSED) {
            KeyManager.keyPressed(it.code)
        }

        stage.addEventHandler(KeyEvent.KEY_RELEASED) {
            KeyManager.keyReleased(it.code)
        }

        de.staticred.machinery.game.Machinery.start()
    }
}