package lectures.part1ad

import lectures.part1ad.Recap.Person

import scala.annotation.tailrec

object Recap extends App {

  val aCondtion: Boolean = false
  val aConditionedVal: Int = if (aCondtion) 100 else 0
  // instructions vs expressions

  // compiler infers the return type for us
  val aCodeBlock = {
    if (aCondtion) 100
    0
  }

  // Unit == void
  val aPrint = println("hello, scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  @tailrec def aFactorial(n: Int, accumulation: Int): Int =
    if (n <= 1) accumulation
    else aFactorial(n - 1, n * accumulation)

  println(aFactorial(1, 1))
  println(aFactorial(2, 1))
  println(aFactorial(3, 1))
  println(aFactorial(4, 1))

  // object-oriented programming
  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // natural language

  // anonymous class
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!!")
  }

  // generics
  abstract class MyList[+A]

  object MyList // singleton and companion

  // exceptions and try/catch/finally
//  val throwsException = throw new RuntimeException // Nothing
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => " I caught the Exception"
  } finally {
    println("some logs")
  }

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementer(1)

  val anonymousIncrementer: Int => Int = (x: Int) => x + 1
  anonymousIncrementer(1)
  List(1, 2, 3).map(anonymousIncrementer) // HOF
  // map, flatmap, filter

  // for-comprehention
  val pairs = for {
    nums <- List(1, 2, 3)
    strings <- List("abc", "zzz", "dfefdf")
  } yield strings + '-' + nums
  println(pairs)

  // scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Onyou" -> 10,
    "Eujean" -> 4
  )
  aMap.foreach(p => println(p._1 + "is " + p._2 + " years old."))

  // Collections: Options, Try
  val aOption = Some(10)

  // pattern matching
  val x = 2
  x match {
    case 1 => "first"
    case 2 => "second"
    case _ => "other"
  }

  case class Person(name: String, age: Int)
  val aPerson = new Person("Onyou", 10)
  val greeting = aPerson match {
    case Person(name, _) => s"Hello, $name"
  }
  println(greeting)

  // all the patterns
}
