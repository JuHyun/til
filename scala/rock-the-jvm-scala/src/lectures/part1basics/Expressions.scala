package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)

  println(x == 3)

  println(!(x == 3))

  var aVariable = 3
  aVariable += 10
  println(aVariable)

  // Instructions (DO) VS Expressions (VALUE)
  // -- Instructions are executed.
  // -- Expressions are evaluated.

  // IF Expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 10 else 0
  println(aConditionedValue)

  // Never Write this again
  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an Expression!

  val aWeiredValue = (aVariable = 100) // Unit === void

  // Side Effects: println(), whiles, reassigning

  // code blocks
  val aCodeBlock = {
    val x = 10
    val y = 20
    val z = x + y
    if (z > 100) "Hello" else "Bye"
  }

  println(aCodeBlock)
}
