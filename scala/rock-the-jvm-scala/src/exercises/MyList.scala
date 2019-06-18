package exercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransform[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransform[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: MyTransform[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransform[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
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

  override def map[B](transformer: MyTransform[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  /**
    * [1, 2].flatMap(n => [n, n+1])
    * = [1, 2] ++ 2.flatMap(n => [n, n+1])
    * = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n+1])
    * = [1,2,2,3]
    **/
  override def flatMap[B](transformer: MyTransform[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /**
    * [1, 2] ++ [3,4,5]
    * = new Cons(1, [2] ++ [3,4,5])
    * = new Const(1, new Cons(2, Empty ++ [3,4,5]))
    * = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty))))
    **/
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

trait MyPredicate[-A] {
  def test(element: A): Boolean
}

trait MyTransform[-A, B] {
  def transform(element: A): B
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

  val greaterThanTwo = new MyPredicate[Int] {
    def test(element: Int): Boolean = element > 2
  }

  println(list2.filter(greaterThanTwo))

  val doubled = new MyTransform[Int, Int] {
    def transform(element: Int): Int = element * element
  }
  println(list2.map(doubled))

  println(list1 ++ list2)

  val expendElement = new MyTransform[Int, MyList[Int]] {
    def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  }

  println(list2.flatMap(expendElement))
}
