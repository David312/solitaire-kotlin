package com.github.david312.deck.spanish

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpanishDeckFactoryTest {

    private var factory = SpanishDeckFactory()
    private val TRADITIONAL_DECK_SIZE = 40
    private val EXTENDED_DECK_SIZE = 48

    @Test
    fun `when creating an empty traditional deck, should return a traditional deck with no cards`() {
        val deck = factory.newEmptyTraditionalDeck()
        assertTrue(deck.isEmpty())
    }

    @Test
    fun `when creating a traditional deck, should return a traditional deck with all cards`() {
        val deck = factory.newTraditionalDeck()
        assertFalse(deck.isEmpty())
        assertEquals(TRADITIONAL_DECK_SIZE, deck.size)
        assertContainsAllFigurasOfPalos(deck)
    }

    private fun assertContainsAllFigurasOfPalos(deck: SpanishDeck) {
        for (palo in Palo.values()) {
            assertTrue(deck.hasAllCardsOfPalo(palo))
        }
    }

    @Test
    fun `when creating an empty extended deck, should return an extended deck with no cards`() {
        val deck = factory.newEmptyExtendedDeck()
        assertTrue(deck.isEmpty())
    }

    @Test
    fun `when creating an extended deck, should return an extended deck with all cards`() {
        val deck = factory.newExtendedDeck()
        assertFalse(deck.isEmpty())
        assertEquals(EXTENDED_DECK_SIZE, deck.size)
        assertContainsAllFigurasOfPalos(deck)
    }
}