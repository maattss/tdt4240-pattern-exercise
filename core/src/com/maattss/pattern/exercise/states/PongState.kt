package com.maattss.pattern.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.sprites.BackButton
import com.maattss.pattern.exercise.sprites.Ball
import com.maattss.pattern.exercise.sprites.LeftPaddle
import com.maattss.pattern.exercise.sprites.RightPaddle


class PongState(gsm: GameStateManager) : State(gsm) {
    private val paddleLeft: LeftPaddle = LeftPaddle(100, 30)
    private val paddleRight: RightPaddle = RightPaddle(1700, 30)
    private val backBtn: BackButton = BackButton()
    private var scoreLeft: Int = 0
    private var scoreRight: Int = 0
    private var winnerStr: String = ""
    private val font: BitmapFont = BitmapFont(Gdx.files.internal("fonts/krungthep.fnt"))

    public override fun handleInput() {
        if (Gdx.input.justTouched()) {
            val touch = Rectangle(Gdx.input.x.toFloat(),
                    (PatternExercise.HEIGHT - Gdx.input.y).toFloat(), 1f, 1f)
            if (touch.overlaps(backBtn.bounds)) { // User pushed back button
                gsm.set(MenuState(gsm))
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
        paddleLeft.update()
        paddleRight.update()
        Ball.update(dt, this, paddleLeft, paddleRight)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        sb.draw(backBtn.texture, backBtn.x, backBtn.y)
        if (winnerStr !== "") { // Draw scoreboard
            font.data.setScale(0.9f)
            font.color = Color.WHITE
            font.draw(sb, winnerStr, 300f, PatternExercise.HEIGHT / 2 + 100.toFloat())
        } else { // Update paddle position
            sb.draw(paddleRight.texture, paddleRight.position.x, paddleRight.position.y)
            sb.draw(paddleLeft.texture, paddleLeft.position.x, paddleLeft.position.y)
            sb.draw(Ball.texture, Ball.position.x, Ball.position.y, 20f, 20f)
            // Draw scoreboard
            font.data.setScale(0.9f)
            font.color = Color.WHITE
            font.draw(sb, "$scoreLeft : $scoreRight",
                    PatternExercise.WIDTH / 2 - 100.toFloat(), PatternExercise.HEIGHT - 50.toFloat())
        }
        sb.end()
    }

    fun incRightScore() {
        scoreRight++
        if (scoreRight >= 21) {
            winnerStr = "Right player won!"
        }
    }

    fun incLeftScore() {
        scoreLeft++
        if (scoreLeft >= 21) {
            winnerStr = "Left player won!"
        }
    }

    override fun dispose() {}
}