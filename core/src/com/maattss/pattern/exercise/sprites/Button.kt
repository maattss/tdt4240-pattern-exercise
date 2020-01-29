package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class Button(x: Int, y: Int, texturePath: String) {
    val texture: Texture = Texture(texturePath)
    private val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    val bounds: Rectangle = Rectangle(position.x, position.y,
            texture.width.toFloat(), texture.height.toFloat())

    val x: Float
        get() = position.x

    val y: Float
        get() = position.y + texture.height

    fun dispose() {
        texture.dispose()
    }

}