package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishDeck

class ResolvedCards internal constructor(private val deckByPalo: Map<Palo, SinglePaloDeck>) {

    /**
     * Get the resolved cards of the given [palo].
     * @throws IllegalArgumentException when [palo] does not have a deck of resolved cards.
     */
    fun getResolvedCardsOfPalo(palo: Palo): SpanishDeck {
        return deckByPalo[palo]?.getDeck() ?: throw IllegalArgumentException()
    }
}