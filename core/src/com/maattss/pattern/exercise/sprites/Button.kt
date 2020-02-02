package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class Button(x: Int, y: Int, texturePath: String) : Sprite() {
    override val texture: Texture = Texture(texturePath)
    override val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    override val bounds: Rectangle = Rectangle(position.x, position.y - texture.height.toFloat(),
            texture.width.toFloat(), position.y)
    val x: Float
        get() = position.x

    val y: Float
        get() = position.y
    fun dispose() {
        texture.dispose()
    }
}