package exercises

abstract class MyList {

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String = {
    if (tail.isEmpty) head + " "
    else head + " " + tail.printElements
  }
}

object ListTest extends App {
  val list1 = new Cons(1, Empty)
  println(list1.head)

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail.head)

  println(list2.isEmpty)

  println(list2.add(4).head)

  // polymorphic call
  println(list2.toString)

  val empty = Empty
  println(empty.isEmpty)
  println(empty.toString)
}
