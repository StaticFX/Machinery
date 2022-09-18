package de.staticred.machinery.util.menu

import de.staticred.machinery.io.KeyManager
import javafx.scene.input.KeyCode
import kotlin.system.exitProcess


val MAIN_MENU = Menu("Main-Menu"
    , mutableListOf(Option("Play") {_,opt -> println(opt.title)},
        Option("Load") {_,opt -> println(opt.title)},
        Option("Back1") {_,_ -> exitProcess(0) },
        Option("Back2") {_,_ -> exitProcess(0) },
        Option("Back3") {_,_ -> exitProcess(0) },
        Option("Back4") {_,_ -> exitProcess(0) },
        Option("Back5") {_,_ -> exitProcess(0) },
        Option("Back6") {_,_ -> exitProcess(0) },
        Option("Back7") {_,_ -> exitProcess(0) },
        Option("Back8") {_,_ -> exitProcess(0) },
        Option("Back9") {_,_ -> exitProcess(0) },
        Option("Back10") {_,_ -> exitProcess(0) },
        Option("Back11") {_,_ -> exitProcess(0) },
        Option("Back12") {_,_ -> exitProcess(0) },
        Option("Back13") {_,_ -> exitProcess(0) },
        Option("Back14") {_,_ -> exitProcess(0) },
        Option("Back15") {_,_ -> exitProcess(0) },
        Option("Back16") {_,_ -> exitProcess(0) },
        Option("Back17") {_,_ -> exitProcess(0) })
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