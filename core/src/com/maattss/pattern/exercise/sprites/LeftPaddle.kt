package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.Gdx
import com.maattss.pattern.exercise.PatternExercise

class LeftPaddle(x: Int, y: Int) : Paddle(x, y) {
    private val speed: Int = 20

    override fun update() {
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