package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}

class Mkdir(name: String) extends Command {

  def checkIllegal(name: String): Boolean =
    name.contains(".")

  def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = ???

  def doMkdir(state: State, name: String): State = {
    val wd = state.wd

    val allDirsInPath = wd.getAllFoldersInPath

    val newDir = Directory.emtpy(wd.path, name)

    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }


  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(name + " already exists.")
    } else if (name.contains(Directory.SEPERATOR)) {
      state.setMessage(name + " must not have seperator.")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": Illegal name entry.")
    } else {
      doMkdir(state, name)
    }
  }
}
