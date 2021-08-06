package ru.megains.mge.render.font


import java.io.IOException

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL11._
import org.lwjgl.stb.{STBTTBakedChar, STBTruetype}
import ru.megains.mge.render.texture.{TTexture, TextureData}
import ru.megains.mge.{File => FileM}


class Font(textureData: TextureData) extends TTexture(textureData) {


    val BITMAP_W = 1024
    val BITMAP_H = 1024
    val cdata: STBTTBakedChar.Buffer = STBTTBakedChar.malloc(2000)

    def this(name: String)= {
        this(new TextureData())
        height = 24
        val texID = getGlTextureId
        try {
            val ttf = FileM.ioResourceToByteBuffer(s"fonts/$name.ttf", 160 * 1024)
            val bitmap = BufferUtils.createByteBuffer(BITMAP_W * BITMAP_H)
            STBTruetype.stbtt_BakeFontBitmap(ttf, 24, bitmap, BITMAP_W, BITMAP_H, 0, cdata)

            val img = BufferUtils.createByteBuffer(BITMAP_W * BITMAP_H*4)

            for (i <- 0 until BITMAP_W * BITMAP_H) {
                val a = bitmap.get(i)
                img.put(i*4+0,255.toByte)
                img.put(i*4+1,255.toByte)
                img.put(i*4+2,255.toByte)
                img.put(i*4+3, a)
            }

            glBindTexture(GL_TEXTURE_2D, texID)
            glPixelStorei(GL_UNPACK_ALIGNMENT, 1)
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, BITMAP_W, BITMAP_H, 0, GL_RGBA, GL_UNSIGNED_BYTE, img)
           // glGenerateMipmap(GL_TEXTURE_2D)
        } catch {
            case e: IOException =>
                throw new RuntimeException(e)
        }

    }


}
