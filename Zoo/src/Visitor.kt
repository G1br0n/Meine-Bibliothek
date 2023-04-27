import java.util.*

public open class Visitor {
    var name: String = TextObject.getVisitorNullNameText
    var age: Int = TextObject.getNullNumberInt

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    //Methode gibt, den Namen des Besuchers zusammen mit einer Begrüßung auf der Konsole aus.
    fun visitorIntroduce(){
        TextObject.getVisitorIntroduceText(name, age)
    }

}