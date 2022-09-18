package de.staticred.machinery.gui.renderer

import de.staticred.machinery.gui.views.MainView
import de.staticred.machinery.util.menu.MenuManager
import javafx.application.Platform
import tornadofx.*

object RenderManager {

    private val mainView = find(MainView::class)

    private val menuRenderer = MenuRenderer(mainView.textAreaMenu.textArea, mainView.menuLabel)

    fun render() {
        Platform.runLater {
            menuRenderer.render(MenuManager.currentMenu)
        }
    }
}