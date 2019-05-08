package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

class Exit extends Command {
  val NICE_EXIT = "Good Bye!"
  override def apply(state: State): State = {
    state setMessage NICE_EXIT
    state setRunning false
    state
  }


}
