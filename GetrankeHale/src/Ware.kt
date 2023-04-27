open class Ware {
    var id: Int = 0
    var name: String = ""
    var price: Double = 0.0
    var bestand: Int = 0


    constructor(id: Int, name: String, price: Double, bestand: Int) {
        this.name = name
        this.price = price
        this.bestand = bestand
        this.id = id
    }

    fun verkaufen(){
        bestand--
    }

}