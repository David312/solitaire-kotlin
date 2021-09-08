package com.github.david312.deck.spanish.extended

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.test.assertEquals

class ExtendedSpanishDeckTest {

    private var deck = ExtendedSpanishDeck(buildCardsOfPalo(Palo.COPAS))

    private fun buildCardsOfPalo(palo: Palo): List<SpanishCard> {
        return Figura.values().map { SpanishCard(palo, it) }
    }

    @ParameterizedTest
    @EnumSource(value = Figura::class)
    fun `given any Figura, should allow to create deck`(figura: Figura) {
        deck = ExtendedSpanishDeck(listOf(SpanishCard(Palo.COPAS, figura)))
    }

    @Test
    fun `Given all cards of a palo, when checking if the deck has all cards of it, should return true`() {
        Assertions.assertTrue(deck.hasAllCardsOfPalo(Palo.COPAS))
    }

    @Test
    fun `Given not all cards of a palo, when checking if the deck has all cards of it, should return false`() {
        deck.draw()
        Assertions.assertFalse(deck.hasAllCardsOfPalo(Palo.COPAS))
    }

    @Test
    fun `Given deck, When copy, Should return a copy of itself`() {
        var copy = deck.copy()
        assertEquals(deck.size, copy.size)
        for (card in deck) {
            assertEquals(card, copy.draw())
        }
    }
}