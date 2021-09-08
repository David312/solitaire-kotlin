package com.github.david312.deck.spanish.traditional

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.test.assertEquals

class TraditionalSpanishDeckTest {

    private var deck = TraditionalSpanishDeck(buildAllCardsOfPalo(Palo.BASTOS))

    private fun buildAllCardsOfPalo(palo: Palo): List<SpanishCard> {
        return listOf(
            SpanishCard(palo, Figura.AS),
            SpanishCard(palo, Figura.DOS),
            SpanishCard(palo, Figura.TRES),
            SpanishCard(palo, Figura.CUATRO),
            SpanishCard(palo, Figura.CINCO),
            SpanishCard(palo, Figura.SEIS),
            SpanishCard(palo, Figura.SIETE),
            SpanishCard(palo, Figura.SOTA),
            SpanishCard(palo, Figura.CABALLO),
            SpanishCard(palo, Figura.REY)
        )
    }

    @ParameterizedTest
    @EnumSource(names = ["OCHO", "NUEVE"])
    fun `Given a list of cards with invalid Figuras, when creating deck, should throw exception`(figura: Figura) {
        assertThrows<IllegalArgumentException> {
            TraditionalSpanishDeck(buildAllCardsOfPalo(Palo.BASTOS) + listOf(SpanishCard(Palo.BASTOS, figura)))
        }
    }

    @Test
    fun `Given all cards of a palo, when checking if the deck has all cards of it, should return true`() {
        assertTrue(deck.hasAllCardsOfPalo(Palo.BASTOS))
    }

    @Test
    fun `Given not all cards of a palo, when checking if the deck has all cards of it, should return false`() {
        deck.draw()
        assertFalse(deck.hasAllCardsOfPalo(Palo.BASTOS))
    }

    @ParameterizedTest
    @EnumSource(names = ["OCHO", "NUEVE"])
    fun `Given not allowed card, when adding to the top of the deck, should throw exception`(figura: Figura) {
        assertThrows<IllegalArgumentException> { deck.addTop(SpanishCard(Palo.COPAS, figura)) }
    }

    @Test
    fun `Given allowed card, when adding to the top of the deck, should be on top`() {
        val card = SpanishCard(Palo.COPAS, Figura.AS)
        deck.addTop(card)
        assertEquals(card, deck.draw())
    }

    @ParameterizedTest
    @EnumSource(names = ["OCHO", "NUEVE"])
    fun `Given not allowed card, when adding to the bottom of the deck, should throw exception`(figura: Figura) {
        assertThrows<IllegalArgumentException> { deck.addBottom(SpanishCard(Palo.COPAS, figura)) }
    }

    @Test
    fun `Given allowed card, when adding to the bottom of the deck, should be on bottom`() {
        val card = SpanishCard(Palo.COPAS, Figura.AS)
        deck.addBottom(card)
        assertEquals(card, deck.drawBottom())
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