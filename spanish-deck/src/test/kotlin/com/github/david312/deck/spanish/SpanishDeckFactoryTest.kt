package com.github.david312.deck.spanish

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class SpanishDeckFactoryTest {

    abstract fun getInstance(): SpanishDeckFactory<*>
    abstract fun getExpectedDeckSize(): Int

    @Test
    fun `when creating a deck, should return a deck with all cards`() {
        val deck = getInstance().newDeck()
        assertFalse(deck.isEmpty())
        assertEquals(getExpectedDeckSize(), deck.size)
        assertContainsAllFigurasOfPalos(deck)
    }

    private fun assertContainsAllFigurasOfPalos(deck: SpanishDeck) {
        for (palo in Palo.values()) {
            assertTrue(deck.hasAllCardsOfPalo(palo))
        }
    }

    @Test
    fun `When creating an empty deck, Should return a deck with no cards`() {
        val deck = getInstance().newEmptyDeck()
        assertTrue(deck.isEmpty())
    }
}