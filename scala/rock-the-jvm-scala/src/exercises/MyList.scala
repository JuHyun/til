package exercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

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

  val listOfString = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfString.toString)
}
