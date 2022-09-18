package de.staticred.machinery.util.menu

class Menu(val title: String, val options: MutableList<Option> = mutableListOf(), private val backOption: Boolean = true) {

    private var currentIndex = 0
    var selectedOption: Option
        private set

    init {
        if (backOption || options.size == 0)
            options += BACK_OPTION

        selectedOption = options[0]
        selectedOption.selected = true
    }

    fun next(): Option {
        currentIndex++

        if (currentIndex > options.size - 1) {
            currentIndex  = 0
        }

        selectedOption = options[currentIndex]

        options.forEach { it.selected = false }
        options[currentIndex].selected = true

        return selectedOption
    }

    fun previous(): Option {
        currentIndex--

        if (currentIndex < 0) {
            currentIndex  = options.size - 1
        }

        selectedOption = options[currentIndex]

        options.forEach { it.selected = false }
        options[currentIndex].selected = true

        return selectedOption
    }

    fun select() {
        selectedOption.execute()
    }

}