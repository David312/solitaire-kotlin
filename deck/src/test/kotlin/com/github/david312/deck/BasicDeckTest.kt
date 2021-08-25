package com.github.david312.deck

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BasicDeckTest {

    private data class TestCard(val value: Int): Card

    private val CARDS = listOf(TestCard(1), TestCard(2), TestCard(3))
    private var basicDeck = BasicDeck(CARDS)
    private val DECK_SIZE = 3

    @Test
    fun `Given empty deck, size should be zero`() {
        basicDeck = BasicDeck(listOf())
        assertEquals(0, basicDeck.size)
    }

    @Test
    fun `Given not empty deck, size should be equals to the amount of cards in the deck`() {
        assertEquals(DECK_SIZE, basicDeck.size)
    }

    @Test
    fun `Given empty deck, When draw a card, Should throw exception`() {
        basicDeck = BasicDeck(listOf())
        assertThrows<NotEnoughCardsException> { basicDeck.draw() }
    }

    @Test
    fun `Given not empty deck, When draw a card, Should return the card at the top`() {
        assertEquals(TestCard(1), basicDeck.draw())
        assertEquals(DECK_SIZE - 1, basicDeck.size)
    }

    @Test
    fun `Given empty deck, When drawing N cards, Should throw exception`() {
        basicDeck = BasicDeck(listOf())
        assertThrows<NotEnoughCardsException> { basicDeck.draw(2) }
    }

    @Test
    fun `Given not empty deck, When drawing N cards, Should return the N cards at the top`() {
        assertEquals(listOf(TestCard(1), TestCard(2)), basicDeck.draw(2))
        assertEquals(DECK_SIZE - 2, basicDeck.size)
    }

    @Test
    fun `Given empty deck, When drawing from the bottom, Should throw exception`() {
        basicDeck = BasicDeck(listOf())
        assertThrows<NotEnoughCardsException> { basicDeck.drawBottom() }
    }

    @Test
    fun `Given not empty deck, When draw a card from the bottom, Should return the card at the bottom`() {
        assertEquals(TestCard(3), basicDeck.drawBottom())
        assertEquals(DECK_SIZE - 1, basicDeck.size)
    }

    @Test
    fun `Given empty deck, When drawing N cards from the bottom, Should throw exception`() {
        basicDeck = BasicDeck(listOf())
        assertThrows<NotEnoughCardsException> { basicDeck.drawBottom(2) }
    }

    @Test
    fun `Given not empty deck, When drawing N cards from the bottom, Should return the N cards at the bottom`() {
        assertEquals(listOf(TestCard(3), TestCard(2)), basicDeck.drawBottom(2))
        assertEquals(DECK_SIZE - 2, basicDeck.size)
    }

    @Test
    fun `Given an empty deck, When peek, should return null`() {
        basicDeck = BasicDeck(listOf())
        assertNull(basicDeck.peek())
    }

    @Test
    fun `Given a deck with N cards, When peek at most N cards, Should return a list with the requested cards from the top`() {
        val peeked = basicDeck.peek(DECK_SIZE - 1)
        assertEquals(CARDS.subList(0, DECK_SIZE - 1), peeked)
    }

    @Test
    fun `Given a deck with N cards, When peek more than N cards, Should return a list with N cards from the top`() {
        val peeked = basicDeck.peek(DECK_SIZE + 1)
        assertEquals(CARDS, peeked)
    }

    @Test
    fun `Given an empty deck, When peek, Should return an empty list`() {
        basicDeck = BasicDeck(listOf())
        assertEquals(listOf(), basicDeck.peek(DECK_SIZE))
    }

    @Test
    fun `Given a deck, When peek 0, Should return an empty list`() {
        assertEquals(listOf(), basicDeck.peek(0))
    }

    @Test
    fun `Given a deck, When peek a negative number, Should throw exception`() {
        assertThrows<IllegalArgumentException> { basicDeck.peek(-1) }
    }

    @Test
    fun `Given an empty deck, When peekBottom, should return null`() {
        basicDeck = BasicDeck(listOf())
        assertNull(basicDeck.peekBottom())
    }

    @Test
    fun `Given a deck with N cards, When peekBottom at most N cards, Should return a list with the requested cards from the bottom`() {
        val peeked = basicDeck.peekBottom(DECK_SIZE - 1)
        assertEquals(CARDS.subList(1, DECK_SIZE).reversed(), peeked)
    }

    @Test
    fun `Given a deck with N cards, When peekBottom more than N cards, Should return a list with N cards from the bottom`() {
        assertEquals(CARDS.reversed(), basicDeck.peekBottom(DECK_SIZE + 1))
    }

    @Test
    fun `Given an empty deck, When peekBottom, Should return an empty list`() {
        basicDeck = BasicDeck(listOf())
        assertEquals(listOf(), basicDeck.peekBottom(DECK_SIZE))
    }

    @Test
    fun `Given a deck, When peekBottom 0, Should return an empty list`() {
        assertEquals(listOf(), basicDeck.peekBottom(0))
    }

    @Test
    fun `Given a deck, When peekBottom a negative number, Should throw exception`() {
        assertThrows<IllegalArgumentException> { basicDeck.peekBottom(-1) }
    }
}