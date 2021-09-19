package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.traditional.TraditionalSpanishDeck
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class SinglePaloDeckTest {

    private val PALO = Palo.COPAS
    private val CARDS = listOf(SpanishCard(PALO, Figura.AS))
    private val DECK = TraditionalSpanishDeck(CARDS)

    private var singlePaloDeck = SinglePaloDeck(PALO, DECK)

    @Test
    fun `Given a deck with mixed palos, When creating instance, Should throw exception`() {
        assertThrows<IllegalArgumentException> { SinglePaloDeck(Palo.BASTOS, DECK) }
    }

    @Test
    fun `Given an empty deck, When top, Should return null`() {
        singlePaloDeck = SinglePaloDeck(PALO, TraditionalSpanishDeck())
        assertNull(singlePaloDeck.top())
    }

    @Test
    fun `Given a not empty deck, When top, Should return the card at the top`() {
        assertEquals(CARDS.last(), singlePaloDeck.top())
    }

    @Test
    fun `Given a card with valid Palo, When add, Should add card to the top of the deck`() {
        val card = SpanishCard(PALO, Figura.CABALLO)
        singlePaloDeck.add(card)
        assertEquals(card, singlePaloDeck.top())
    }

    @Test
    fun `Given a card with an invalid Palo, When add, Should throw exception`() {
        val card = SpanishCard(Palo.BASTOS, Figura.CABALLO)
        assertThrows<IllegalArgumentException> { singlePaloDeck.add(card) }
    }

    @Test
    fun `Given a deck without all cards, When hasAllCards, Should return false`() {
        assertFalse(singlePaloDeck.hasAllCards())
    }

    @Test
    fun `Given a deck with all cards, When hasAllCards, Should return true`() {
        singlePaloDeck = SinglePaloDeck(PALO, TraditionalSpanishDeck())
        for (f in TraditionalSpanishDeck.ALLOWED_FIGURAS) {
            singlePaloDeck.add(SpanishCard(PALO, f))
        }
        assertTrue(singlePaloDeck.hasAllCards())
    }

    @Test
    fun `Given a deck with some cards, When getDeck, Should return the deck`() {
        val deck = singlePaloDeck.getDeck()
        assertTrue(deck is TraditionalSpanishDeck)
        assertFalse(deck.isEmpty())
        assertEquals(singlePaloDeck.top(), deck.draw())
    }
}