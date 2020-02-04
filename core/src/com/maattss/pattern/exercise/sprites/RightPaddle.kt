package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.maattss.pattern.exercise.PatternExercise

class RightPaddle(x: Int, y: Int) : Paddle(x, y) {

    override fun update() {
        val boundary = (PatternExercise.HEIGHT - texture.height).toFloat()
        bounds.setPosition(position.x, position.y)
        if (position.y < 0) {
            position.y = 0f
        }
        if (position.y > boundary) {
            position.y = boundary
        }

        // Using UP and DOWN arrow keys as the controller for left player
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && position.y < boundary) position.y += speed
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y > 0) position.y -= speed
    }
}