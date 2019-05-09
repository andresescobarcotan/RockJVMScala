package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.files.Directory

class State(val root:Directory, val wd:Directory, val output: String) {

  var running : Boolean = true
  def isRunning: Boolean = running
  def setRunning(b:Boolean) = running = b

  def show: Unit =
    print(State.SHELL_TOKEN)
    println(output)

  def setMessage(message: String): State =
    State(root, wd, message)

}

object State {
  val SHELL_TOKEN = "$ "

  def apply(root: Directory, wd: Directory, output: String = ""): State =
    new State(root, wd, output)
}