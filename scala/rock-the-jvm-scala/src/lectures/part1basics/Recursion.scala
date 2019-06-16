package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("computed result of n = " + n + ", (n-1) = " + (n - 1))
      val result = n * factorial(n - 1)
      println("computed result of result = " + result)

      result
    }

  factorial(10)
  //  factorial(5000) // StackOverflowError

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x == 1) accumulator
      else {
        //        println(s" x = $x, accumulator = $accumulator")
        factorialHelper(x - 1, x * accumulator) // tail recursion
      }
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(1))
  println(anotherFactorial(2))
  println(anotherFactorial(3))
  println(anotherFactorial(4))
  println(anotherFactorial(5))
  println(anotherFactorial(6))
  println(anotherFactorial(50000))
}
