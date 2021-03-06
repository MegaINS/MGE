package ru.megains.mge.render
import ru.megains.mge.render.mesh.MeshMaker
import ru.megains.mge.render.model.Model
import ru.megains.mge.render.texture.TTexture

class MSprite() extends Model {

   var  _texture: TTexture = _


    def this(texture: TTexture,x:Int,y:Int)={
        this()
        _texture = texture



        val maxX = x //texture.width
        val maxY = y //texture.height
        val minX = 0
        val minY = 0
        val zZero = 0.0f


        var minU: Float = 0
        var maxU: Float = 0
        var minV: Float = 0
        var maxV: Float = 0


        val mm = MeshMaker.startMakeTriangles()
        mm.setTexture(texture)

        minU = texture.minU
        maxU = texture.maxU
        minV = texture.minV
        maxV = texture.maxV

        mm.setCurrentIndex()
        mm.addVertexWithUV(minX, minY, zZero, minU,minV )
        mm.addVertexWithUV(minX, maxY, zZero, minU, maxV)
        mm.addVertexWithUV(maxX, maxY, zZero, maxU, maxV)
        mm.addVertexWithUV(maxX, minY, zZero, maxU, minV)
        mm.addIndex(0, 1, 2)
        mm.addIndex(0, 2, 3)

        mesh = mm.make()
    }

    override def update(): Unit = {
    }
}
