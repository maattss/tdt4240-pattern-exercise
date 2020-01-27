package com.maattss.pattern.exercise.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch

abstract class State(protected var gsm: GameStateManager) {
    protected abstract fun handleInput()
    abstract fun update(dt: Float)
    abstract fun render(sb: SpriteBatch)
    abstract fun dispose()
}