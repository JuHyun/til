package com.rtjvm.scala.oop.commands

trait Command {

  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"

  def emptyCommand: Command = (state: State) => state

  def incompletedCommand(name: String): Command = (state: State) => state.setMessage(name + "[incomplete command]")

  def from(input: String): Command = {
    val token: Array[String] = input.split(" ")

    if (input.isEmpty || token.isEmpty) emptyCommand
    else if (MKDIR.equals(token(0))) {
      if (token.length < 2) incompletedCommand(MKDIR)
      else new Mkdir(token(1))
    } else {
      new UnknownCommand
    }
  }

}
