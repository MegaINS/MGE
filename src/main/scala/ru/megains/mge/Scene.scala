package ru.megains.mge

trait Scene {

    def runTickKeyboard(key: Int, action: Int, mods: Int)

    def init():Unit

    def render():Unit

    def update():Unit

    def destroy():Unit

    def runTickMouse(button: Int, buttonState: Boolean):Unit

}
