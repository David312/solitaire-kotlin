package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.SpanishDeck

class SinglePaloDeck internal constructor(val palo: Palo, private val deck: SpanishDeck) {

    init {
        assertDeckContainsOnlyValidPalo()
    }

    private fun assertDeckContainsOnlyValidPalo() {
        for (card in deck) {
            if (card.palo != palo) {
                throw IllegalArgumentException("The deck contains cards whose Palo is not $palo")
            }
        }
    }

    /**
     * Adds [card] to the deck.
     * @throws IllegalArgumentException when the card is not of the allowed [palo]
     */
    fun add(card: SpanishCard) {
        assertCardHasValidPalo(card)
        deck.addTop(card)
    }

    private fun assertCardHasValidPalo(card: SpanishCard) {
        if (card.palo != palo) {
            throw IllegalArgumentException("Only cards of Palo $palo are allowed to ")
        }
    }

    /**
     * Get the card at the top of the deck, if present.
     */
    fun top(): SpanishCard? {
        return deck.peek()
    }

    /**
     * Check whether the deck has all cards for this deck.
     */
    fun hasAllCards(): Boolean {
        return deck.hasAllCardsOfPalo(palo)
    }

    /**
     * Get the current status of the deck.
     */
    fun getDeck(): SpanishDeck {
        return deck.copy()
    }
}