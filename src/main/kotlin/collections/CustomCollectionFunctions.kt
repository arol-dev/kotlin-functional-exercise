package dev.arol.collections

/**
 * val list = listOf(1, 2, 3)
 * list.customForEach { println(it) }
 * // Salida:
 * // 1
 * // 2
 * // 3
 */
fun <T> Iterable<T>.customForEach(action: (T) -> Unit) {
    for (element in this) {
        action(element)
    }
}

/**
 * val list = listOf(1, 2, 3)
 * val doubled = list.customMap { it * 2 }
 * println(doubled) // Salida: [2, 4, 6]
 */
fun <T, R> Iterable<T>.customMap(transform: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    this.customForEach { result.add(transform(it)) }
    return result
}

/**
 * val list = listOf(1, 2, 3, 4, 5)
 * val evenNumbers = list.customFilter { it % 2 == 0 }
 * println(evenNumbers) // Salida: [2, 4]
 */
fun <T> Iterable<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    this.customForEach {
        if (predicate(it)) {
            result.add(it)
        }
    }
    return result
}

/**
 * val list = listOf(1, 2, 3, 4)
 * val sum = list.customFold(0) { acc, item -> acc + item }
 * println(sum) // Salida: 10
 */
fun <T, R> Iterable<T>.customFold(initial: R, operation: (acc: R, T) -> R): R {
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

/**
 * val list = listOf(2, 3, 4)
 * val product = list.customReduce { acc, item -> acc * item }
 * println(product) // Salida: 24 (2 * 3 * 4)
 */
fun <T> Iterable<T>.customReduce(operation: (acc: T, T) -> T): T {
    val iterator = this.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
    var accumulator = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}

/**
 * val list = listOf(1, 2, 3, 4, 5)
 * val (even, odd) = list.customPartition { it % 2 == 0 }
 * println(even) // Salida: [2, 4]
 * println(odd)  // Salida: [1, 3, 5]
 */
fun <T> Iterable<T>.customPartition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
    val matching = mutableListOf<T>()
    val nonMatching = mutableListOf<T>()
    this.customForEach {
        if (predicate(it)) {
            matching.add(it)
        } else {
            nonMatching.add(it)
        }
    }
    return Pair(matching, nonMatching)
}

/**
 * val list = listOf(2, 4, 6)
 * val allEven = list.customAll { it % 2 == 0 }
 * println(allEven) // Salida: true
 */
fun <T> Iterable<T>.customAll(predicate: (T) -> Boolean): Boolean {
    for (element in this) {
        if (!predicate(element)) return false
    }
    return true
}

/**
 * val list = listOf(1, 3, 5)
 * val hasEven = list.customAny { it % 2 == 0 }
 * println(hasEven) // Salida: false
 */
fun <T> Iterable<T>.customAny(predicate: (T) -> Boolean): Boolean {
    return !this.customAll { !predicate(it) }
}
