package exercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // HOFs
  def foreach(f: A => Unit): Unit

  def sort(f: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = () // Unit Value

  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else Empty
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (tail.isEmpty) head + " "
    else head + " " + tail.printElements
  }

  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /**
    * [1, 2].flatMap(n => [n, n+1])
    * = [1, 2] ++ 2.flatMap(n => [n, n+1])
    * = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n+1])
    * = [1,2,2,3]
    **/
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /**
    * [1, 2] ++ [3,4,5]
    * = new Cons(1, [2] ++ [3,4,5])
    * = new Const(1, new Cons(2, Empty ++ [3,4,5]))
    * = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty))))
    **/
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    tail.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else new Cons(zip(h, list.head), tail.zipWith(list.tail, zip))
  }

  // ex.  [1,2,3](0)(+)
  // =    [2, 3](0+1)(+)
  // =    [3](0+1+2)(+)
  // =    [](0+1+2+3)(+)
  // =    (0+1+2+3) <-- fold of Empty = start
  // =    6
  override def fold[B](start: B)(operator: (B, A) => B): B = t.fold(operator(start, h))(operator)
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

  val greaterThanTwo: Int => Boolean = _ > 2

  println(list2.filter(greaterThanTwo))

  val doubled: Int => Int = _ * 2
  println(list2.map(doubled))

  println(list1 ++ list2)

  val expendElement: Int => MyList[Int] = (element: Int) => new Cons(element, new Cons(element + 1, Empty))

  println(list2.flatMap(expendElement))

  val clonedList2 = Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2 == clonedList2)

  println("================ HOFs ======================")
  clonedList2.foreach(println) // === clonedList2.foreach(x => println(x))

  val descending = (x: Int, y: Int) => y - x
  println(clonedList2.sort(descending))

  val anotherListOfInteger = new Cons(10, new Cons(11, new Cons(12, Empty)))
  val multiply = (x: Int, y: Int) => x * y
  println(list2.zipWith(anotherListOfInteger, multiply))

  println(list2.fold(100)(_ + _))

  /**
    * Example
    * 1. Expand MyList
    * - foreach method: A => Unit
    * [1,2,3].foreach(x => println(x))
    * - sort function ((A, A) => Int) => MyList
    * [1,2,3].sort((x,y) => y-x) = [3,2,1]
    * - zipWith (list, (A, A) => B)) => MyList[B]
    * [1,2,3].zipWith([4,5,6], x*y) => [1*4, 2*5, 3*6] =
    * - fold(start)(function) => a value
    * [1,2,3](0)(x+y) = 6
    */

  /**
    * 2.
    * - toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
    * - fromCurry(f: Int => Int => Int) => (Int => Int) => Int
    */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x, y)

  // example
  def superAdder: Int => Int => Int = toCurry(_ + _)

  def add4 = superAdder(4)

  println(add4(100))

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)

  // example
  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 100))


  /**
    * 3.
    * - compose(f, g) => x => f(g(x))
    * - andThen(f, g) => x => g(f(x))
    */

  // Function X
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def genericCompose[A, B, T](f: A => B, g: T => A): T => B = x => f(g(x))

  val add3: Int => Int = _ + 3
  val times3: Int => Int = _ * 3
  val composed = compose(add3, times3)
  println(composed(10))

  def andThen(f: Int => Int, g: Int => Int): Int => Int = x => g(f(x))

  def genericAndThen[A, B, C](f: A => B, g: B => C): A => C = x => g(f(x))

  val ordered = andThen(add3, times3)
  println(ordered(10))

}
