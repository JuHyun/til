package lectures.part2oop

object Objects {

  // SCALA doesn't have CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level fucntionality
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method.
    //    def from(method: Person, father: Person): Person = new Person("Bobbie")
    def apply(method: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // COMPANION


  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = Singleton Instance
    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val marry = new Person("Marry")
    val tom = new Person("Tom")
    println(marry != tom)

    //  val bobby = Person.from(marry, tom)
    //  val bobby = Person.apply(marry, tom) // equivalent to Person(marry, tom)
    val bobby = Person(marry, tom)

    // Scala Application = Scala object with
    // def main(args: Array[String]): Unit
  }

}
