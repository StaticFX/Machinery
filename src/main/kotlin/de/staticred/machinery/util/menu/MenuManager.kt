package de.staticred.machinery.util.menu

import de.staticred.machinery.io.KeyManager
import javafx.scene.input.KeyCode
import kotlin.system.exitProcess


val MAIN_MENU = Menu("Main-Menu"
    , mutableListOf(Option("Play") {_,opt -> println(opt.title)},
        Option("Load") {_,opt -> println(opt.title)},
        Option("Exit") {_,_ -> exitProcess(0) })
    , backOption = false)

object MenuManager {

    private var holdsDown = false
    private var holdDownBegin = 0L

    var currentMenu = MAIN_MENU
        private set

    var previousMenus = MAIN_MENU
        private set

    fun setMenu(menu: Menu) {
        previousMenus = currentMenu
        currentMenu = menu
    }

    fun handleCurrentKeyStrokes() {

        if (holdsDown) {
            if (System.currentTimeMillis() - holdDownBegin < 100) {
                return
            }
        }

        if (KeyManager.isPressed(KeyCode.UP) || KeyManager.isPressed(KeyCode.DOWN) || KeyManager.isPressed(KeyCode.ENTER)) {
            holdsDown = true
            holdDownBegin = System.currentTimeMillis()

            if (KeyManager.isPressed(KeyCode.UP)) {
                currentMenu.previous()
            } else if (KeyManager.isPressed(KeyCode.DOWN)) {
                currentMenu.next()
            } else {
                currentMenu.select()
            }
        } else {
            holdsDown = false
        }
    }
}