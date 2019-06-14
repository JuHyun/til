class Stack[+T] {
  def push[S >: T](elem: S): Stack[S] = new Stack[S] {
    override def top: S = elem

    override def pop: Stack[S] = Stack.this

    override def toString: String =
      elem.toString + " " + Stack.this.toString
  }

  def top: T = sys.error("no element on stack")

  def pop: Stack[T] = sys.error("no element on stack")

  override def toString: String = ""
}

var s: Stack[Any] = new Stack().push("hello")
s = s.push(new Object())
s = s.push(7)
s

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal

def printAnimalNames(animals: List[Animal]): Unit = {
  animals.foreach { animal => println(animal.name) }
}

printAnimalNames(List(Cat("Tom"), Cat("Whiskers"), Dog("Rext")))

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(animal: Animal): Unit =
    println(s"The animal's name is $animal.name")
}

class CatPrinter extends Printer[Cat] {
  override def print(cat: Cat): Unit =
    println(s"The cat's name is $cat.name")
}


val myCat: Cat = Cat("Boots")

def printMyCat(printer: Printer[Cat]): Unit = {
  printer.print(myCat)
}

val catPrinter: Printer[Cat] = new CatPrinter
val animalPrinter: Printer[Animal] = new AnimalPrinter

printMyCat(catPrinter)
printMyCat(animalPrinter)

class Container[A](value: A) {
  private var _value: A = value
  def getValue:  A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

val catContainer: Container[Cat] = new Container(Cat("Felix"))
// Container가 invariant라서 오류 발생함.
//val animalContainer: Container[Animal] = catContainer
//animalContainer.setValue(Dog("Spot"))
val cat: Cat = catContainer.getValue
