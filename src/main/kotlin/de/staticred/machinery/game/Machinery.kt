package de.staticred.machinery.game

import de.staticred.machinery.gui.renderer.RenderManager
import de.staticred.machinery.util.menu.MenuManager
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit


object Machinery {

    private val scheduler = ScheduledThreadPoolExecutor(1)

    fun start() {
        scheduler.scheduleAtFixedRate({ tick() }, 0, 1, TimeUnit.MILLISECONDS)
    }


    private fun tick() {
        RenderManager.render()
        MenuManager.handleCurrentKeyStrokes()



    }
}