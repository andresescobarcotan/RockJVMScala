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
  def executeCommand(tokens:Array[String] ): Command ={
      tokens(0) match  {
      case COMMAND_MKDIR =>
        if (tokens.length < 2) incompleteCommand(COMMAND_MKDIR)
        else new Mkdir(tokens(1))
      case COMMAND_LS =>
        new Ls
      case COMMAND_PWD =>
        new Pwd
      case COMMAND_TOUCH =>
        if (tokens.length < 2) incompleteCommand(COMMAND_TOUCH)
        else new Touch(tokens(1))
      case COMMAND_CD =>
        if (tokens.length < 2) incompleteCommand(COMMAND_CD)
        else new Cd(tokens(1))
      case COMMAND_RM =>
        if (tokens.length < 2) incompleteCommand(COMMAND_RM)
        else new Rm(tokens(1))
      case COMMAND_ECHO =>
        if (tokens.length < 2) incompleteCommand(COMMAND_ECHO)
        else new Echo(tokens.tail)
      case COMMAND_CAT =>
        if (tokens.length < 2) incompleteCommand(COMMAND_CAT)
        else new Cat(tokens(1))
      case COMMAND_EXIT => new Exit()
    }
  }

  def from(input: String): Command ={
    val tokens:Array[String] = input.split(" ")

    if(input.isEmpty || tokens.isEmpty) emptyCommand
    else if (ListCommands.contains(tokens(0))) executeCommand(tokens)
    else new UnknownCommand
  }
}

