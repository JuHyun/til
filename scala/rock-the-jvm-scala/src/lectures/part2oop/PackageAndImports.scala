package lectures.part2oop

import playground.{Cindella => Princess, PrinceCharming}


object PackageAndImports extends App {

  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  val cindella = new Princess // equivalent new playground.Cindella

  // package object
  sayHello
  println(SPEED_OF_LIGHT)


  // import
  val prince = new PrinceCharming

  // default imports
  // scala - Int, Nothing, Function
  // scala.Predef = println, ???
}
