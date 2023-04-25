class DesertLocation {
     private var desertAnimalsList: List<String> = listOf(
          "Löwe",
          "Nashorn",
          "Emu",
          "Erdmännchen",
          "Gecko",
          "Geier",
          "Gepard",
          "Giraffe",
          "Gnu",
          "Gürteltier",
          "Heiliger Pillendreher",
          "Klapperschlange",
          "Leopard",
          "Rotes Riesenkänguru",
          "Schwarze Mamba",
          "Skorpion",
          "Strauß",
          "Wanderfalke",
          "Zebra"
     )


     fun getRandomDesertAnimal(): String {
          return desertAnimalsList.random()
     }
}
