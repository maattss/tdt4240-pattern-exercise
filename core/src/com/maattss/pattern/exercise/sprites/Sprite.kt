package com.maattss.pattern.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

abstract class Sprite {
    abstract val texture: Texture
    abstract val position: Vector2
    abstract val bounds: Rectangle
}