package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greeting("Daniel")
  person.greeting()
  person.greeting2()

  val writer1 = new Writer("Rolling", "Stone", 2000)
  val imposter = new Writer("Rolling", "Stone", 2000)
  println(writer1.fullName)

  val novel = new Novel("Ring of the Rord", 2010, writer1)
  println(novel.authorAge())
  println(writer1 + " " + imposter)
  println(novel.isWrittenBy(writer1))
  println(novel.isWrittenBy(imposter))

  val copiedNovel = novel.copy(2012)
  println(copiedNovel)
  println(copiedNovel.authorAge())

  println("================counter=================")
  val counter = new Counter(10)
  println(counter.value)

  println(counter.increase.value)
  println(counter.increase.increase.value)
  println(counter.increase.increase.increase(10).increase(100).value)

  println(counter.decrease.value)
  println(counter.decrease.decrease.decrease.decrease.value)
  println(counter.decrease.decrease(5).value)
}

// Class Parameters are not FIELDs.
class Person(name: String = "Anonymous", val age: Int = 1) {
  val x = 2

  def greeting(name: String): Unit = println(s"${this.name} say: hi, $name")

  // overloading
  def greeting(): Unit = println(s"Hi, I'm a $name")

  def greeting2(): Unit = println(s"Hi, I'm a ${this.name}")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

/**
  * Novel and Writer
  *
  * Writer: first name, surname, year
  * - method: fullname
  *
  * Novel: name, year of release, author
  * - author age
  * - isWritternBy(author)
  * - copy(new year of release) = new instance of Novel
  *
  * Counter class
  *
  */

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {

  def fullName: String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge(): Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val value: Int) {

  def increase: Counter = new Counter(value + 1) // Immutability.

  def decrease: Counter = new Counter(value - 1)

  def increase(value: Int): Counter = {
    if (value <= 0) this
    else increase.increase(value - 1)
  }

  def decrease(value: Int): Counter = {
    if (value <= 0) this
    else decrease.decrease(value - 1)
  }
}
