package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.pattern.exercise.PatternExercise


class LeftPaddle(x: Int, y: Int) {
    val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    val texture: Texture = Texture("pong/paddle.png")
    private val speed: Int = 20
    val bounds: Rectangle = Rectangle(position.x, position.y,
            texture.width.toFloat(), texture.height.toFloat())

    fun update() {
        bounds.setPosition(position.x, position.y)
        if (position.y < 0) {
            position.y = 0f
        }
        if (position.y > PatternExercise.HEIGHT - texture.height) {
            position.y = PatternExercise.HEIGHT - texture.height.toFloat()
        }
        if (Gdx.input.isTouched) { // Using mouse as the controller for left player
            val mousePos = PatternExercise.HEIGHT - Gdx.input.y
            if (mousePos - speed > position.y) {
                position.y += speed.toFloat()
            } else if (mousePos + speed < position.y) {
                position.y -= speed.toFloat()
            }
        }
    }
}