package ru.megains.mge.render.texture


import org.lwjgl.opengl.GL11

import scala.collection.mutable


class TextureManager {

    val mapTTexture:mutable.HashMap[String,TTexture] = new mutable.HashMap[String,TTexture]
    var currentTexture: TTexture = _
    lazy val missingTexture = new Texture("textures/missing.png")
    TextureManager.textureManager = this



    def bindTexture(texture: TTexture) : Unit = {

        if (texture != currentTexture) {
            currentTexture = texture
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, currentTexture.getGlTextureId)
        }
    }

    def unbindTexture(): Unit =  {
        currentTexture = null
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0)
    }


    def loadTexture(name: String, aTexture: TTexture): Boolean = {

        //if (aTexture.loadTexture()) {
            mapTTexture += name -> aTexture
            true
       // } else {
       //     println("Error load texture " + name)
      //      mapTTexture += name -> missingTexture
       //     false
      //  }

    }



    def getTexture(name: String): TTexture = {
        mapTTexture.getOrElse(name, default = {
            val aTexture = new Texture(name)
            loadTexture(name, aTexture)
            aTexture
        })
    }

}
object TextureManager {

    var textureManager:TextureManager = _

    def bindTexture(texture: TTexture): Unit =  {
        textureManager.bindTexture(texture)
    }

    def unbindTexture(): Unit =  {
        textureManager.unbindTexture()
    }

}

