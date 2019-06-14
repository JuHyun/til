class Stack[T] {
  var elems: List[T] = Nil

  def push(x: T) {
    elems = x :: elems
  }

  def top: T = elems.head

  def pop(): Unit = {
    elems = elems.tail
  }
}

val stack = new Stack[Int]
stack.push(10)
stack.push('a')
stack.push(100)
stack.top

stack.pop()

stack.top

class Fruit

class Apple extends Fruit

class Banana extends Fruit

val fruitStack = new Stack[Fruit]
fruitStack.push(new Apple)
fruitStack.push(new Apple)
fruitStack.push(new Banana)

fruitStack.top
fruitStack.pop()
fruitStack.top
fruitStack.pop()
fruitStack.top
