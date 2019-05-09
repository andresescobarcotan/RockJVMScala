package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.filesystem.State
trait Command {
  def apply(state: State): State
}

object Command {
  def emptyCommand: Command  = new  Command {
    override def apply(state: State): State = state
  }
  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(name + ": incomplete command!")
  }
  def from(input: String): Command ={
    val tokens:Array[String] = input.split(" ")

    if(input.isEmpty || tokens.isEmpty) emptyCommand
    else if (COMMAND_MKDIR.equals(tokens(0))){
      if (tokens.length < 2) incompleteCommand(COMMAND_MKDIR)
      else new Mkdir(tokens(1))
    }
    else if (COMMAND_LS.equals(tokens(0))) {
      new Ls
    } else if (COMMAND_PWD.equals(tokens(0))){
      new Pwd
    }

    else if (COMMAND_EXIT.equals(tokens(0))) new Exit()
    else  new UnknownCommand
  }
}

