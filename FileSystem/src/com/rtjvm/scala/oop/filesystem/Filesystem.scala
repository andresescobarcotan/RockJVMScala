package com.rtjvm.scala.oop.filesystem
import java.util.Scanner

import com.rtjvm.scala.oop.commands.Command
import com.rtjvm.scala.oop.files.Directory


object Filesystem extends  App{

  val root = Directory.ROOT
 /*
  var state = State(root, root)
  val scanner = new Scanner(System.in)


  while(state.isRunning) {
    state show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
  */
  // [1,2,3,4]

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
     currentState.show
     Command.from(newLine).apply(currentState)
  })
}
