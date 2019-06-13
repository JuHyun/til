def filter(xs: List[Int], threshold: Int) = {
  def process(ys: List[Int]): List[Int] = {
    if (ys.isEmpty) ys
    else if (ys.head < threshold) ys.head :: process(ys.tail)
    else process(ys.tail)
  }
  process(xs)
}

filter(List(1, 9, 10, 3, 5, 100, -10, 39, 20), 30)
