val ingredient = ("Sugar", 25)
val people = ("Angelina", "Jolie", 40)

println(people._1)
println(people._2)
println(people._3)

val (firstName, lastName, age) = people
println(firstName + " " + lastName + ", age = " + age)

val planets = List(("Mercury", 57.9),
  ("Venus", 108.2), ("Earth", 149.6),
  ("Mars", 227.9), ("Jupiter", 778.3))

planets.foreach{
  case ("Earth", distance) => println(s"Our planet is $distance million kilometers from the sun")
  case _ => println(s" etc...")
}

val numPair = List((1,2), (10, 20), (3,-10))
for ((a, b) <- numPair) {
  println(a * b)
}
