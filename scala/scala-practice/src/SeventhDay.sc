// LAMBDA CALCULUS
// CHURCH BOOLEANS: 함수를 가지고 boolean을 만든 것

type Bool[A] = A => A => A

def True[A]: Bool[A] = x => y => x
def False[A]: Bool[A] = x => y => y

True(true)(false)
False(true)(false)

def and[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(q(x)(y))(p(x)(y))
and(True)(True)(true)(false)
and(True)(False)(true)(false)

def or[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(p(x)(y))(q(x)(y))
or(True)(False)(true)(false)
or(True)(True)(true)(false)
or(False)(True)(true)(false)
or(False)(False)(true)(false)

def not[A]: Bool[A] => Bool[A] = b => x => y => b(y)(x)
not(True)
not(True)(true)
not(True)(true)(false)
not(False)(true)(false)
not(not(False))(true)(false)

def xor[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(not(q)(x)(y))(q(x)(y))
xor(True)(False)(true)(false)
xor(True)(True)(true)(false)
xor(False)(True)(true)(false)
xor(False)(False)(true)(false)
