package dev.arol.collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomCollectionFunctionsTest {

    // Test data
    private val intList = listOf(1, 2, 3, 4, 5)
    private val emptyList = emptyList<Int>()
    private val nullList = listOf<Int?>(null, 2, null, 4, null)
    private val singleElementList = listOf(42)

    /*** Tests for customForEach ***/
    @Test
    fun `customForEach should apply action to all elements`() {
        val result = mutableListOf<Int>()
        intList.customForEach { result.add(it) }
        assertEquals(intList, result)
    }

    @Test
    fun `customForEach should handle empty list`() {
        val result = mutableListOf<Int>()
        emptyList.customForEach { result.add(it) }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `customForEach should handle null elements`() {
        val result = mutableListOf<Int?>()
        nullList.customForEach { result.add(it) }
        assertEquals(nullList, result)
    }

    /*** Tests for customMap ***/
    @Test
    fun `customMap should transform all elements`() {
        val expected = intList.map { it * 2 }
        val result = intList.customMap { it * 2 }
        assertEquals(expected, result)
    }

    @Test
    fun `customMap should handle empty list`() {
        val result = emptyList.customMap { it * 2 }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `customMap should handle null elements`() {
        val expected = nullList.map { it?.times(2) }
        val result = nullList.customMap { it?.times(2) }
        assertEquals(expected, result)
    }

    /*** Tests for customFilter ***/
    @Test
    fun `customFilter should filter elements based on predicate`() {
        val expected = intList.filter { it % 2 == 0 }
        val result = intList.customFilter { it % 2 == 0 }
        assertEquals(expected, result)
    }

    @Test
    fun `customFilter should return empty list when no elements match`() {
        val result = intList.customFilter { it > 10 }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `customFilter should handle empty list`() {
        val result = emptyList.customFilter { it % 2 == 0 }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `customFilter should handle null elements`() {
        val expected = nullList.filter { it != null }
        val result = nullList.customFilter { it != null }
        assertEquals(expected, result)
    }

    /*** Tests for customFold ***/
    @Test
    fun `customFold should accumulate values correctly`() {
        val expected = intList.fold(0) { acc, i -> acc + i }
        val result = intList.customFold(0) { acc, i -> acc + i }
        assertEquals(expected, result)
    }

    @Test
    fun `customFold should handle empty list and return initial value`() {
        val initial = 10
        val result = emptyList.customFold(initial) { acc, i -> acc + i }
        assertEquals(initial, result)
    }

    @Test
    fun `customFold should handle null elements`() {
        val expected = nullList.fold(0) { acc, i -> acc + (i ?: 0) }
        val result = nullList.customFold(0) { acc, i -> acc + (i ?: 0) }
        assertEquals(expected, result)
    }

    /*** Tests for customReduce ***/
    @Test
    fun `customReduce should accumulate values correctly`() {
        val expected = intList.reduce { acc, i -> acc + i }
        val result = intList.customReduce { acc, i -> acc + i }
        assertEquals(expected, result)
    }

    @Test
    fun `customReduce should throw exception on empty list`() {
        assertThrows<UnsupportedOperationException> {
            emptyList.customReduce { acc, i -> acc + i }
        }
    }

    @Test
    fun `customReduce should handle single element list`() {
        val result = singleElementList.customReduce { acc, i -> acc + i }
        assertEquals(42, result)
    }

    @Test
    fun `customReduce should handle null elements`() {
        val nullableList = listOf<Int?>(null, 2, 3)
        val expected = nullableList.reduce { acc, i -> (acc ?: 0) + (i ?: 0) }
        val result = nullableList.customReduce { acc, i -> (acc ?: 0) + (i ?: 0) }
        assertEquals(expected, result)
    }

    /*** Tests for customPartition ***/
    @Test
    fun `customPartition should partition list based on predicate`() {
        val expected = intList.partition { it % 2 == 0 }
        val result = intList.customPartition { it % 2 == 0 }
        assertEquals(expected, result)
    }

    @Test
    fun `customPartition should handle empty list`() {
        val result = emptyList.customPartition { it > 0 }
        assertTrue(result.first.isEmpty())
        assertTrue(result.second.isEmpty())
    }

    @Test
    fun `customPartition should handle null elements`() {
        val expected = nullList.partition { it == null }
        val result = nullList.customPartition { it == null }
        assertEquals(expected, result)
    }

    /*** Tests for customAll ***/
    @Test
    fun `customAll should return true when all elements match predicate`() {
        val result = intList.customAll { it > 0 }
        assertTrue(result)
    }

    @Test
    fun `customAll should return false when any element does not match predicate`() {
        val result = intList.customAll { it < 3 }
        assertFalse(result)
    }

    @Test
    fun `customAll should return true for empty list`() {
        val result = emptyList.customAll { it > 0 }
        assertTrue(result)
    }

    @Test
    fun `customAll should handle null elements`() {
        val result = nullList.customAll { it == null }
        assertFalse(result)
    }

    /*** Tests for customAny ***/
    @Test
    fun `customAny should return true when any element matches predicate`() {
        val result = intList.customAny { it == 3 }
        assertTrue(result)
    }

    @Test
    fun `customAny should return false when no elements match predicate`() {
        val result = intList.customAny { it > 10 }
        assertFalse(result)
    }

    @Test
    fun `customAny should return false for empty list`() {
        val result = emptyList.customAny { it > 0 }
        assertFalse(result)
    }

    @Test
    fun `customAny should handle null elements`() {
        val result = nullList.customAny { it == null }
        assertTrue(result)
    }

    @Test
    fun `customAny should use customAll correctly`() {
        val result = intList.customAny { it > 4 }  // Should be true
        assertTrue(result)
    }
}
