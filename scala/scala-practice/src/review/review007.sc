type Bool[A] = A => A => A

def True[A]: Bool[A] = x => y => x
def False[A]: Bool[A] = x => y => y

True(true)(false) == true
False(true)(false) == false

def and[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(q(x)(y))(p(x)(y))
and(True)(True)(true)(false)
and(True)(False)(true)(false)
and(False)(True)(true)(false)
and(False)(False)(true)(false)

def or[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(p(x)(y))(q(x)(y))
or(True)(True)(true)(true)
or(True)(False)(true)(false)
or(False)(True)(true)(false)
or(False)(False)(true)(false)

def not[A]: Bool[A] => Bool[A] = p => x => y => p(y)(x)
not(True)
not(True)(true)
not(True)(true)(false)
not(False)
not(False)(true)
not(False)(true)(false)
not(not(False))(true)(false)

def xor[A]: Bool[A] => Bool[A] => Bool[A] = p => q => x => y => p(not(q)(x)(y))(q(x)(y))
xor(True)(True)(true)(false)
// True(False(true)(false))(True(true)(false))
// True(false)(true) ==> false
xor(True)(False)(true)(false)
// True(True(true)(false))(False(true)(false))
// True(true)(false) ==> true
xor(False)(True)(true)(false)
// False(False(true)(false))(True(true)(false))
// False(false)(true) ==> true
xor(False)(False)(true)(false)
// False(True(true)(false))(False(true)(false))
// False(true)(false) ==> false
