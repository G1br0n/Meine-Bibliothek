import animalClasses.Animal
import animalClasses.Pony
import kotlin.io.path.Path
import kotlin.math.round



//TODO Hier habe ich alle texte und alle text variable und par funktionen aus der Classen Animal,Cow,Sheep,Chicken,Visitor
// Ist das richtige ansatz oder eher falsche das man alle texte in eine datei packt ???
object TextObject:Animal() {

    val getPonyRandomDecisionListe = listOf<String>("Zucker","Karotte")
    var weightAddition: Double = 1.02
    var nothingText = ""
    var getGenderMaleText = "Männlich"
    var getNullNumberInt = 0
    var getTrueText = "true"

    var test = Path("src/main/kotlin/animalListe/animalListe")

    var getTypChicken = "Huhn"
    var getTypSheep = "Schaf"
    var getTypPony = "Pony"
    var getTypCow = "Kuh"

    //TODO: Leider kann ich diesen text pfad nicht übergeben :-( so das das richtig funktioniert
    fun getAnimalsFilePfad(): String {
        return "src/main/kotlin/animalListe/animalListe"
    }


    fun randomVisitor() {
        var randomNameListe = listOf<String>("Mia", "Noah", "Emma", "Liam", "Ava", "William", "Sophia", "Oliver", "Isabella", "Elijah")
        var randomNameListe2 = listOf<String>("Schmidt", "Bauer", "Meyer", "Wagner", "Schulz", "Becker", "Hoffmann", "Müller", "Schäfer", "Koch")
        var randomAge = (18..99)
        println("\nHallo ich heisse ${randomNameListe.random()} ${randomNameListe2.random()} und ich bin ${randomAge.random()} Jahre alt. Ich würde gerne in ihre Streichel Zoo rein kommen.")

    }


    fun getCowMilkingStatusText(genderOfCow: String,statusMilkingOfTheCow: Boolean, typOfCow:String, nameOfCow:String, nameVisitor: Visitor){
        var textAddition = ""
        var textAddition2 = ""

        if (genderOfCow == "Männlich") textAddition = " Da das Tier Männlich ist."
        if (genderOfCow == "Weiblich") textAddition2 = " jetzt"
        if(statusMilkingOfTheCow) println("$typOfCow mit Name $nameOfCow wurde von ${nameVisitor.name.replace("_"," ")} gemolken.")
        if(!statusMilkingOfTheCow) println("${nameVisitor.name.replace("_"," ")} versucht $typOfCow mit Name $nameOfCow Zu melken.$nameOfCow kann mann$textAddition2 nicht melken.$textAddition")
    }

    var getVisitorNullNameText = "nullVisitorName"

//----------------Texte für PettingZoo Class----------------------------------------------------------------------------------

    fun getPrintAnimalIndexAndName(cowIdList: MutableList<Int>){
        for (i in cowIdList) {
            println("Index: $i. Typ: ${returnAnimalTypeList()[i]}. Name: ${returnNameAnimalList()[i]}. Geschlecht: ${returnGenderAnimalList()[i]}")
        }
    }
//----------------Texte für Visitor Class-------------------------------------------------------------------------------
    fun getVisitorIntroduceText(name:String, age: Int){
        println("Hallo mein Name ist $name und ich bin $age Jahre alt.")
    }
//----------------Texte für Sheep Class---------------------------------------------------------------------------------
    fun getSheepCleanFurText(typOfSheep: String,nameOfSheep : String){
        println("Das Fell von $typOfSheep mit Name $nameOfSheep wurde gereinigt.")
    }

    fun getSheepSaveFileReaderText(i: Int): String{
        return "${returnNameAnimalList()[i].replace(" ","_")} ${returnAnimalTypeList()[i]} ${returnWeightAnimalList()[i]} ${returnAgeAnimalList()[i]} ${returnGenderAnimalList()[i]} ${returnAnimalNoiseList()[i]} ${returnAnimalEffectList()[i]}\n"

    }
//----------------Texte für Pony Class----------------------------------------------------------------------------------
    fun getPonyRidesText(nameOfPony: String, nameOfVisitor: Visitor){
        var speedOfPony = Pony(nameOfPony).speedOfPony
        println("${nameOfVisitor.name.replace("_"," ")} reitet den $nameOfPony mit Geschwindigkeit von ${speedOfPony.toString().replace(".", ",")} km/h.")
    }
//----------------Texte für Animal Class--------------------------------------------------------------------------------
    fun getAnimalMakeFedDecisionText(decisionIntern: String): String{
        return "\nDas Tier hat sich für $decisionIntern Entschieden"
    }

    fun getAnimalMakeFedText(nameAnimal: String,nameVisitor: Visitor, oldWeight: Double,animalWeightList: MutableList<Double>,animaNameList: MutableList<String>, textAddition: String ) {
        println("${returnAnimalTypeList()[animaNameList.indexOf(nameAnimal)]} mit Name $nameAnimal wird von ${nameVisitor.name.replace("_"," ")} gefüttert. $nameAnimal wiegte ${oldWeight.toString().replace(".",",")} " +
                "jetzt ${(round(animalWeightList[animaNameList.indexOf(nameAnimal)] * 100) / 100).toString().replace(".",",")}! $textAddition")
    }

    fun getAnimalMakeStrokeText(nameAnimal: String,nameVisitor: Visitor, animalNoiseList: MutableList<String>,animaNameList: MutableList<String>){
        println("${returnAnimalTypeList()[animaNameList.indexOf(nameAnimal)]} namens $nameAnimal wird von ${nameVisitor.name.replace("_"," ")} gestreichelt. $nameAnimal \"${animalNoiseList[animaNameList.indexOf(nameAnimal)]}\"!")
    }

    fun getAnimalMovementText(nameAnimal: String, animaNameList: MutableList<String>, animalNoiseList: MutableList<String>){
        println("$nameAnimal läuft durchs Gehege. $nameAnimal \"${animalNoiseList[animaNameList.indexOf(nameAnimal)]}\"")
    }

    fun getAnimalMakeNoiseText(animalTypeList:MutableList<String>, nameAnimal: String, animaNameList: MutableList<String>, animalNoiseList: MutableList<String>){
        println("${animalTypeList[animaNameList.indexOf(nameAnimal)]} mit Name $nameAnimal macht ein Geräusch. Das Tier \"${animalNoiseList[animaNameList.indexOf(nameAnimal)]}\"!")
    }

    fun getAnimalSaveText(i: Int): String {
        return "${returnNameAnimalList()[i].replace(" ","_")} ${returnAnimalTypeList()[i]} ${round(returnWeightAnimalList()[i] * 100) / 100} ${returnAgeAnimalList()[i]} ${returnGenderAnimalList()[i]} ${returnAnimalNoiseList()[i]} ${returnAnimalEffectList()[i]}\n"
    }
}
