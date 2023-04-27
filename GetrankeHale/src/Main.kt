fun main() {
    println()
    var weiterKaufen = true
    val warenkorb = mutableListOf<String>()
    val preisListe = mutableListOf<Double>()

    val getrankWare = GetrankWare()

    do {
        //TODO: getrankWare.druckeGetrankWareListeAus()
        val gekaufterIndex = getrankWare.kaufen()

        // Füge das gekaufte Produkt zum Warenkorb hinzu
        warenkorb.add(getrankWare.gibNameListeZuruck()[gekaufterIndex])
        preisListe.add(getrankWare.gibPreisListeZuruck()[gekaufterIndex])

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
        gesamtPreis += GetrankWare().gibPreisListeZuruck()[GetrankWare().gibNameListeZuruck()
            .indexOf(warenkorb[indexFor])]
        indexFor++
    }

    // Gebe den Warenkorb und die Gesamtrechnung aus
    println("Ihr Warenkorb:")
    for (produkt in warenkorb) {
        println(produkt)
    }
    println("Gesamtpreis: $gesamtPreis €")
}
