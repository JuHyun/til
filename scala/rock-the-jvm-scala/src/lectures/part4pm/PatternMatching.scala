package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  val random = new Random()
  val x = random.nextInt(10)

  val description: String = x match {
    case 1 => "the ONE"
    case 2 => "the DOUBLE"
    case 3 => "the TRIPLE"
    case 4 => "the QUARD"
    case _ => "Something Else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // Decompose values
  case class Person(name: String, age: Int)

  val bob = new Person("Bob", 25)

  val greeting: String = bob match {
    case Person(n, a) if a < 20 => s"Hi, I'm $n and $a years old. I am a teenager."
    case Person(n, a) => s"Hi, I'm $n and $a years old."
    case _ => "I don't know who i am."
  }

  println(greeting)

  // Pattern Matching on sealed hierchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = new Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of $someBreed breed.")
  }

  // match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  val isEvenCondition = if (x % 2 == 0) true else false
  val isEvenNormal = x % 2 == 0

  // WHY? use Pattern Matching?

  /**
    * Exercise
    */
  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Product(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = expr match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1, e2) => {
      def maybeShowParentheses(e: Expr) = e match {
        case Product(_, _) => show(e)
        case Number(_) => show(e)
        case Sum(_, _) => "(" + show(e) + ")"
      }

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  val sum5 = Sum(Number(2), Number(3))
  println(show(sum5))
  val product10 = Product(sum5, Number(10))
  println(show(product10))
  println(show(Product(Sum(Number(2), Number(3)), Sum(Number(10), Number(10)))))
  println(show(Sum(Sum(Number(1), Number(2)), Product(Number(1), Number(0)))))

}
