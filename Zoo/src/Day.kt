import animalClasses.*

//TODO sory habe nicht geschaft alles zo komentieren. Wie immer ist es bie mir wieder mal grosse Code geworden
// habe versucht so viel einzusetsen wie möglich aus dem was wir gelehrnt haben und wohlte unbeding mid dem File datej rauslesen und überschreiben üben

fun main (){

    //Jeder der Besucher versucht in den Streichelzoo zu gehen.
    Thread.sleep(700)
    println("\nJeder der Besucher versucht in den Streichelzoo zu gehen.")
    Thread.sleep(1500)
    var visitorListePrivat: MutableList<Visitor> = mutableListOf()
    do{
        TextObject.randomVisitor()
        val (visitorMaxCountIsInLimit,visitorListe) = PettingZoo().registerNewVisitors()
        visitorListePrivat = visitorListe
    }while (!visitorMaxCountIsInLimit)

    //Alle Besucher wollen zuerst auf einem der Ponys reiten.
    Thread.sleep(700)
    println("\nAlle Besucher wollen zuerst auf einem der Ponys reiten.")
    Thread.sleep(1500)
    for (visitor in visitorListePrivat){
        Thread.sleep(700)
        Pony(Animal().returnNameAnimalList()[PettingZoo().returnPonyIdList().random()]).ponyRides(visitor)
    }

    //Ein Besucher füttert das Schaf.
    Thread.sleep(700)
    println("\nEin Besucher füttert das Schaf.")
    Thread.sleep(1500)
    val randomSheep = Animal().returnNameAnimalList()[PettingZoo().returnSheepIdList().random()]
    Sheep(randomSheep).animalMakeFed(visitorListePrivat.random(),randomSheep)

    //Eines der Hühner läuft durchs Gehege.
    Thread.sleep(700)
    println("\nEines der Hühner läuft durchs Gehege.")
    Thread.sleep(1500)
    var randomChicken = Animal().returnNameAnimalList()[PettingZoo().returnChickenIdListe().random()]
    Chicken(randomChicken).animalMovementForward(randomChicken)

    //Ein paar Besucher streicheln die Kuh.
    Thread.sleep(700)
    println("\nEin paar Besucher streicheln die Kuh.")
    Thread.sleep(1500)
    var randomCow = Animal().returnNameAnimalList()[PettingZoo().returnCowIdListe().random()]
    repeat((1..visitorListePrivat.size).random()){
        randomCow = Animal().returnNameAnimalList()[PettingZoo().returnCowIdListe().random()]
        Cow(randomCow).animalMakeStroke(visitorListePrivat.random(),randomCow)
        Thread.sleep(700)
    }

    // 2 Besucher verlassend den Streichelzoo.
    Thread.sleep(700)
    println("\n2 Besucher verlassend den Streichelzoo.")
    repeat(2){
        PettingZoo().aVisitorLeavesTheZoo()
    }

    //Ein Besucher versucht die Kuh zu melken.
    Thread.sleep(700)
    println("\nDrei Besucher versuchen die Kühe zu melken.")
        Thread.sleep(1500)
    repeat(3) {
        randomCow = Animal().returnNameAnimalList()[PettingZoo().returnCowIdListe().random()]
        Cow(randomCow).milkingCow(PettingZoo().visitorList.random())
        Thread.sleep(700)
    }

    //Fütterungszeit. Ein Besucher füttert alle Tiere.
    Thread.sleep(700)
    println("\nFütterungszeit. Ein Besucher füttert alle Tiere.")
    Thread.sleep(1500)
    var randomVisitor = PettingZoo().visitorList.random()
    for (i in Animal().returnNameAnimalList()){
        Animal().animalMakeFed(randomVisitor,i)
        Thread.sleep(700)
    }

    //Ein Zoowärter kontrolliert alle Schafe, ob sie sauber sind. Wäscht die dreckigen.
    Thread.sleep(700)
    println("\nEin Zoowärter kontrolliert alle Schafe, ob sie sauber sind. Wäscht die dreckigen.")
    Thread.sleep(1500)
    for (i in PettingZoo().returnSheepIdList()){
        Sheep(Animal().returnNameAnimalList()[i]).cleanFur()
        Thread.sleep(700)
    }

    //Zuletzt haben die beiden Ponys ein Rennen.
    Thread.sleep(700)
    println("\nZuletzt haben die beiden Ponys ein Rennen.")
    Thread.sleep(1500)
    PettingZoo().ponyRace()

    //Die restlichen Besucher verlassen den Zoo.
    Thread.sleep(700)
    println("\nDie restlichen Besucher verlassen den Zoo.")
    Thread.sleep(1500)
    PettingZoo().zooIsNowClosings()
}