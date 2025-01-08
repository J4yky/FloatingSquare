package org.floatingsquare.floatingsquare

import javafx.animation.AnimationTimer
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class HelloController {
    @FXML
    private lateinit var square: Rectangle

    @FXML
    private lateinit var pane: Pane

    @FXML
    private lateinit var addButton: Button

    private val squares = mutableListOf<Rectangle>()
    private val velocities = mutableListOf<Pair<Double, Double>>()
    private val maxSquares = 10

    @FXML
    fun initialize() {
        squares.add(square)
        velocities.add(Pair(3.0, 3.0))

        addButton.setOnAction {
            if (squares.size < maxSquares) {
                val newSquare = Rectangle(50.0, 50.0, randomColor())
                newSquare.x = Math.random() * (pane.width - 50)
                newSquare.y = Math.random() * (pane.height - 50)
                pane.children.add(newSquare)
                squares.add(newSquare)
                velocities.add(Pair(3.0 * (if (Math.random() < 0.5) 1 else -1), 3.0 * (if (Math.random() < 0.5) 1 else -1)))
            }
        }

        object : AnimationTimer() {
            override fun handle(now: Long) {
                for (i in squares.indices) {
                    val square = squares[i]
                    var (dx, dy) = velocities[i]

                    square.x += dx
                    square.y += dy

                    // Check collision with walls
                    if (square.x <= 0 || square.x + square.width >= pane.width) {
                        dx = -dx
                        square.fill = randomColor()
                    }
                    if (square.y <= 0 || square.y + square.height >= pane.height) {
                        dy = -dy
                        square.fill = randomColor()
                    }

                    // Check collision with other squares
                    for (j in squares.indices) {
                        if (i != j) {
                            val other = squares[j]
                            if (square.boundsInParent.intersects(other.boundsInParent)) {
                                dx = -dx
                                dy = -dy
                                square.fill = randomColor()
                                other.fill = randomColor()
                            }
                        }
                    }

                    velocities[i] = Pair(dx, dy)
                }
            }
        }.start()
    }

    private fun randomColor(): Color {
        return Color.color(Math.random(), Math.random(), Math.random())
    }
}
