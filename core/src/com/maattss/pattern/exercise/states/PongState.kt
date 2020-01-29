package com.maattss.pattern.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.pattern.exercise.PatternExercise
import com.maattss.pattern.exercise.sprites.Ball
import com.maattss.pattern.exercise.sprites.Button
import com.maattss.pattern.exercise.sprites.LeftPaddle
import com.maattss.pattern.exercise.sprites.RightPaddle


object PongState : State(GameStateManager) {
    private val paddleLeft: LeftPaddle = LeftPaddle(50, 30)
    private val paddleRight: RightPaddle = RightPaddle(PatternExercise.WIDTH - 50, 30)
    private val ball: Ball = Ball()
    private val backBtn: Button = Button(25, PatternExercise.HEIGHT - 150, "buttons/back.png")
    private var scoreLeft: Int = 0
    private var scoreRight: Int = 0
    private var winnerStr: String = ""
    private val font: BitmapFont = BitmapFont(Gdx.files.internal("fonts/krungthep.fnt"))
    private const val fontScale: Float = 0.3f

    public override fun handleInput() {
        if (Gdx.input.justTouched()) {
            val touch = Rectangle(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 1f, 1f)
            if (touch.overlaps(backBtn.bounds)) { // User pushed back button
                GameStateManager.set(MenuState)
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
        paddleLeft.update()
        paddleRight.update()
        ball.update(dt, this, paddleLeft, paddleRight)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        sb.draw(backBtn.texture, backBtn.x, backBtn.y)

        if (winnerStr !== "") { // Draw scoreboard
            val fontWidth = GlyphLayout(font, "Some player won!").width
            val fontX = (PatternExercise.WIDTH - fontWidth) / 2
            val fontY = PatternExercise.HEIGHT / 2 + 100.toFloat()
            font.data.setScale(fontScale)
            font.color = Color.WHITE
            font.draw(sb, "Right player won!", fontX, fontY)
        } else { // Update paddle position
            val fontWidth = GlyphLayout(font, "$scoreLeft : $scoreRight").width
            sb.draw(paddleRight.texture, paddleRight.position.x, paddleRight.position.y)
            sb.draw(paddleLeft.texture, paddleLeft.position.x, paddleLeft.position.y)
            sb.draw(ball.texture, ball.position.x, ball.position.y, 20f, 20f)

            // Draw scoreboard
            val fontX = (PatternExercise.WIDTH - fontWidth) / 2
            val fontY = PatternExercise.HEIGHT - 50.toFloat()
            font.data.setScale(fontScale)
            font.color = Color.WHITE
            font.draw(sb, "$scoreLeft : $scoreRight", fontX, fontY)
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