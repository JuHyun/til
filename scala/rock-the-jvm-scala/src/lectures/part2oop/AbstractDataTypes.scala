package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract class
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  // Error, Can't instantiate.
  //  val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = "nomnom"

    override def eat(animal: Animal): Unit = s"I'm eating ${animal.creatureType}"
  }

  val dog = new Dog
  val crocodile = new Crocodile
  println(crocodile.eat(dog))

  // Traits vs Abstract Class
  // 1. traits can't have constructor parameters.
  // 2. multiple traits may be inherited by the same class.
  // 3. traits = behavior.
}
