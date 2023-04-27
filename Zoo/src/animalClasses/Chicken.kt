package animalClasses

import TextObject

class Chicken(nameChicken: String) : Animal() {
    //Initialisire name mit parameter der classe Chicken
    var nameOfChicken = nameChicken

    //Initialisire Index für Huhn
    var indexOfCurrentChicken = returnNameAnimalList().indexOf(nameOfChicken)

    //Initialisire Eier anzahl aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var numberOfEggsPerDay: Int = returnAnimalEffectList()[indexOfCurrentChicken].toInt()

    //Initialisire Tiergeräusch aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var noiseOfChicken = returnAnimalNoiseList()[indexOfCurrentChicken]

    //Initialisire Tiertyp aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var typOfChicken = returnAnimalTypeList()[indexOfCurrentChicken]

    //Initialisire geschlächt aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var genderOfChicken = returnGenderAnimalList()[indexOfCurrentChicken]

    //Initialisire Gewicht aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var weightOfChicken = returnWeightAnimalList()[indexOfCurrentChicken]

    //Initialisire Alter aus der returnMethode der Klassen Animal aus der liste anhand des Namens index
    var ageOfChicken = returnAgeAnimalList()[indexOfCurrentChicken]

    //checke das, dass das Huhn nicht der Hahn ist :-)
    init {
        if (genderOfChicken == TextObject.getGenderMaleText) numberOfEggsPerDay = TextObject.getNullNumberInt
        else genderOfChicken = returnGenderAnimalList()[indexOfCurrentChicken]
    }

    override fun animalMakeNoise(nameAnimal: String) {
        super.animalMakeNoise(nameOfChicken)
    }

}