package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 10))

  def aParameterlessFunction(): Int = 100

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // When you need Loop, USE Recursion.
  def aRepeatedFunction(aString: String, count: Int): String = {
    if (count == 1) aString
    else aString + aRepeatedFunction(aString, count - 1)
  }

  println(aRepeatedFunction("hello", 5))

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(10))

  // 1.
  def aHelloFunction(name: String, age: Int) = s"Hi, my name is $name and I am $age years old."

  println(aHelloFunction("Angellina Jolie", 43))

  // 2. Factorial
  def aFactorial(n: Int): Int = {
    if (n <= 1) n
    else n * aFactorial(n - 1)
  }

  println(aFactorial(1))
  println(aFactorial(2))
  println(aFactorial(3))
  println(aFactorial(4))
  println(aFactorial(5))

  // 3. Fibonachi
  def aFibonachi(n: Int): Int = {
    if (n <= 1) 1
    else aFibonachi(n - 1) + aFibonachi(n - 2)
  }

  println(aFibonachi(0))
  println(aFibonachi(1))
  println(aFibonachi(2))
  println(aFibonachi(3))
  println(aFibonachi(4))
  println(aFibonachi(5))

  def aPrime(n: Int): Boolean = {
    def isUntilPrime(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isUntilPrime(t - 1)
    }

    isUntilPrime(n / 2)
  }

  println(aPrime(1))
  println(aPrime(2))
  println(aPrime(3))
  println(aPrime(4))
  println(aPrime(5))
  println(aPrime(6))
  println(aPrime(7))
  println(aPrime(8))
  println(aPrime(9))
  println(aPrime(10))
  println(aPrime(11))
  println(aPrime(22))
}
