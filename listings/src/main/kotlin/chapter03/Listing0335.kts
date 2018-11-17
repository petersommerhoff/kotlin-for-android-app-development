import java.awt.Container
import java.awt.Dimension
import java.awt.Font

val container = Container().apply {  // Initializes object inside ‘apply’
  size = Dimension(1024, 800)
  font = Font.decode("Arial-bold-22")
  isVisible = true
}

println(container)