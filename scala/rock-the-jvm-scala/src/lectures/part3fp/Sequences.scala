package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSortedSequence = Seq(1, 2, 3, 4, 5)
  println(aSortedSequence)
  println(aSortedSequence.reverse)
  println(aSortedSequence(2))
  println(aSortedSequence ++ Seq(100, 101, 102))

  val aUnsortedSequence = Seq(5, 2, 4, 1, 3)
  println(aUnsortedSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val aUntilRange: Seq[Int] = 1 until 10
  aUntilRange.foreach(println)

  (1 to 10).foreach(_ => println("Hello, " + _))

  // List
  val aList = List(1, 2, 3, 4, 5)
  println(aList)
  val prependedList = 100 +: aList // 100 :: aList
  println(prependedList)
  val postpendedList = aList :+ List(6, 7, 8)
  println(postpendedList)
  println(aList.mkString("++"))

  val apple5 = List.fill(5)("apple")
  println(apple5)

  // Arrays
  val numbers = Array(1, 2, 3, 4, 5)
  println(numbers)
  numbers.foreach(println)
  val threeString = Array.ofDim[String](3)
  println(threeString)
  threeString.foreach(println)

  // mutation
  numbers(0) = 100 // syntax sugar for numbers.update(0, 100)
  numbers.foreach(println)

  // Seq vs Array
  val numberSeq: Seq[Int] = numbers // implicit conversion
  println(numberSeq) // WrappedArray: special object

  // Vectors
  val aVector: Vector[Int] = Vector(1, 2, 3)
  println(aVector)

  // vector vs list
  val maxRun = 1000
  val maxCapacity = 10000

  def getWriteTimes(collections: Seq[Int]): Double = {
    val random = new Random
    val times = for {
      it <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      collections.updated(random.nextInt(maxCapacity), random.nextInt())
      System.nanoTime() - currentTime
    }

    // average
    times.sum * 1.0 / maxRun
  }
  
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // List
  // pros: keeps reference to tail
  // cons: updating an element in the middle takes time
  println(getWriteTimes(numbersList))

  // Vector
  // pros: depth of the tree is small
  // cons: needs to replace an entire 32-element chunk
  println(getWriteTimes(numbersVector))
}
