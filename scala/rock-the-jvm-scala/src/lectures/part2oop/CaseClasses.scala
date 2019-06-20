package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. case class parameters are fields
  val jim = new Person("Jim", 20)

  println(jim.name)

  // 2. sensible toString
  // println(instance) == println(instance.toString) : syntactic sugar
  println(jim)
  println(jim.toString)

  // 3. equals and hashcode implemented out of the box.
  val jim2 = new Person("Jim", 20)
  println(jim == jim2)

  // 3-1. compare with just class
  class SimplePerson(name: String, age: Int)

  val simpleJim = new SimplePerson("Jim", 20)

  //  println(simpleJim.name) // error

  val simpleJim2 = new SimplePerson("Jim", 20)
  println(simpleJim != simpleJim2)

  // 4. case classes have handy copy method
  val olderJim = jim.copy(age = 40)
  println(olderJim)

  // 5. case classes have companion objects
  val thePerson = Person // automatically make companion objects.
  val marry = Person("Marry", 23) // == Person.apply("Marry", 23) apply method, factory method...

  // 6. case classes are serializable
  // Akka

  // 7. case classes have extractor patterns = case classes are used in PATTERN MATCHING.

  case object UnitedKingdom {
    def name: String = "The UK of Great British and North Island"
  }

  /**
    * Exercise: Expand MyList - use case classes and case objects
    */
}
