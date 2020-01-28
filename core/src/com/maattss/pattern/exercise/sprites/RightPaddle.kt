package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.pattern.exercise.PatternExercise


class RightPaddle(x: Int, y: Int) {
    val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    val texture: Texture = Texture("pong/paddle.png")
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
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) position.y += 20f
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) position.y -= 20f
    }
}