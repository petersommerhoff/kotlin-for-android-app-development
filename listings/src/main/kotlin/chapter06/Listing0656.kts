import javafx.scene.image.Image
import java.util.concurrent.CompletableFuture

// Callbacks
fun fetchImageAsync(callback: (Image) -> Unit) { }

// Futures
fun fetchImageAsync(): CompletableFuture<Image> { return CompletableFuture() }

// Coroutines
suspend fun fetchImage(): Image { return Image("") }
