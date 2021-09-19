package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.traditional.TraditionalSpanishDeck
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ResolvedCardsTest {
    private val PALO = Palo.COPAS
    private val CARD = SpanishCard(PALO, Figura.AS)
    private val DECK = TraditionalSpanishDeck(listOf(CARD))
    private var resolvedCards = ResolvedCards(mapOf(PALO to SinglePaloDeck(PALO, DECK)))

    @Test
    fun `Given a palo not present, When get cards of palo, Should throw exception`() {
        assertThrows<IllegalArgumentException> { resolvedCards.getResolvedCardsOfPalo(Palo.BASTOS) }
    }

    @Test
    fun `Given a palo present, When get cards of palo, Should return a deck with the cards`() {
        val paloDeck = resolvedCards.getResolvedCardsOfPalo(PALO)
        assertEquals(DECK.size, paloDeck.size)
        for (card in DECK) {
            assertEquals(card, paloDeck.draw())
        }
    }
}