package de.staticred.machinery.util.menu

val BACK_OPTION = Option("Back") { prevMenu, _ ->  MenuManager.setMenu(prevMenu) }

class Option(val title: String, private val execute: (prevMenu: Menu, option: Option) -> Unit) {

    var selected = false

    fun execute() {
        execute(MenuManager.previousMenus, MenuManager.currentMenu.selectedOption)
    }

}