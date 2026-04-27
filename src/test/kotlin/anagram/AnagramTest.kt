package anagram

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnagramTest {

    @Test
    fun `no matches`() {
        val result = Anagram("diaper").match(listOf("hello", "world", "zombies", "pants"))
        assertEquals(emptySet<String>(), result)
    }

    @Test
    fun `detects simple anagram`() {
        val result = Anagram("ant").match(listOf("tan", "stand", "at"))
        assertEquals(setOf("tan"), result)
    }

    @Test
    fun `does not detect itself as anagram`() {
        val result = Anagram("banana").match(listOf("banana"))
        assertEquals(emptySet<String>(), result)
    }

    @Test
    fun `is case insensitive`() {
        val result = Anagram("Orchestra").match(listOf("cashier", "Carthorse", "radishes"))
        assertEquals(setOf("Carthorse"), result)
    }

    @Test
    fun `does not detect itself as anagram regardless of case`() {
        val result = Anagram("BANANA").match(listOf("Banana", "BANANA", "banana"))
        assertEquals(emptySet<String>(), result)
    }

    @Test
    fun `detects multiple anagrams`() {
        val result = Anagram("master").match(listOf("stream", "pigeon", "maters"))
        assertEquals(setOf("stream", "maters"), result)
    }

    @Test
    fun `words are not anagrams of themselves even with different casing`() {
        val result = Anagram("go").match(listOf("go", "GO", "Go"))
        assertEquals(emptySet<String>(), result)
    }

    @Test
    fun `anagram must use all letters exactly once`() {
        val result = Anagram("tapper").match(listOf("patter"))
        assertEquals(emptySet<String>(), result)
    }

    @Test
    fun `detects anagram with different lengths returns empty`() {
        val result = Anagram("listen").match(listOf("enlists", "google", "inlets", "banana"))
        assertEquals(setOf("inlets"), result)
    }
}
