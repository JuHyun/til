package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOut(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name is hacked?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, I'm $name and I love $favoriteMovie."
  }

  val mary = new Person("Mary", "Inception")
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
}
