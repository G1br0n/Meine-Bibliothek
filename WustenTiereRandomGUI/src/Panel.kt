import javax.swing.*
import java.awt.*
import java.awt.event.*
import java.io.File
import javax.imageio.ImageIO

class Panel : JPanel() {

    private var ausgabe = JTextField(20)
    private var button1 = JButton("Random Tier")
    private var animalImageLabel = JLabel()

    private var desertLocation = DesertLocation()

    init {
        layout = BorderLayout()

        val topPanel = JPanel()
        topPanel.layout = FlowLayout(FlowLayout.CENTER, 10, 10)
        topPanel.add(ausgabe)
        add(topPanel, BorderLayout.NORTH)

        val imagePanel = JPanel()
        imagePanel.layout = FlowLayout(FlowLayout.CENTER, 10, 10)
        imagePanel.add(animalImageLabel)
        add(imagePanel, BorderLayout.CENTER)

        val buttonPanel = JPanel()
        buttonPanel.layout = GridLayout(1, 1)
        buttonPanel.add(button1)
        add(buttonPanel, BorderLayout.SOUTH)

        // Load the initial image
        loadAnimalImage("default.jpg")

        // Register event listeners
        button1.addActionListener(MyActionListener())
    }

    private fun loadAnimalImage(imageName: String) {
        try {
            val imageFile = File("WustenTiereRandomGUI/images/$imageName")
            if (imageFile.exists()) {
                val image = ImageIO.read(imageFile)
                val resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)
                animalImageLabel.icon = ImageIcon(resizedImage)
                animalImageLabel.horizontalAlignment = SwingConstants.CENTER
                animalImageLabel.verticalAlignment = SwingConstants.CENTER
            } else {
                if (imageName != "default.jpg") {
                    loadAnimalImage("default.jpg")
                } else {
                    println("Bild '$imageName' konnte nicht gefunden werden.")
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private inner class MyActionListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            // Generate a random desert animal from DesertLocation class
            val randomDesertAnimal = desertLocation.getRandomDesertAnimal()

            // Set the text field to display the random desert animal
            ausgabe.text = randomDesertAnimal

            // Load the corresponding animal image
            val imageName = "$randomDesertAnimal.jpg"
            loadAnimalImage(imageName)
        }
    }
}