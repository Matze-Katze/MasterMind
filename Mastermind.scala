package projekt

object Mastermind {
  def main(args: Array[String]): Unit = {
    import scala.io.StdIn.readLine
    import scala.util.Random

    // Dein String-Array mit 6 Elementen
    val meinArray = Array("R", "G", "B", "W", "S")

    // Die Anzahl der Elemente, die du zufällig auswählen möchtest
    val anzahlAuswahl = 3

    // Eine leere Liste, um die ausgewählten Elemente zu speichern
    var zufaelligeFarben = List[String]()

    // Verwende eine Schleife, um zufällige Indizes zu generieren und die Elemente auszuwählen
    while (zufaelligeFarben.length < anzahlAuswahl) {
      val randomIndex = Random.nextInt(meinArray.length)
      val eineFarbe = meinArray(randomIndex)
      if (!zufaelligeFarben.contains(eineFarbe)) {
        zufaelligeFarben = zufaelligeFarben :+ eineFarbe
      }
    }

    // Die ausgewählten Elemente anzeigen
    zufaelligeFarben.foreach(print)

    println()

    var versuchAnzahl = 0

    while (versuchAnzahl < 10){
      var eingabe = readLine("Geben Sie R, G, B, W, S: ").split(" ")

      for (z <- zufaelligeFarben){

        if (eingabe.contains(z))
          {
            if (zufaelligeFarben.indexOf(z) == eingabe.indexOf(z)) println("Hit")

          }

      }
    }
    }





}
