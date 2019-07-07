class SomeClass {

  def printFileName() = {
    println(SomeClass.HIDDEN_FIELNAME)
  }
}

object SomeClass {
  private val HIDDEN_FIELNAME = "/tmp/system/abc.txt"

  def apply(): SomeClass = new SomeClass
}

val someClass = SomeClass()
someClass.printFileName()


class Person {
  var name = ""
  var age = 0
}

object Person {
  def apply(name: String): Person = {
    var p = new Person
    p.name = name
    p
  }

  def apply(name: String, age: Int): Person = {
    var p = new Person
    p.name = name
    p.age = age
    p
  }
}

val zenMaster = List(
  Person("Nansen"),
  Person("Angelina")
)

val newPerson = Person.apply("Alan", 10)
newPerson.age

class People(var name: String, var age: Int)

object People {
  def apply(name: String, age: Int): People = new People(name, age)

  def unapply(p: People): (String, Int) = (p.name, p.age)
}

val angelina = People("Angelina", 43)
angelina.age
val (name, age) = People.unapply(angelina)
name
age
