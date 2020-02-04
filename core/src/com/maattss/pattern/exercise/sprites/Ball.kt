package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.states.PongState

class Ball : Sprite() {
    override val texture: Texture = Texture("pong/ball.png")
    override val position: Vector2 = Vector2((PatternExercise.WIDTH / 2).toFloat(),
            (PatternExercise.HEIGHT / 2).toFloat())
    override val bounds: Rectangle = Rectangle(position.x, position.y, 20f, 20f)

    private var up: Boolean = true
    private var moveRight: Boolean = true
    private val speed: Int = 200

    fun update(dt: Float, state: PongState, leftPaddle: LeftPaddle, rightPaddle: RightPaddle) {
        bounds.setPosition(position.x, position.y)
        if (bounds.overlaps(leftPaddle.bounds)) moveRight = true
        if (bounds.overlaps(rightPaddle.bounds)) moveRight = false

        moveY(speed * dt)
        moveX(speed * dt, state)
    }

    private fun moveX(speed: Float, state: PongState) {
        if (moveRight) {
            position.x += speed
        } else {
            position.x -= speed
        }

        if (position.x > PatternExercise.WIDTH - texture.width/2) {
            position.x = PatternExercise.WIDTH / 2.toFloat()
            position.y = PatternExercise.HEIGHT / 2.toFloat()
            moveRight = false
            up = !up
            state.incLeftScore()
        }

        if (position.x < 0) {
            position.x = PatternExercise.WIDTH / 2.toFloat()
            position.y = PatternExercise.HEIGHT / 2.toFloat()
            moveRight = true
            up = !up
            state.incRightScore()
        }
    }

    private fun moveY(speed: Float) {
        if (up) {
            position.y += speed
        } else {
            position.y -= speed
        }
        if (up && position.y > PatternExercise.HEIGHT - texture.height/2) up = false
        if (!up && position.y < 0) up = true
    }
}