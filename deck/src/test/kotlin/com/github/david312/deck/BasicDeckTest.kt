package com.github.david312.deck

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BasicDeckTest {

    private data class TestCard(val value: Int): Card

    private var basicDeck = BasicDeck<TestCard>(listOf(TestCard(1), TestCard(2), TestCard(3)))
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
}