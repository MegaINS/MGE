package ru.megains.mge


trait Game {

    var window:Window

    def runTickMouse(button: Int, buttonState: Boolean):Unit

    def runTickKeyboard(key: Int, action: Int, mods: Int):Unit

    def setScene(scene: Scene):Unit
}
