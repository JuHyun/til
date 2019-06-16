package exercises

import scala.annotation.tailrec

object TailRecursion extends App {

  /**
    * 1. string n times concatenation
    */

  def concatenateString(str: String, n: Int): String = {
    def concateHelper(concated: String, times: Int): String = {
      if (times == 1) concated
      else concateHelper(concated + str, times - 1)
    }

    concateHelper(str, n)
  }

  println(concatenateString("hello, ", 1000))

  @tailrec
  def concatedTailer(str: String, n: Int, accumulated: String): String = {
    if (n <= 1) accumulated
    else concatedTailer(str, n - 1, str + accumulated)
  }

  println(concatedTailer("hello", 10000, ""))

  /**
    * 2. prime with tail recursion
    */
  def primeTailRecursion(n: Int): Boolean = {
    @tailrec
    def isPrime(x: Int, stillPrime: Boolean): Boolean = {
      if (x <= 1) stillPrime
      else isPrime(x - 1, n % x != 0 && stillPrime)
    }

    isPrime(n / 2, true)
  }

  println("1 => " + primeTailRecursion(1))
  println("2 => " + primeTailRecursion(2))
  println("3 => " + primeTailRecursion(3))
  println("4 => " + primeTailRecursion(4))
  println("5 => " + primeTailRecursion(5))
  println("6 => " + primeTailRecursion(6))
  println("7 => " + primeTailRecursion(7))
  println("8 => " + primeTailRecursion(8))
  println("9 => " + primeTailRecursion(9))
  println("10 => " + primeTailRecursion(10))
  println("11 => " + primeTailRecursion(11))
  println("12 => " + primeTailRecursion(12))
  println("13 => " + primeTailRecursion(13))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t == 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(12351))
  println(isPrime(2003))


  /**
    * 3. fibonachi
    */

  // f(0) = 0
  // f(1) = 1
  // f(2) = f(0) + f(1) = 0 + 1 = 1
  // f(3) = f(1) + f(2) = 1 + 1 = 2
  // f(4) = f(2) + f(3) = 1 + 2 = 3
  // f(5) = f(3) + f(4) = 2 + 3 = 5

  def fibonachi(n: Int): Int = {
    @tailrec
    def fibonachiTailRec(x: Int, accumulated1: Int, accumulated2: Int): Int = {
      if (x <= 0) accumulated1
//      else if (x == 1) accumulated2
      else fibonachiTailRec(x - 1, accumulated1 + accumulated2, accumulated1)
    }

    fibonachiTailRec(n, 0, 1)
  }

  println("0 => " + fibonachi(0))
  println("1 => " + fibonachi(1))
  println("2 => " + fibonachi(2))
  println("3 => " + fibonachi(3))
  println("4 => " + fibonachi(4))
  println("5 => " + fibonachi(5))
  println("6 => " + fibonachi(6))
  println("7 => " + fibonachi(7))
}
