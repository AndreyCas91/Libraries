package com.gb.libraries

class MainPresenter(private val view: MainView) {

    private val model = CounterModel()

    fun counterClick(id: ButtonSelection) {
        when (id) {
            ButtonSelection.FIRST -> {
                val nextValve = model.next(0)
                view.setButtonText(0, nextValve.toString())
            }
            ButtonSelection.SECOND -> {
                val nextValve = model.next(1)
                view.setButtonText(1, nextValve.toString())
            }
            ButtonSelection.THIRD -> {
                val nextValve = model.next(2)
                view.setButtonText(2, nextValve.toString())
            }
        }

    }

    enum class ButtonSelection {
        FIRST,
        SECOND,
        THIRD
    }
}