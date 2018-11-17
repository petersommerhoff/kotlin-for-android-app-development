import javafx.scene.Scene

object SceneRegistry {  // Declares an object: this is effectively a Singleton
  lateinit private var homeScene: Scene
  lateinit private var settingsScene: Scene
  fun buildHomeScene() { }
  fun buildSettingsScene() { }
}
