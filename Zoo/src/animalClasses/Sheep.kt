package animalClasses

import TextObject
import java.io.File

class Sheep (nameSheep: String) : Animal() {
    //Initialisire name mit parameter der class Chicken
    var nameOfSheep = nameSheep

    //Initialisire Index für Scharf
    var indexOfCurrentSheep = returnNameAnimalList().indexOf(nameOfSheep)

    //Initialisire Eier anzahl aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var statusOfTheFur: Boolean = returnAnimalEffectList()[indexOfCurrentSheep].toBooleanStrict()

    //Initialisire Tiergeräusch aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var noiseOfSheep = returnAnimalNoiseList()[indexOfCurrentSheep]

    //Initialisire Tiertyp aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var typOfSheep = returnAnimalTypeList()[indexOfCurrentSheep]

    //Initialisire Geschlecht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var genderOfSheep = returnGenderAnimalList()[indexOfCurrentSheep]

    //Initialisire Alter aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var ageOfSheep = returnAgeAnimalList()[indexOfCurrentSheep]

    //Initialisire Gewicht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var weightOfSheep = returnWeightAnimalList()[indexOfCurrentSheep]

    //Funktion Fell sauber machen
    fun cleanFur() {
        //Rufe Textausgabe aus TextObjekt datei raus.
        TextObject.getSheepCleanFurText(typOfSheep,nameOfSheep)
        // Beispiel Ausgabe: Das Fell von Schaf mit Name määäh wurde gereinigt.
        statusOfTheFur = true

        var listeEffect = returnAnimalEffectList()
        listeEffect[indexOfCurrentSheep]  = TextObject.getTrueText

        // Öffne die Datei im Schreibmodus
        val writer = File("src/main/kotlin/animalListe/animalListe").writer()
        // Schreibe den Inhalt der Listen für jeden index in die DateiFile ab
        for (i in listeEffect.indices) {
            writer.write(TextObject.getSheepSaveFileReaderText(i))
        }
        // Schließe den Writer
        writer.close()
    }

    override fun animalMakeNoise(nameAnimal: String) {
        super.animalMakeNoise(nameOfSheep)
    }
}
