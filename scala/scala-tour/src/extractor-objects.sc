import scala.util.Random

object Twice {
  def apply(x: Int): Int = x * 2

  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}

val x = Twice(21)

x match {
  case Twice(n) => Console.println(n)
}

val y = Twice(10)

y match {
  case Twice(n) => Console.println(n)
}

object CustomerID {

  def apply(name: String):String = s"$name -- ${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

val customerID = CustomerID("Kim")
customerID match {
  case CustomerID(name) => println(name)
  case _ => println("Could not extract a Customer ID")
}

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID
name

val name2 = CustomerID.unapply(customer2ID).get

// scala.MatchError: -adfefaefaefe (of class java.lang.String)
//val CustomerID(name3) = "-adfefaefaefe"
