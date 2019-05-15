package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}
import com.rtjvm.scala.oop.filesystem.State

abstract  class CreateEntry(entryName: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(entryName)){
      state.setMessage("Entry " + entryName + " already exists! ")
    } else if (entryName.contains(Directory.SEPARATOR)){
      state.setMessage(entryName + " must not contain separators!")
    } else if (checkIllegal(entryName)){
      state.setMessage(entryName + ": illegal entry name!")
    } else {
      doCreateEntry(state, entryName)
    }
  }

  def checkIllegal(str: String):Boolean = {
    entryName.contains(".")
  }

  def doCreateEntry(state: State, name:String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry):Directory = {
      if(path.isEmpty) currentDirectory.addEntry(newEntry)
      else{
        val oldEntry = currentDirectory.findEntry(path.head)
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry.asDirectory, path.tail, newEntry))
      }

    }

    val wd = state.wd
    val fullPath = wd.path
    val allDirsInPath = wd.getAllFoldersInPath
    val newEntry: DirEntry = createSpecificEntry(state)
    val newRoot = updateStructure(state.root, allDirsInPath,newEntry)
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

  def createSpecificEntry(state: State): DirEntry


}
