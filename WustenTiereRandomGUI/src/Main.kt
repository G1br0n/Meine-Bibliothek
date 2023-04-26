import javax.swing.JFrame

fun main() {
    val frame = JFrame("Wüstentier-Bilder")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(200, 200)
    frame.setLocationRelativeTo(null)
    frame.add(Panel())
    frame.isVisible = true

}