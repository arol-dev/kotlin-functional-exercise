package dev.arol.functional

/**
 * val greetOnce = { name: String -> "Hola, $name!" }.once()
 *
 * println(greetOnce("Ana")) // Salida: Hola, Ana!
 * println(greetOnce("Luis")) // Salida: null (la función ya fue llamada una vez)
 */
fun <T, R> ((T) -> R).once(): (T) -> R? {
    TODO("Implementar función")
}

/**
 * var computationCount = 0
 * val expensiveComputation = { x: Int ->
 *     computationCount++
 *     x * x
 * }.memoize()
 *
 * println(expensiveComputation(4)) // Salida: 16
 * println(expensiveComputation(4)) // Salida: 16 (resultado en caché)
 * println("Computation count: $computationCount") // Salida: Computation count: 1
 */
fun <T, R> ((T) -> R).memoize(): (T) -> R {
    TODO("Implementar función")
}

/**
 * val multiply = { x: Int, y: Int -> x * y }
 * val curriedMultiply = multiply.curried()
 *
 * val multiplyByTwo = curriedMultiply(2)
 * println(multiplyByTwo(5)) // Salida: 10
 */
fun <T, U, V> ((T, U) -> V).curried(): (T) -> (U) -> V {
    TODO("Implementar función")
}

/**
 * val double = { x: Int -> x * 2 }
 * val square = { x: Int -> x * x }
 *
 * val doubleThenSquare = double andThen square
 *
 * println(doubleThenSquare(3)) // Salida: 36 ((3 * 2) al cuadrado)
 */
infix fun <T, R, V> ((T) -> R).andThen(after: (R) -> V): (T) -> V {
    TODO("Implementar función")
}
