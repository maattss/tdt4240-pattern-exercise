package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.states.PongState


object Ball {
    val texture: Texture = Texture("pong/ball.png")
    val position: Vector2 = Vector2((PatternExercise.WIDTH / 2).toFloat(),
            (PatternExercise.HEIGHT / 2).toFloat())
    private var up: Boolean = true
    private var right: Boolean = true
    private val speed: Int = 400
    val bounds: Rectangle = Rectangle(position.x, position.y, 20f, 20f)

    fun update(dt: Float, state: PongState, pl: LeftPaddle, pr: RightPaddle) {
        bounds.setPosition(position.x, position.y)
        if (bounds.overlaps(pl.bounds) || bounds.overlaps(pr.bounds)) {
            right = !right
        }
        moveY(speed * dt)
        moveX(speed * dt, state)
    }

    fun moveX(speed: Float, state: PongState) {
        if (right) {
            position.x += speed
        } else {
            position.x -= speed
        }
        if (position.x > PatternExercise.WIDTH) {
            position.x = PatternExercise.WIDTH / 2.toFloat()
            position.y = PatternExercise.HEIGHT / 2.toFloat()
            right = false
            up = !up
            state.incLeftScore()
        }
        if (position.x < 0) {
            position.x = PatternExercise.WIDTH / 2.toFloat()
            position.y = PatternExercise.HEIGHT / 2.toFloat()
            right = true
            up = !up
            state.incRightScore()
        }
    }

    fun moveY(speed: Float) {
        if (up) {
            position.y += speed
        } else {
            position.y -= speed
        }
        if (up && position.y > PatternExercise.HEIGHT) up = false
        if (!up && position.y < 0) up = true
    }
}