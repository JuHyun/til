// Monoid는 fold를 일반화 시키는 것임.
// 규칙: Monoid는 항등원을 앞에 붙이든 뒤에 붙이든 나 자신이 나와야 함.
// 결합법칙이 지켜져야 함. <-- Monoide는 분산처리할 때 중요함.
// Monoid는 결합을 계속 하기 위함임...
// append가 중요함

// MONAD
// return, bind가 중요함!
// >>==

// typeclassopedia
// traverable, MONAD가 쭝요함!

// List MONAD
// 경우의 수
//List(add1, muliply3) <*> List(1, 2, 3)

//implicit val listMonad = new Monad[List] {
//}

for (x <- List(1, 2)) yield (x + 10)

for {
  x <- List(1, 2)
  y <- List(3, 4, 5)
  if (y != 4)
} yield (x / y)


// scalaz library: 기능은 더 많음.
// cats library: 좀 더 빠름. compact하고 light하게 만든 버전.
// import $ivy.`org.instances.cats-core:1.1.0`
// cats.syntax.all._ : symbol 관련된 것

// cats.Semigroup: monoid의 상위 그룹.
// |+| => combine

//Option(1) |+| None

// cats.Monoid

import cats.monoid

// semigroup

