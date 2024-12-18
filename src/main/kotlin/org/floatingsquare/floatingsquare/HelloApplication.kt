package org.floatingsquare.floatingsquare

import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.application.Application

class HelloApplication : Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 800.0, 600.0)
        primaryStage.title = "Floating Square"
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}