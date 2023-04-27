package animalClasses   //Defeniere Paket

import TextObject       // Import meine text Objet
import Visitor          // Import Besucher klasse
import java.io.File

open class Animal() {

//---------------------------------------Variable-----------------------------------------------------------------------
    //Gebe speicher ort/pfad der text datei mit Listen von Tieren
    private val animalListeFilePfad = File("src/main/kotlin/animalListe/animalListe")

    //Bereite lehre MutableListen for für alle Tire, für spätere verwendung
    val animalList = mutableListOf<String>()                        //Liste für alle Tiere und ihre werte.
    val animaNameList: MutableList<String> = mutableListOf()        //Liste für alle Name der Tiere.
    val animalWeightList: MutableList<Double> = mutableListOf()     //Liste für alle Gewicht der Tiere.
    val animaAgeList: MutableList<Int> = mutableListOf()            //Liste für alle Alter der Tiere
    val animaGenderList: MutableList<String> = mutableListOf()      //Liste für alle Geschlechte der Tiere.
    val animalNoiseList: MutableList<String> = mutableListOf()      //Liste für alle Geräusche der Tiere.
    val animalTypeList: MutableList<String> = mutableListOf()       //Liste für alle Typ der Tiere.
    val animalEffectList: MutableList<String> = mutableListOf()     //Liste für alle (effekte) Wehrte der Tiere.


//--------------------------------------Init Block----------------------------------------------------------------------
    init {
        //Überschreibe jede Linie aus der text datei in die tierListe
        animalListeFilePfad.forEachLine { it -> animalList.add(it) }

        //Für jeden index in obere Liste. Splitte ich den Text mit laufendem Index auf 7 anderen Listen
        for (animalIndex in animalList.indices) {
            animaNameList.add(animalList[animalIndex].split(" ")[0].replace("_"," "))
            animalWeightList.add(animalList[animalIndex].split(" ")[2].toDouble())
            animaAgeList.add(animalList[animalIndex].split(" ")[3].toInt())
            animaGenderList.add(animalList[animalIndex].split(" ")[4])
            animalNoiseList.add(animalList[animalIndex].split(" ")[5])
            animalTypeList.add(animalList[animalIndex].split(" ")[1])
            animalEffectList.add(animalList[animalIndex].split(" ")[6])
        }
    }
//--------------------------------Return Methoden-----------------------------------------------------------------------

    fun returnNameAnimalList():MutableList<String>{         //gebe mit der methode ListeNamen der Tiere zurück.
        return this.animaNameList
    }
    fun returnWeightAnimalList():MutableList<Double>{       //gebe mit der methode ListeGewicht der Tiere zurück.
        return this.animalWeightList
    }
    fun returnAgeAnimalList():MutableList<Int>{             //gebe mit der methode ListeAlter der Tiere zurück.
        return this.animaAgeList
    }
    fun returnGenderAnimalList():MutableList<String>{       //gebe mit der methode ListeGeschlecht der Tiere zurück.
        return this.animaGenderList
    }
    fun returnAnimalNoiseList():MutableList<String>{        //gebe mit der methode ListeGeräusche der Tiere zurück.
        return this.animalNoiseList
    }
    fun returnAnimalTypeList():MutableList<String>{         //gebe mit der methode ListeType der Tiere zurück.
        return this.animalTypeList
    }
    //gebe mit der methode Liste mit werten für Scharf, Kuh, Pony und Hun zurück. Eier stück am Tag, Fel sauber oder nicht. usw.
    fun returnAnimalEffectList():MutableList<String>{
        return this.animalEffectList
    }
    //gebe mit der methode complete Liste der Tiere zurück mit alen werten, mit eigenem index für jedes Tier.
    fun returnAnimalList():MutableList<String>{
        return this.animalList
    }
//--------------------------------Animals Actions-----------------------------------------------------------------------
    //Tier bewegt sich
    open fun animalMovementForward(nameAnimal: String){
        //Rufe die Textausgabe aus dem TextObjekt.
        TextObject.getAnimalMovementText(nameAnimal,animaNameList,animalNoiseList)
        //Beispiel Ausgabe: Missy bewegt sich vorwärts. Missy "Muuuuhh"
    }
    //Tier macht Geräusche
    open fun animalMakeNoise(nameAnimal: String) {
        //Rufe die Textausgabe aus dem TextObjekt.
        TextObject.getAnimalMakeNoiseText(animalTypeList,nameAnimal,animaNameList,animalNoiseList)
        //Beispiel Ausgabe: Pony mit Name Rocky Jr macht ein Geräusch. Das Tier "Wiehhiehie"!
    }
    //Tier wirt gestreichelt
    open fun animalMakeStroke(nameVisitor: Visitor, nameAnimal: String){
        //Rufe die Textausgabe aus dem TextObjekt.
        TextObject.getAnimalMakeStrokeText(nameAnimal,nameVisitor,animalNoiseList,animaNameList)
        //Beispiel Ausgabe: Das Tier namens Dolly wird von Andrej Ring gestreichelt. Dolly "Muuuuhh"!
    }
    //Tier wirt gefüttert
    open fun animalMakeFed(nameVisitor: Visitor, nameAnimal: String, decision: String = TextObject.nothingText): Visitor{
        //erstelle Variable für zusatz Text. wird später in if funktion umgeschrieben(TextObject.)
        var textAddition = TextObject.nothingText

        //wenn der parameter (decision nicht = ""), dann wird diese if ausgeführt
        if(decision != TextObject.nothingText) textAddition = TextObject.getAnimalMakeFedDecisionText(decision)

        //Speichere altes Gewicht ab
        val oldWeight = animalWeightList[animaNameList.indexOf(nameAnimal)]

        // rufe gewichts Liste auf, mit Namen index überschreibe ich das Gewicht des Tieres
        animalWeightList[animaNameList.indexOf(nameAnimal)] *= TextObject.weightAddition

        // Öffne die Datei im Schreibmodus
        val writer = File("src/main/kotlin/animalListe/animalListe").writer()

        //Rufe die Textausgabe aus dem TextObjekt.
        TextObject.getAnimalMakeFedText(nameAnimal,nameVisitor,oldWeight,animalWeightList,animaNameList,textAddition)
        //Beispiel Ausgabe: Das Tier namens Peaches wird von Andrej Ring gefüttert. Peaches wiegte 89,38 jetzt 91,17!

        //mit der Schleife überschreibe ich die Text data
        for (i in animalWeightList.indices) {
            // Erklerung: Name Art Gewicht Alter Gender Geräusche Effekt
            // Beispiel: Muffin Kuh 101.19 2 Männlich Muuuuhh false
            writer.write(TextObject.getAnimalSaveText(i))
        }
        // Schließe den Writer
        writer.close()

        //Rückgabe wehrt name des Besuchers: String
        return nameVisitor
    }
}