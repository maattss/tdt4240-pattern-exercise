package com.maattss.pattern.exercise

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.maattss.pattern.exercise.states.GameStateManager
import com.maattss.pattern.exercise.states.MenuState

class PatternExercise : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch

    override fun create() {
        WIDTH = Gdx.graphics.width
        HEIGHT = Gdx.graphics.height
        batch = SpriteBatch()
        GameStateManager.push(MenuState)
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        GameStateManager.update(Gdx.graphics.deltaTime)
        GameStateManager.render(batch)
    }

    companion object {
        @JvmField
        var WIDTH = 0
        @JvmField
        var HEIGHT = 0
    }
}