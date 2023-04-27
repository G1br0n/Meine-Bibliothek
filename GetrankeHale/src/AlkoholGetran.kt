import java.io.File

class AlkoholGetrank: GetrankWare() {

    var alkoholGehalt = 0.0

    init {
        // Definiere den Pfad zur Getränkedatei und speichere sie als File in getrankeFile
        val getrankeFile: File = File("GetrankeHale/src/producte/getrankeAlkohol")

        // Erstelle eine Liste für jede Zeile aus der Getränkedatei
        getrankeFile.forEachLine { this.getrankListe.add(it) }


        for (getrank in getrankListe) {
            val values = getrank.split(" ")

            val id = values[0].toInt()
            val name = values[1]
            val price = values[2].toDouble()
            val gewichtIn = values[3].toInt()
            val bestand = values[4].toInt()
            val alkoholGehalt = values[5].toInt()

            this.idListe.add(id)
            this.nameListe.add(name)
            this.priceListe.add(price)
            this.gewichtListe.add(gewichtIn)
            this.bestandListe.add(bestand)
            this.bestandListe.add(alkoholGehalt)
        }
    }
}