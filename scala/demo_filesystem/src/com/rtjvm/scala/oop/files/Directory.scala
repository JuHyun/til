package com.rtjvm.scala.oop.files

class Directory(override val parentPath: String, override val name: String, val content: List[DirEntry])
  extends DirEntry(parentPath, name) {

  def findDescendant(allDirsInPath: List[String]): Directory = ???

  def hasEntry(name: String): Boolean = ???

  def getAllFoldersInPath: List[String] =
    path.substring(1).split(Directory.SEPERATOR).toList
}

object Directory {
  val SEPERATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.emtpy("", "")

  def emtpy(parentPath: String, name: String): Directory =
    new Directory(parentPath, name, List())
}
