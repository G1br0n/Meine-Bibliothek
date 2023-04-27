import animalClasses.Animal
import java.io.File
import kotlin.math.roundToInt
import kotlin.system.exitProcess


class PettingZoo: Animal() {
    //Gebe speicher ort/pfad der text datei mit Listen von Besucher
    val visitorListeFilePfad = File("src/main/kotlin/visitorListe/visitorFile")
    //Bereite lehre MutableListen for für besucher vor.
    val visitorList: MutableList<Visitor> = mutableListOf()

    //Bereite lehre listen vor für spätere verwendung un befülung
    val cowIdList: MutableList<Int> = mutableListOf()           // für INDEX Kühen
    val ponyIdList: MutableList<Int> = mutableListOf()          // für INDEX Ponys
    val sheepIdList: MutableList<Int> = mutableListOf()         // für INDEX Schafe
    val chickenIdList: MutableList<Int> = mutableListOf()       // für INDEX Hühner

    //Init Block
    init {
        //Initialisiere Besucher Map
        visitorListeFilePfad.forEachLine {
            visitorList.add(Visitor(it.split(" ")[0], it.split(" ")[1].toInt()))
        }

        //Sortiere meine Tiere nach Typ und speichere je walls zugewiesenen Tier Index in jewalige liste.
        for (i in returnAnimalTypeList().indices) {
            if (returnAnimalTypeList()[i] == TextObject.getTypCow) cowIdList.add(i)
            if (returnAnimalTypeList()[i] == TextObject.getTypPony) ponyIdList.add(i)
            if (returnAnimalTypeList()[i] == TextObject.getTypSheep) sheepIdList.add(i)
            if (returnAnimalTypeList()[i] == TextObject.getTypChicken) chickenIdList.add(i)
        }
    }
    fun printCowIndexAndName(){
        TextObject.getPrintAnimalIndexAndName(cowIdList)        // printe in Console alle Kuh index, typ, gender und namen aus.
    }
    fun returnCowIdListe(): MutableList<Int>{
        return cowIdList
    }
    fun printPonyIndexAndName(){
        TextObject.getPrintAnimalIndexAndName(ponyIdList)       // printe in Console alle Pony index, typ, gender und namen aus.
    }
    fun returnPonyIdList(): MutableList<Int>{
        return ponyIdList
    }
    fun printSheepIndexAndName(){
        TextObject.getPrintAnimalIndexAndName(sheepIdList)      // printe in Console alle Schaf index, typ, gender und namen aus.
    }
    fun returnSheepIdList(): MutableList<Int>{
        return sheepIdList
    }
    fun printChickenIndexAndName(){
        TextObject.getPrintAnimalIndexAndName(chickenIdList)    // printe in Console alle Hühner index, typ, gender und namen aus.
    }
    fun returnChickenIdListe(): MutableList<Int>{
        return chickenIdList
    }

    //Besucher registrierung Methode
    fun registerNewVisitors():Pair <Boolean, MutableList<Visitor>> {
        var nameVisitor = ""                    // zum Speichern von namen
        var ageVisitor: Int? = -1               // zum Speichern von alter
        var nameIsInList = false                // überschreibe den wert auf true wen name in der Liste ist
        var visitorMaxCountIsInLimit = false    // überschreibe den wert auf true, wenn Liste size 5 ist

        //besucher registrieren kann man nur wen die Liste.sitze unter 5 ist
        if (visitorList.size <= 4) {
            do {
                //gebe raus wie viele Besucher im Zoo sind
                println("Besucher aktuell im Zoo: ${visitorList.size}")
                //Sage dem Kassierer das er Name und Vorname des Besucher eingeben soll
                println("Name und Vorname des Besucher eingeben. Exit eingeben zum verlassen")
                //Speichere die eingabe des namens Andrej Ring Egorowich zum Andrej_Ring_Egorowich
                nameVisitor = readln().replace(" ", "_")
                //wen die eingabe exit ist dan bendet man das prozezes (später kan man das snell in funktion flüsse intergriren)
                if (nameVisitor.lowercase() == "exit") exitProcess(1)

                //hier gehe ich die Besucherliste durch und überprüfe das, die eingegebene name bereits in der liste ist
                for (i in visitorList.indices) {
                    //wenn das der Fall ist, dan gibt es in der Consolen ausgabe darüber, wehrt name exsestirt wird überschrieben und die for schleife wird beendet
                    if (visitorList[i].name == nameVisitor) {
                        println("Name des Besuchers ${visitorList[i].name.replace("_"," ")} existiert. Bereits")
                        nameIsInList = true
                        break
                    } else {
                        //anderes falls setze ich den wehrt zu false
                        nameIsInList = false
                    }
                }
                //wen die Name exsestiert gehe ich zum anfang der schleife, wo mann den Namen des Besucher eingibt
                if(nameIsInList)continue
            //die schleife wierd wiederholt bis die name nicht geändert ist und die name des neun besucher in der Liste ist
            } while (nameVisitor == "" && nameIsInList)


            var check = "exit"

            do {
                println("Bitte Alter der Kunde eingeben")
                check = readln()
                ageVisitor = check.toIntOrNull()

                if (check.lowercase() == "exit") exitProcess(1)
                if (ageVisitor != null) {
                    ageVisitor = ageVisitor.toInt()
                    if (ageVisitor !in (0..110)) {
                        println("Gebe den alter richtig ein")
                        continue
                    }
                    continue
                } else println("Die eingabe mus eine Zahl sein")
            } while (ageVisitor == null || ageVisitor !in (0..120))

            visitorList.add(Visitor(nameVisitor, ageVisitor.toInt()))
            println("Der Besucher wurde erfolgreich Registriert")
            animalsAreHappyAboutVisitors(nameVisitor)
            // Öffne die Datei im Schreibmodus
            val writer = File("src/main/kotlin/visitorListe/visitorFile").writer()

            //mit der Schleife überschreibe ich die Text data
            for (i in visitorList) {
                writer.write(i.name.replace(" ", "_") + " " + i.age + "\n")
            }
            // Schließe den Writer
            writer.close()
            return Pair(visitorMaxCountIsInLimit,visitorList)
        } else {
            println("\nDie maximale Anzahl an Besucher ist erreicht, Registrierungsprozess wird beendet")
            visitorMaxCountIsInLimit = true
            return Pair(visitorMaxCountIsInLimit,visitorList)
        }
    }

    fun printVisitorListInZoo() {
        println("\nAktuelle Besucherliste: ${visitorList.size}")
        for (i in visitorList.indices) {
            println("ID: "+ (i + 1) + " Name: " + visitorList[i].name.replace("_"," ") + " Alter: " + visitorList[i].age)
        }
    }


    fun aVisitorLeavesTheZoo(){
        printVisitorListInZoo()
        do {

        println("Wer von den Besucher verlässt das Zoo? Bitte nummer Eingeben:")
        var inputNumber: Int? = readln().toIntOrNull()
        if (inputNumber != null) {
            if (inputNumber.toInt() <= visitorList.size) {
                visitorList.removeAt(inputNumber - 1)

                val writer = File("src/main/kotlin/visitorListe/visitorFile").writer()

                //mit der Schleife überschreibe ich die Text data
                for (i in visitorList) {
                    writer.write(i.name.replace(" ", "_") + " " + i.age + "\n")
                }
                // Schließe den Writer
                writer.close()
            } else {
                println("Die Eingabe ist nicht im Auswahl")
                inputNumber = null
                continue
            }
        } else {
            println("Die Eingabe mus ein Zahl sein")
            inputNumber = null
            continue

        }

        } while (inputNumber == null)

    }

    fun zooIsNowClosings(){
        visitorList.clear()
        val writer = File("src/main/kotlin/visitorListe/visitorFile").writer()
        writer.write("")
        writer.close()
        println("Der Zoo ist jetzt Geschlossen. Alle besucher haben das Zoo verlassen.")
    }

    fun animalsAreHappyAboutVisitors(visitorName: String) {
        var animalRandomList = mutableListOf<Int>()
        animalRandomList.add(cowIdList.random())
        animalRandomList.add(sheepIdList.random())
        animalRandomList.add(ponyIdList.random())
        animalRandomList.add(chickenIdList.random())

        println("\nAlle Tiere freuen sich im Zoo über ${visitorName.replace("_"," ")}. Einige begrüssen den Besucher mit lauten Töne.")
        for (i in animalRandomList) {
            Thread.sleep(500)
          println("Aus Gehege Nr.${i + 1} kommt ein laute Ton von ${returnAnimalTypeList()[i]} ${returnNameAnimalList()[i]} \"${returnAnimalNoiseList()[i]}\"")
        }
    }

    fun ponyRace() {
        var distanz = 1000.0

        val racePonyIdListe: MutableList<Int> = mutableListOf()

        do {
            racePonyIdListe.add(ponyIdList[((0..ponyIdList.lastIndex).random())])
            racePonyIdListe.add(ponyIdList[((0..ponyIdList.lastIndex).random())])
            if (racePonyIdListe[0] == racePonyIdListe[1]){
                racePonyIdListe.clear()
                continue
            }
        } while ( racePonyIdListe.size  <= 2 || racePonyIdListe[0] == racePonyIdListe[1])

        println("\nAn dem Rennen Nehmen teil Pony ${returnNameAnimalList()[racePonyIdListe[0]]} aus Gehege Nr.${racePonyIdListe[0] + 1}" +
                " und Pony ${returnNameAnimalList()[racePonyIdListe[1]]} aus Gehege Nr.${racePonyIdListe[1] + 1} \nDie Rennstrecke ist $distanz m lang.")

        if (returnAnimalEffectList()[racePonyIdListe[0]].toDouble() < returnAnimalEffectList()[racePonyIdListe[1]].toDouble()){
            println("Pony mit Name ${returnNameAnimalList()[racePonyIdListe[1]]} hat das Rennen gewonnen.")
            println("${returnNameAnimalList()[racePonyIdListe[1]]} wahr ${returnAnimalEffectList()[racePonyIdListe[1]].toDouble()} " +
                    "km/h snell und hat die Strecke von $distanz Meter in ${(distanz / (returnAnimalEffectList()[racePonyIdListe[1]].toDouble() * 1000.0 / 3600.0) * 100 ).roundToInt().toDouble() / 100} sekunden überwindet, " +
                    "\n${returnNameAnimalList()[racePonyIdListe[0]]} wahr ${returnAnimalEffectList()[racePonyIdListe[0]].toDouble()} " +
                    "km/h snell und hat die strecke von $distanz Meter in ${(distanz / (returnAnimalEffectList()[racePonyIdListe[0]].toDouble() * 1000.0 / 3600.0) * 100 ).roundToInt().toDouble() / 100} sekunden überwindet.")

        }
        if (returnAnimalEffectList()[racePonyIdListe[0]].toDouble() > returnAnimalEffectList()[racePonyIdListe[1]].toDouble()){
            println("Pony mit Name ${returnNameAnimalList()[racePonyIdListe[0]]} hat das Rennen gewonnen.")
            println("${returnNameAnimalList()[racePonyIdListe[0]]} wahr ${returnAnimalEffectList()[racePonyIdListe[0]].toDouble()} " +
                    "km/h snell und hat die strecke von $distanz Meter in ${(distanz / (returnAnimalEffectList()[racePonyIdListe[0]].toDouble() * 1000.0 / 3600.0) * 100 ).roundToInt().toDouble() / 100} sekunden überwindet, " +
                    "\n${returnNameAnimalList()[racePonyIdListe[1]]} wahr ${returnAnimalEffectList()[racePonyIdListe[1]].toDouble()} " +
                    "km/h snell und hat die strecke von $distanz Meter in ${(distanz / (returnAnimalEffectList()[racePonyIdListe[1]].toDouble() * 1000.0 / 3600.0) * 100 ).roundToInt().toDouble() / 100} sekunden überwindet.")

        }
        if (returnAnimalEffectList()[racePonyIdListe[0]].toDouble() == returnAnimalEffectList()[racePonyIdListe[1]].toDouble()){
            println("${returnNameAnimalList()[racePonyIdListe[0]]} und ${returnNameAnimalList()[racePonyIdListe[1]]} wahren gleich schnell und zwar ${returnAnimalEffectList()[racePonyIdListe[0]].toDouble()} " +
                    "km/h snell und überwinterten die strecke von $distanz Meter in ${(distanz / (returnAnimalEffectList()[racePonyIdListe[1]].toDouble() * 1000.0 / 3600.0) * 100 ).roundToInt().toDouble() / 100} sekunden.")
        }
    }
}
