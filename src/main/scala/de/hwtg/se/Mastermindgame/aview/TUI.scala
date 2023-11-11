package de.hwtg.se.Mastermindgame.aview

import de.hwtg.se.Mastermindgame.controller.MasterMindControl
class TUI (fieldLength:Int = 4) {
  println("Willkommen bei Mastermind!")
  MasterMindControl(fieldLength).startGame();
}
