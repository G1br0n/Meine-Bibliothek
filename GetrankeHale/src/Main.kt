
import kotlin.math.round


fun main() {
    println()
    var weiterKaufen = true
    val warenkorb = mutableListOf<String>()
    val preisListe = mutableListOf<Double>()
    var mengeListe = mutableListOf<Int>()

    val getrankWare = GetrankWare()

    do {

        //TODO: getrankWare.druckeGetrankWareListeAus()
        val (gekaufterIndex, gekaufteMenge) = getrankWare.kaufen()

        // Füge das gekaufte Produkt zum Warenkorb hinzu
        warenkorb.add(getrankWare.gibNameListeZuruck()[gekaufterIndex])
        preisListe.add(getrankWare.gibPreisListeZuruck()[gekaufterIndex])
        mengeListe.add(gekaufteMenge)

        // Frage den Benutzer, ob er weitere Produkte kaufen möchte
        println("Möchten Sie weitere Produkte kaufen? Ja/Nein")
        val antwort = readLine()!!.lowercase()

        if (antwort == "ja") {
            weiterKaufen = true
        } else if (antwort == "nein") {
            weiterKaufen = false
        } else {
            println("Ungültige Eingabe. Bitte antworten Sie mit 'Ja' oder 'Nein'.")
        }
    } while (weiterKaufen)

    // Berechne die Gesamtrechnung
    var gesamtPreis = 0.0
    var indexFor = 0

    for (preis in preisListe) {
        gesamtPreis += preisListe[indexFor] * mengeListe[indexFor]
        indexFor++
    }
    indexFor = 0

    var indexForWarenkorb = 0
    // Gebe den Warenkorb und die Gesamtrechnung aus
    println("\nIhr Warenkorb:")
    for (produkt in warenkorb) {
        println("Produkt: $produkt Menge:${mengeListe[warenkorb.indexOf(produkt)]} PreisStk:${preisListe[warenkorb.indexOf(produkt)]}")
    }
    indexForWarenkorb = 0
    println("Gesamtpreis: ${round(gesamtPreis * 100) / 100} €")
}
