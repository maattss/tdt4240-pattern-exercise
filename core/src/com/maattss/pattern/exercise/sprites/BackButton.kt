package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.pattern.exercise.PatternExercise

class BackButton(white: Boolean) {
    var texture: Texture? = null
    private val position: Vector2 = Vector2(50f, (PatternExercise.HEIGHT - 100).toFloat())
    val bounds: Rectangle = Rectangle(position.x, position.y, 100f, 100f)

    val x: Float
        get() = position.x

    val y: Float
        get() = position.y

    fun dispose() {
        texture!!.dispose()
    }

    init {
        if (white) {
            texture = Texture("buttons/backWhite.png")
        } else {
            texture = Texture("buttons/back.png")
        }
    }
}