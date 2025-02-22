package com.maattss.pattern.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.sprites.Button


object MenuState : State() {
    // Center aligned play button
    private val playBtn: Button = Button(PatternExercise.WIDTH / 2 - 64,
            PatternExercise.HEIGHT / 2 + 64, "menu/play.png")

    override fun handleInput() {
        if (Gdx.input.justTouched()) {
            if (playBtn.bounds.contains(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())) {
                GameStateManager.set(PongState())
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        sb.draw(playBtn.texture, playBtn.x, PatternExercise.HEIGHT - playBtn.y)
        sb.end()
    }

    override fun dispose() {}
}