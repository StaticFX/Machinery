package de.staticred.machinery.io

import javafx.event.EventType
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

object KeyManager {

    private val pressedKeys = mutableSetOf<KeyCode>()
    private val keyListeners = mutableListOf<(key: KeyCode, keyAction: EventType<KeyEvent>) -> Unit>()

    fun keyPressed(key: KeyCode) {
        pressedKeys += key

        keyListeners.forEach { it(key, KeyEvent.KEY_PRESSED) }
    }

    fun keyReleased(key: KeyCode) {
        pressedKeys -= key

        keyListeners.forEach { it(key, KeyEvent.KEY_RELEASED) }
    }

    fun addKeyListener(listener: (key: KeyCode, keyAction: EventType<KeyEvent>) -> Unit) {
        keyListeners += listener
    }

    fun isPressed(key: KeyCode): Boolean = pressedKeys.contains(key)

    fun isShifted(key: KeyCode): Boolean = pressedKeys.contains(KeyCode.SHIFT) && pressedKeys.contains(key)

    fun isControlled(key: KeyCode): Boolean = pressedKeys.contains(KeyCode.CONTROL) && pressedKeys.contains(key)

}