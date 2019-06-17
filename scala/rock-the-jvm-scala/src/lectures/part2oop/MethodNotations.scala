package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOut(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name is hacked?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, I'm $name and I love $favoriteMovie."

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(subject: String): String = s"$name learns $subject"

    def learnScala: String = this learns "Scala"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times."
  }

  val mary = new Person("Mary", "Inception", 20)
  println(mary.likes("Inception"))

  // infix notation or operator notation
  println(mary likes "Inception")

  val tom = new Person("Top", "Fight Club")
  println(tom.hangOut(mary))
  println(tom hangOut mary)

  println(tom + mary)

  // All Operators are Methods.
  // Akka actors have ! ?.
  println(1 + 2)
  println(1.+(2))

  // Prefix Notation.
  val x = -1 // equivalent 1.unary_-
  val y = 1.unary_-
  println(x + " " + y)

  // unary_prefix only works with + - ~ !
  println(!mary)
  println(mary.unary_!)

  // Postfix Notation.: parameter 없이만 가능함.
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply()) // equivalent mary()
  println(mary())

  println((mary + "the rockstar").name)
  println((mary + "the rockstar")())

  val olderMary = (+mary)
  println(olderMary.age)

  println(olderMary.learns("Scala"))

  println(olderMary learnScala)

  println(mary.apply(2))
}
