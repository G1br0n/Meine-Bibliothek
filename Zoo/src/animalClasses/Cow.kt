package animalClasses   //Bestimme das paket

import TextObject       // Import meine text Objet
import Visitor

class Cow (nameCow: String) : Animal() {
    //Initialisire name mit parameter der class Chicken
    var nameOfCow = nameCow

    //Initialisire Index für Scharf
    var indexOfCurrentCow = returnNameAnimalList().indexOf(nameOfCow)

    //Initialisire Eier anzahl aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var statusMilkingOfTheCow: Boolean = returnAnimalEffectList()[indexOfCurrentCow].toBooleanStrict()

    //Initialisire Tiergeräusch aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var noiseOfCow = returnAnimalNoiseList()[indexOfCurrentCow]

    //Initialisire Tiertyp aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var typOfCow = returnAnimalTypeList()[indexOfCurrentCow]

    //Initialisire Geschlecht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var genderOfCow = returnGenderAnimalList()[indexOfCurrentCow]

    //Initialisire Alter aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var ageOfCow = returnAgeAnimalList()[indexOfCurrentCow]

    //Initialisire Gewicht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var weightOfCow = returnWeightAnimalList()[indexOfCurrentCow]

    //Kuh melken funktion
    fun milkingCow(nameVisitor: Visitor) {
        //Rufe Textausgabe aus TextObjekt datei raus.
        TextObject.getCowMilkingStatusText(genderOfCow,statusMilkingOfTheCow,typOfCow,nameOfCow,nameVisitor)
        //Beispiel Ausgabe: Kuh mit Name Muffin kann mann nicht melken. Ausserdem ist das Tier Männlich
    }
    //Überschriebene Methode aus der class Animal.
    override fun animalMakeNoise(nameAnimal: String) {
        //gebe aktuelle Name von Tier and die haupt Methode zurück
        super.animalMakeNoise(nameOfCow)
    }
}