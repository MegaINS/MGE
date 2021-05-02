package ru.megains.mge.render.model

import ru.megains.mge.render.MObject
import ru.megains.mge.render.mesh.{Mesh}
import ru.megains.mge.render.shader.Shader

class Model extends MObject{

    var mesh:Mesh = _
    var active:Boolean = true

    def this(meshIn:Mesh){
        this()
        mesh = meshIn
    }

    override def render(shader:Shader): Unit = {
        if (mesh != null && active) {
            shader.setUniform("modelMatrix", buildMatrix())
            mesh.render(shader)
        }
    }

    override def update(): Unit = {

    }
}
