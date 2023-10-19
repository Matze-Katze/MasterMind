package MasterMind

import scala.io.StdIn.readLine
import scala.util.Random

class MastermindGame(fieldLength:Int = 4) {
  private val attempts = fieldLength * 3
  import Color._
  def startGame(): Unit = {

    println("Willkommen bei Mastermind!")
    println(s"Bitte Bringen Sie $fieldLength Farben aus ${Color.toString()} in richtige Position ein!!")
    val rndColor = randomColorGenerator()
    var currentAttempts = 1
    while (currentAttempts <= attempts)
      rndColor.foreach(c => print(c.toString +", \n"))

      val (colorposition, color) = checkGuess(rndColor, input())
      println(colorposition + ", " + color)
      currentAttempts += currentAttempts
      if (colorposition == fieldLength){
        println("Du hast gewonnen!!!!!")
        return
      } else
        val s = displayResult(colorposition, color)
        println(s)

    println("Sie haben verloren!!!!!!!!!!")

  }

  private def randomColorGenerator(): List[Color] = {
    val colorList = Color.values.toList
    val randomColors = (1 to fieldLength).map(_ => colorList(Random.nextInt(colorList.length))).toList
    randomColors
  }

  private def input() : List[Color] = {
    println(s"Bitte wählen Sie $fieldLength Farben aus ${Color.values.toString()}: ")
    readLine().split(", ").toList.map(i =>Color.withName(i))


  }
  private def checkGuess(rndColor:List[Color], input:List[Color]) : (Int, Int) = {
    val correctPosition = input.zip(rndColor).count{case (i, r) => i == r}
    println(rndColor.toSet.toString())
    val setG = rndColor.toSet

    var colorCounter: List[Int] = List()

    for (a <- setG) {
      val tmp = Math.min(rndColor.count(_ == a), input.count(_ == a))
      colorCounter = colorCounter :+ tmp
    }

    val correctColor = colorCounter.sum - correctPosition

    (correctPosition, correctColor)
  }

  private def displayResult(correctPosition: Int, correctColor: Int) = correctPosition + " in richtiger Position. \n"
                                                                      + correctColor + " in falscher Position. "
}
