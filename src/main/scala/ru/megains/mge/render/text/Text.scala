package ru.megains.mge.render.text


import java.awt.Color

import ru.megains.mge.render.font.{FontRender, Fonts}
import ru.megains.mge.render.model.Model
import ru.megains.mge.render.shader.Shader



class Text() extends Model {


    private var _text: String = ""
    private var _textStyle: TextStyle = TextStyle.default
   // scale = 0.9f
    def this(text: String, textStyle: TextStyle = TextStyle.default)= {
        this()
        this.text = text
        this.textStyle = textStyle
    }

    def text: String = _text

    def text_=(text: String): Unit = {
        _text = text
        mesh = FontRender.createStringGui(text, Color.BLACK, Fonts.timesNewRomanR)

    }

    override def render(shader: Shader): Unit = super.render(shader)

    def textStyle: TextStyle = _textStyle

    def textStyle_=(textStyle: TextStyle): Unit = {
        _textStyle = textStyle
    }


}
