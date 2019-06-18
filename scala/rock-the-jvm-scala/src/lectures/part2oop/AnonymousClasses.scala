package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous Class
  val animal: Animal = new Animal {
    override def eat: Unit = println("hahahahha")
  }

  println(animal.getClass)

  /**
    * equivalent with
    * val funnyAnimal: Animal = new AnonymousClasses$$anon$1
    */
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("anonymous class.....")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"I'm $name. How can I help you?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"I'm Jim. How can I be of service?")
  }

  println(jim.getClass)
}
