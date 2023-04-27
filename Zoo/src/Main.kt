import animalClasses.*

fun main() {

    //Stele die ausgabe alle Tier klassen vor
    theAnimals()
    Thread.sleep(2000)
    //Test funktionen aus der classe PettingZoo
    Thread.sleep(2000)
    println(PettingZoo().cowIdList)
    Thread.sleep(2000)
    PettingZoo().registerNewVisitors()
    Thread.sleep(2000)
    PettingZoo().aVisitorLeavesTheZoo()
    Thread.sleep(2000)
    PettingZoo().printVisitorListInZoo()
    Thread.sleep(2000)
    PettingZoo().zooIsNowClosings()
    Thread.sleep(2000)
    PettingZoo().animalsAreHappyAboutVisitors("Andrej")
    Thread.sleep(2000)
    PettingZoo().ponyRace()
}

//funktion die den Überblick bittet über die Möglichkeiten der Klassen.
fun theAnimals() {
    val visitor1 = Visitor("Andrej Ring",33)
//------------------------------------------------------Besucher--------------------------------------------------------
    println("\nAufgabe Besucher:")
    //Ausgabe: Hallo mein Name ist Andrej Ring und ich bin 33 Jahre alt.
    visitor1.visitorIntroduce()

//------------------------------------------------------Tier------------------------------------------------------------
    println("\nAufgabe Tier:")
    //Ausgabe: Missy bewegt sich vorwärts. Missy "muht"
    Animal().animalMovementForward("Toby")
    //Ausgabe Console: Pony mit Name Rocky Jr macht ein Geräusch. Das Tier "wiehert"!
    Animal().animalMakeNoise("Rocky Jr")
    //Ausgabe Console: Das Tier namens Peaches wird von Andrej Ring gefüttert. Peaches "gackert"!
    Animal().animalMakeFed(visitor1,"Peaches")
    //Ausgabe Console: Das Tier namens Dolly wird von Andrej Ring gestreichelt. Dolly "muht"!
    Animal().animalMakeStroke(visitor1,"Dolly")

//------------------------------------------------------Schaf-----------------------------------------------------------
    println("\nAufgabe Schaf:")
    val sheep = "Nellie"
    //Ausgabe Console: Das Fell von Schaf mit Name Nellie wurde gereinigt.
    Sheep(sheep).cleanFur()
    //Ausgabe Console: Schaf mit Name Nellie macht ein Geräusch. Das Tier "määäh"!
    Sheep(sheep).animalMakeNoise(sheep)
    //Ausgabe Console: Das Tier namens Nellie wird von Andrej Ring gefüttert. Nellie "määäh"!
    Sheep(sheep).animalMakeFed(visitor1,sheep)
    //Ausgabe Console: Das Tier namens Nellie wird von Andrej Ring gestreichelt. Nellie "määäh"!
    Sheep(sheep).animalMakeStroke(visitor1,sheep)

//------------------------------------------------------Kuh-------------------------------------------------------------
    println("\nAufgabe Kuh:")
    val kuhName = "Muffin"
    val kuh = Cow(kuhName)
    //Ausgabe Console: Kuh mit Name Muffin macht ein Geräusch. Das Tier "Muuuuhh"!
    kuh.animalMakeNoise(kuhName)
    //Ausgabe Console: Das Tier namens Kuh wird von Andrej Ring gefüttert. Kuh "Muuuuhh"!
    kuh.animalMakeFed(visitor1,kuhName)
    //Ausgabe Console: Das Tier namens Kuh wird von Andrej Ring gestreichelt. Kuh "Muuuuhh"!
    kuh.animalMakeStroke(visitor1,kuhName)
    //Ausgabe Console: Pony reitet mit geschwindigkeit von 4,2 km/h
    kuh.milkingCow(visitor1)

//------------------------------------------------------Huhn------------------------------------------------------------
    println("\nAufgabe Huhn:")
    val chickenSnoopy = Chicken("Nemo")
    //Ausgabe Console: Huhn mit Name Snoopy macht ein Geräusch. Das Tier "gackert"!
    chickenSnoopy.animalMakeNoise(chickenSnoopy.nameOfChicken)
    //Ausgabe Console: Huhn mit Name Snoopy legt 3 eier am Tag.
    println("${chickenSnoopy.typOfChicken} mit Name ${chickenSnoopy.nameOfChicken} legt ${chickenSnoopy.numberOfEggsPerDay} eier am Tag.")
    //Ausgabe Console: Das Tier namens Snoopy wird von Andrej Ring gefüttert. Snoopy "gackert"!
    chickenSnoopy.animalMakeFed(visitor1,chickenSnoopy.nameOfChicken)
    //Ausgabe Console: Das Tier namens Snoopy wird von Andrej Ring gestreichelt. Snoopy "gackert"!
    chickenSnoopy.animalMakeStroke(visitor1,chickenSnoopy.nameOfChicken)

//------------------------------------------------------Pony------------------------------------------------------------
    println("\nAufgabe Pony:")
    val ponyName = "Rocky Jr"
    val pony = Pony(ponyName)
    //Ausgabe Console: Pony mit Name Rocky Jr macht ein Geräusch. Das Tier "Wiehhiehie"!
    pony.animalMakeNoise(ponyName)
    //Ausgabe Console: Das Tier namens Pony wird von Andrej Ring gefüttert. Pony "Wiehhiehie"!
    pony.animalMakeFed(visitor1,ponyName)
    //Ausgabe Console: Das Tier namens Pony wird von Andrej Ring gestreichelt. Pony "Wiehhiehie"!
    pony.animalMakeStroke(visitor1,ponyName)
    //Ausgabe Console: Pony reitet mit geschwindigkeit von 4,2 km/h
    pony.ponyRides(visitor1)
}

fun pettingZoo(){

}