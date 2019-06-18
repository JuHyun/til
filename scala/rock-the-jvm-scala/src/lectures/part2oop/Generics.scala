package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // Use the Type A

    def add[B >: A](element: B): MyList[B] = ???
  }

  // Companion Object
  object MyList {

    // Generic Method.
    def empty[A]: MyList[A] = ???

    // A: Cat
    // B: Dog => Animal
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  val emptyListOfIntegers = MyList.empty[Int]

  class MyMap[Key, Value]

  // Variance Problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  val animal: Animal = new Cat

  // 1. YES, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animalList: CovariantList[Animal] = new CovariantList[Cat]
//  animalList.add(new Dog) ??? HARD QUESTION ==> Returns a list of Animal

  // 2. NO, INVARIANCE
  class InvariantList[A]

  // Compile Error
  //  val invariantList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, No! CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Type
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  //  val newCage = new Cage(new Car) // run error!

  // Expand
}
