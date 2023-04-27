import java.io.File

class GetrankWare {
    //--------------------------------Variable--------------------------------------------------------------
    // Erstelle leere Listen für den gesamten Inhalt der Textdatei
    val getrankListe = mutableListOf<String>()

    // Erstelle leere Listen für jedes Element aus ID, Name, Preis, Gewicht und Bestand
    var idListe = mutableListOf<Int>()
    var nameListe = mutableListOf<String>()
    var priceListe = mutableListOf<Double>()
    var gewichtListe = mutableListOf<Int>()
    var bestandListe = mutableListOf<Int>()

    var indexReturn: Int = 0

    //-----------------------------Initialization--------------------------------------------------------------
    init {
        // Definiere den Pfad zur Getränkedatei und speichere sie als File in getrankeFile
        val getrankeFile: File = File("GetrankeHale/src/producte/getranke")

        // Erstelle eine Liste für jede Zeile aus der Getränkedatei
        getrankeFile.forEachLine { this.getrankListe.add(it) }

        /*
        Hier für jeden Index in der Liste splite ich den Text mit "leer zeichen" und speichere es separat in die entsprechende Liste
         */
        for (getrank in getrankListe) {
            val values = getrank.split(" ")

            val id = values[0].toInt()
            val name = values[1]
            val price = values[2].toDouble()
            val gewichtIn = values[3].toInt()
            val bestand = values[4].toInt()

            this.idListe.add(id)
            this.nameListe.add(name)
            this.priceListe.add(price)
            this.gewichtListe.add(gewichtIn)
            this.bestandListe.add(bestand)
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Methode druckt die gesamte Getränkeliste aus
    fun druckeGetrankWareListeAus() {
        for (i in idListe.indices) {
            println(
                "ID: ${idListe[i]} Name: ${nameListe[i]} Preis: ${priceListe[i]}€ Gewicht: ${gewichtListe[i]} " +
                        "Bestand: ${bestandListe[i]}"
            )
        }
    }

    //------------------------------------Methoden mit MutableList-Return-------------------------------------------------
    fun gibGetrankListeZuruck(): MutableList<String> {
        return getrankListe
    }   // Gibt die Getränkeliste zurück

    fun gibIdListeZuruck(): MutableList<Int> {
        return idListe
    }   // Gibt die ID-Liste zurück

    fun gibNameListeZuruck(): MutableList<String> {
        return nameListe
    }   // Gibt die Namenliste zurück

    fun gibPreisListeZuruck(): MutableList<Double> {
        return priceListe
    }   // Gibt die Preisliste zurück

    fun gibGewichtListeZuruck(): MutableList<Int> {
        return gewichtListe
    }    // Gibt die Gewichtsliste zurück

    fun gibBestandListeZuruck(): MutableList<Int> {
        return bestandListe
    }   // Gibt die Bestandsliste zurück

    //---------------------------------Suchen und Drucken Methoden----------------------------------------------------------
    // Suche mit readln() nach dem Namen eines Produkts und gebe diese Information mit Hilfe des Listen-Index aus
    fun sucheMitNameUndDruckeProduktAus() {
        println("Bitte geben Sie den Produktnamen ein")
        val eingabe = readLine()

        // Wenn die Eingabe in der Liste vorhanden ist:
        if (nameListe.contains(eingabe)) {
            val nameIndex = nameListe.indexOf(eingabe)

            /*
            // Beispiel Ausgabe in der Console
            ID: 110011 Name: Zitronenlimo Preis: 1.49 € Gewicht: 500 Bestand: 5
            */
            println(
                "ID: ${idListe[nameIndex]} Name: ${nameListe[nameIndex]} Preis: ${priceListe[nameIndex]}€ " +
                        "Gewicht: ${gewichtListe[nameIndex]} Bestand: ${bestandListe[nameIndex]}"
            )
        } else {
            println("Das Produkt mit dem Namen $eingabe wurde nicht gefunden.")
        }
    }

    // Suche mit readLine() nach der ID eines Produkts und gebe diese Information mit Hilfe des Listen-Index aus
// und überprüfe die Eingabe, ob es eine Zahl ist.
    fun sucheMitIDUndDruckeProduktAus() {
        println("Bitte geben Sie die ID des Produkts ein")

        // Platzhalter
        var eingabe: Int

        // Versuche, readLine() in Int umzuwandeln, sonst starte die Methode neu.
        try {
            // Definiere Eingabe mit readLine()
            eingabe = readLine()!!.toInt()

            // Wenn die Eingabe in der Liste vorhanden ist:
            if (idListe.contains(eingabe)) {
                // Speichere den Index von contain in idIndex
                val idIndex = idListe.indexOf(eingabe)

                /*
                // Beispiel Ausgabe in der Console
                ID: 110011 Name: Zitronenlimo Preis: 1.49€ Gewicht: 500 Bestand: 5
                */
                println(
                    "ID: ${idListe[idIndex]} Name: ${nameListe[idIndex]} Preis: ${priceListe[idIndex]}€ " +
                            "Gewicht: ${gewichtListe[idIndex]} Bestand: ${bestandListe[idIndex]}"
                )

                // Andernfalls benachrichtige, dass die ID nicht gefunden wurde und starte die Methode neu
            } else {
                println("Die eingegebene ID $eingabe wurde nicht gefunden.")
                sucheMitIDUndDruckeProduktAus()
            }

            // Fange hier den Fehler ab und starte die Methode neu
        } catch (ex: Exception) {
            println("Die Eingabe muss eine Zahlenreihe sein")
            sucheMitIDUndDruckeProduktAus()
        }
    }

    //---------------------------------Methoden für Kaufen-------------------------------------------------------------------
    fun kaufen(): Int {
        var id = -1
        var menge = 0

        // Eingabe der ID oder des Namens des Getränks
        println("Bitte geben Sie die ID oder den Namen des Getränks ein, das Sie kaufen möchten:")
        val eingabe = readLine()

        // Überprüfe, ob die Eingabe eine Zahl oder ein Text ist
        try {
            if (eingabe?.toIntOrNull() != null) {
                id = eingabe.toInt()
                // Überprüfe, ob das Getränk mit der angegebenen ID in der Liste vorhanden ist
                if (!idListe.contains(id)) {
                    println("Das gefunden.")
                    return kaufen()
                }

                val index = idListe.indexOf(id)
                // Eingabe der Menge
                println("Sie möchten also ${nameListe[index]} mit ID: ${idListe[index]} für ${priceListe[index]} € kaufen? \nEs sind ${bestandListe[index]} im Sortiment. \nDann bitte geben Sie die Menge ein, die Sie kaufen möchten:")
                menge = readLine()!!.toInt()
                this.indexReturn = index
            } else {
                // Überprüfe, ob das Getränk mit dem angegebenen Namen in der Liste vorhanden ist
                if (!nameListe.contains(eingabe)) {
                    println("Das Getränk mit dem Namen $eingabe wurde nicht gefunden.")
                    return kaufen()
                }

                val index = nameListe.indexOf(eingabe)
                id = idListe[index]

                // Eingabe der Menge
                println("Sie möchten also ${nameListe[index]} mit ID: ${idListe[index]} für ${priceListe[index]} € kaufen? \nEs sind ${bestandListe[index]} im Sortiment. \nDann bitte geben Sie die Menge ein, die Sie kaufen möchten:")
                menge = readLine()!!.toInt()
                this.indexReturn = index
            }

            // Überprüfe, ob genug Getränke im Bestand vorhanden sind
            val index = idListe.indexOf(id)
            if (menge > bestandListe[index]) {
                println("Es sind nicht genug Getränke im Bestand vorhanden.")
                return kaufen()
            }

            // Aktualisiere den Bestand
            bestandListe[index] -= menge

            // Öffne die Datei im Schreibmodus
            val writer = File("GetrankeHale/src/producte/getranke").writer()

            // Schreibe den Inhalt der Listen in die Datei
            for (i in idListe.indices) {
                writer.write("${idListe[i]} ${nameListe[i]} ${priceListe[i]} ${gewichtListe[i]} ${bestandListe[i]}\n")
            }

            // Schließe den Writer
            writer.close()

            // Gebe eine erfolgreiche Meldung aus
            println("$menge ${nameListe[index]} wurden erfolgreich gekauft.")


        } catch (ex: Exception) {
            println("Die Eingabe muss eine Zahl sein.")
            kaufen()
        }
        return this.indexReturn

    }

    private fun produktNochmalKaufeJaOderNein() {
        var weiterKaufen = true
        val warenkorb = mutableListOf<String>()
        val preisListe = mutableListOf<Double>()

        val getrankWare = GetrankWare()

        while (weiterKaufen) {

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
        }

        // Berechne die Gesamtrechnung
        var gesamtPreis = 0.0
        for (preis in preisListe) {
            gesamtPreis += preis
        }


        // Gebe den Warenkorb und die Gesamtrechnung aus
        println("Ihr Warenkorb:")
        for (produkt in warenkorb) {
            println(produkt)
        }
        println("Gesamtpreis: $gesamtPreis €")
    }
}
