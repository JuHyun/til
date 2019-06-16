package lectures.part1basics

object CallByNameCallByValue extends App {
  def callByValue(x: Long): Unit = {
    println("by value x = " + x)
    println("by value x = " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by name x = " + x)
    println("by name x = " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)


  // stack over flow...
//  printFirst(infinite(), 34)

  printFirst(34, infinite())
}
