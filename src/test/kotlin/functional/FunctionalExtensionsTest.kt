package dev.arol.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FunctionalExtensionsTest {

    /*** Tests for once ***/
    @Test
    fun `once should allow function to be called only once`() {
        var counter = 0
        val incrementOnce = { x: Int ->
            counter += x
            counter
        }.once()

        val firstCall = incrementOnce(5)
        val secondCall = incrementOnce(10)

        assertEquals(5, firstCall)
        assertNull(secondCall)
        assertEquals(5, counter)
    }

    @Test
    fun `once should return null on subsequent calls`() {
        val sayHelloOnce = { name: String -> "Hello, $name!" }.once()
        val firstCall = sayHelloOnce("Alice")
        val secondCall = sayHelloOnce("Bob")

        assertEquals("Hello, Alice!", firstCall)
        assertNull(secondCall)
    }

    /*** Tests for memoize ***/
    @Test
    fun `memoize should cache function results`() {
        var computationCount = 0
        val computeSquare = { x: Int ->
            computationCount++
            x * x
        }.memoize()

        val firstCall = computeSquare(4)
        val secondCall = computeSquare(4)
        val thirdCall = computeSquare(5)

        assertEquals(16, firstCall)
        assertEquals(16, secondCall)
        assertEquals(25, thirdCall)
        assertEquals(2, computationCount) // Computation should have occurred only twice
    }

    @Test
    fun `memoize should handle different inputs separately`() {
        var computationCount = 0
        val identity = { x: String ->
            computationCount++
            x
        }.memoize()

        identity("test")
        identity("test")
        identity("another")

        assertEquals(2, computationCount)
    }

    /*** Tests for currying ***/
    @Test
    fun `currying should transform function into sequence of functions`() {
        val multiply = { x: Int, y: Int -> x * y }
        val curriedMultiply = multiply.curried()

        val multiplyByTwo = curriedMultiply(2)
        val result = multiplyByTwo(5)

        assertEquals(10, result)
    }

    @Test
    fun `currying should allow partial application`() {
        val concatenate = { a: String, b: String -> a + b }
        val curriedConcatenate = concatenate.curried()

        val greet = curriedConcatenate("Hello, ")
        val greeting = greet("World!")

        assertEquals("Hello, World!", greeting)
    }

    /*** Tests for andThen ***/
    @Test
    fun `andThen should compose two functions`() {
        val multiplyByTwo = { x: Int -> x * 2 }
        val square = { x: Int -> x * x }

        val multiplyThenSquare = multiplyByTwo andThen square

        val result = multiplyThenSquare(3)

        assertEquals(36, result) // (3 * 2) squared is 36
    }

    @Test
    fun `andThen should pass output of first function to second`() {
        val toUpperCase = { s: String -> s.uppercase() }
        val exclaim = { s: String -> "$s!" }

        val shout = toUpperCase andThen exclaim

        val result = shout("hello")

        assertEquals("HELLO!", result)
    }
}
