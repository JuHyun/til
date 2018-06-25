def square(x: Int) = x * x
square(2)

3


def plusOne(x: Int): Int = x + 1

plusOne(10)

def foo() = 1

foo()

if (false) 1 else 0.0

if (false) 1 else null


def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

factorial(10)

def factorial2(n: Int): Int = n match {
  case 0 => 1
  case _ => n * factorial2(n - 1)
}

factorial2(100)

def factorial3(n: BigInt): BigInt = n match {
  case x: BigInt if (x == 0) => 1
  case _ => n * factorial3(n - 1)
}

factorial3(100)

def fac_iter(product: BigInt, count: BigInt, number: BigInt): BigInt =
  if (count > number) product else fac_iter(product * count, count + 1, number)
def factorial4(n: BigInt): BigInt = fac_iter(1, 1, n)

factorial4(5)


def factorial5(n: BigInt): BigInt = {
  def fac_iter(product: BigInt, count: BigInt, number: BigInt): BigInt =
    if (count > number) product else fac_iter(product * count, count + 1, number)
  fac_iter(1, 1, n)
}

factorial5(5)

def fibonachi(n: BigInt): BigInt = n match {
  case x: BigInt if (x == 0) => 0
  case x: BigInt if (x == 1) => 1
  case _ => fibonachi(n - 2) + fibonachi(n - 1)
}

fibonachi(0)
fibonachi(1)
fibonachi(2)
fibonachi(3)
fibonachi(4)
fibonachi(5)
fibonachi(6)


def fib(n: Int): Int = {
  def fib_iter(product1: Int, product2: Int, n: Int): Int = if (n == 0) product1 else fib_iter(product2, product1 + product2, n-1)

  fib_iter(0, 1, n)
}

fib(0)
fib(1)
fib(2)
fib(3)
fib(4)
fib(5)
fib(6)
