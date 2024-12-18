package org.floatingsquare.floatingsquare

import javafx.animation.AnimationTimer
import javafx.fxml.FXML
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class HelloController {
    @FXML
    private lateinit var square: Rectangle

    @FXML
    private lateinit var pane: Pane

    private var x = 375.0
    private var y = 275.0
    private var dx = 3.0
    private var dy = 3.0

    @FXML
    fun initialize() {
        object : AnimationTimer() {
            override fun handle(now: Long) {
                x += dx
                y += dy

                if (x <= 0 || x + square.width >= pane.width) {
                    dx = -dx
                    square.fill = randomColor()
                }
                if (y <= 0 || y + square.height >= pane.height) {
                    dy = -dy
                    square.fill = randomColor()
                }

                square.x = x
                square.y = y
            }
        }.start()
    }

    private fun randomColor(): Color {
        return Color.color(Math.random(), Math.random(), Math.random())
    }
}
