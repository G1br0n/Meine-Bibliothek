package animalClasses   //Bestimme das paket

import TextObject       // Import meine text Objet
import Visitor          // Import Besucher klasse

//Pony class, erbt von der class Tiere. parameter Name das Tier
class Pony(namePony: String) : Animal() {
    //Initialisire name mit parameter der classe Chicken
    var nameOfPony = namePony

    //Initialisire Index für Scharf
    var indexOfCurrentSheep = returnNameAnimalList().indexOf(nameOfPony)

    //Initialisire Eier anzahl aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var speedOfPony: Double = returnAnimalEffectList()[indexOfCurrentSheep].toDouble()

    //Initialisire Tiergeräusch aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var noiseOfPony = returnAnimalNoiseList()[indexOfCurrentSheep]

    //Initialisire Tiertyp aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var typOfPony = returnAnimalTypeList()[indexOfCurrentSheep]

    //Initialisire geschlächt aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var genderOfPony= returnGenderAnimalList()[indexOfCurrentSheep]

    //Initialisire Gewicht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var weightOfPony = returnWeightAnimalList()[indexOfCurrentSheep]

    //Initialisire Alter aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var ageOfPony = returnAgeAnimalList()[indexOfCurrentSheep]

    //Überschriebene Methode aus der class Animal.
    override fun animalMakeNoise(nameAnimal: String) {
        //gebe aktuelle Name von Tier and die haupt Methode zurück
        super.animalMakeNoise(nameAnimal)
    }
    //Die Methode gibt Name der Pony zurück.
    fun ponyName(): String{
        return nameOfPony
    }
    //Diese Methode gibt geschwindigkeit des pony zurück
    fun ponyRides(nameVisitor: Visitor): Double{
        //Rufe Textausgabe aus TextObjekt datei raus.
        TextObject.getPonyRidesText(nameOfPony,nameVisitor)
        //Beispiel Ausgabe: Pony reitet mit Geschwindigkeit von 4,2 km/h.
        return speedOfPony
    }
    //Überschriebene Methode aus der class Animal. Tier entscheidet sich zusätzlich für Zucker oder Karotte
    override fun animalMakeFed(nameVisitor: Visitor, nameAnimal: String, decision: String): Visitor {
        //Gebe den pfad der Liste für Zufall wehrten für tier entscheidung aus TextObjekt
        val randomDecision = TextObject.getPonyRandomDecisionListe
        //gebe ein paar wehrte an die haupt Methode zurück
        super.animalMakeFed(nameVisitor, nameAnimal, decision = randomDecision.random())
        //Gebe Name von Besucher zurück.
        return nameVisitor
    }

}