trait Similar {
  def isSimilar(x: Any): Boolean
}

case class MyInt(x: Int) extends Similar {
  override def isSimilar(m: Any): Boolean =
    m.isInstanceOf[MyInt] &&
      m.asInstanceOf[MyInt].x == x
}

def findSimilar[T <: Similar](e: T, xs: List[T]): Boolean =
  if (xs.isEmpty) false
  else if (e.isSimilar(xs.head)) true
  else findSimilar[T](e, xs.tail)

val list: List[MyInt] = List(MyInt(1), MyInt(2), MyInt(3))
findSimilar[MyInt](MyInt(4), list)
findSimilar[MyInt](MyInt(2), list)

abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class Lion extends Animal {
  override def name: String = "Lion"
}

class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

val dogContainer = new PetContainer[Dog](new Dog)
val catContainer = new PetContainer[Cat](new Cat)

// Error! Lion is not a subtype of Pet.
//val lionContainer = new PetContainer[Lion](new Lion)
