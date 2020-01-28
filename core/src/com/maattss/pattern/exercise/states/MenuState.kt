package com.maattss.pattern.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.sprites.MenuButton


class MenuState(gsm: GameStateManager) : State(gsm) {
    private val play: MenuButton = MenuButton(PatternExercise.WIDTH/2 - 128,
            PatternExercise.HEIGHT / 2 - 128, "menu/play.png")

    override fun handleInput() {
        if (Gdx.input.justTouched()) { // Decide which exercise user has selected
            val touch = Rectangle(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 1f, 1f)
            if (touch.overlaps(play.bounds)) {
                gsm.set(PongState(gsm))
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        sb.draw(play.texture, play.x, PatternExercise.HEIGHT - play.y)
        sb.end()
    }

    override fun dispose() {
        play.dispose()
    }
}