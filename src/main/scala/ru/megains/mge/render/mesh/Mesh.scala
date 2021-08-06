package ru.megains.mge.render.mesh



import org.lwjgl.opengl.GL11.{GL_UNSIGNED_INT, glDrawElements}
import org.lwjgl.opengl.GL15.{GL_ARRAY_BUFFER, glBindBuffer, glDeleteBuffers}
import org.lwjgl.opengl.GL20.glDisableVertexAttribArray
import org.lwjgl.opengl.GL30.{glBindVertexArray, glDeleteVertexArrays}
import ru.megains.mge.render.shader.Shader
import ru.megains.mge.render.texture.{TTexture, TextureManager}

class Mesh(mode: Int, vertexCount: Int, vaoId:Int, vboIdList:List[Int], val texture:TTexture, val useColor:Boolean) {


    def useTexture: Boolean = texture!= null

    def render(shader: Shader):Unit= {

        shader.setUniform("dataTC",useTexture,useColor)
        if(useTexture){
            TextureManager.bindTexture(texture)
        }
        glBindVertexArray(vaoId)
        glDrawElements(mode, vertexCount, GL_UNSIGNED_INT, 0)
        glBindVertexArray(0)

    }

    def cleanUp():Unit= {
        for(id <- 0 to vboIdList.size ){
            glDisableVertexAttribArray(id)
        }
        glBindBuffer(GL_ARRAY_BUFFER, 0)
        for (id <- vboIdList) {
            glDeleteBuffers(id)
        }
        glBindVertexArray(0)

        glDeleteVertexArrays(vaoId)
    }
}

