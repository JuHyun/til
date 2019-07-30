package lectures.part1ad

import scala.util.Try

object DarkSugars extends App {

  // syntax sugar #1. method with single param.
  def singleArgMethod(arg: Int): String = s"$arg little darks..."

  val descritpion: String = singleArgMethod {
    // write some complex code
    100
  }

  val aTryInstance = Try { // java try { ... }
    throw new RuntimeException
  }

  List(1, 2, 3).map { x =>
    x + 1
  }

  // syntax sugar #2. single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val funkyInstance: Action = (x: Int) => x + 1 // magic

  // example: Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello, scala")
  })

  val aSweeterThread = new Thread(() => println("sweet, scala!"))

  abstract class AnAbstractType {
    def implemented: Int = 23

    def f(x: Int): Unit
  }

  val anAbstractType: AnAbstractType = new AnAbstractType {
    override def f(x: Int): Unit = println("sweet")
  }
  val anAbstractTypeInstance: AnAbstractType = (x: Int) => println("sweet")

  // syntax sugar #3. the :: and #:: methods are special
  val prependedList = 2 :: List(3, 4)
  println(prependedList)
  // 2.::(List(3,4))
  // List(3,4).::2
  // ?!

  // scala spec: last char decides associativity of method
  val list1 = 1 :: 2 :: 3 :: List(4, 5)
  println(list1)
  val list2 = List(4, 5).::(3).::(2).::(1) // equivalent
  println(list2)

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]
  println(myStream)

  // syntax sugar #4: multi-word method naming

}
