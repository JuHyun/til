package lectures.part1basics

object ValuesVariablesTypes extends App {

  // val is immutable.
  // compiler can infer the type.
  val x = 42
//  x=10 <-- error
  println(x)

  val aString: String = "hello"

  val aBoolean: Boolean = true

  val aChar: Char = 'A'
  val aInt: Int = 10
  val aShort: Short = 1000
  val aLong: Long = 999999999999999999L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  ////////////////////////////
  // variable
  // ------------------------
  // mutable
  ///////////////////////////
  var aVariable: Int = 10
  aVariable = 200 // side effect

}
