package lectures.part2oop

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "Wild"

    def eat = println("Nom Nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch
  println(cat.creatureType)

  // Constructors.
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  //  class Dog extends Animal {
  //    override val creatureType: String = "domestic"
  //    override def eat: Unit = println("crunch crunch")
  //  }
  class Dog(override val creatureType: String) extends Animal {
    override def eat: Unit = {
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // Type substitution: (broad: Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Overriding vs Overloading

  // Super

  // Preventing overriding
  // 1 - final on member
  // 2 - final on the entire class
  // 3 - seal the class = extend in the Same File, prevent extension in OTHER Files.
}
