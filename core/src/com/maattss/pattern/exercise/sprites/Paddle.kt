package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

abstract class Paddle(x: Int, y: Int) : Sprite() {
    override val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    override val texture: Texture = Texture("pong/paddle.png")
    override val bounds: Rectangle = Rectangle(position.x, position.y,
            texture.width.toFloat(), texture.height.toFloat())
    val speed: Int = 20
    abstract fun update()
}