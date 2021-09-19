package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishDeckFactory

class GameStateFactory(private val deckFactory: SpanishDeckFactory<*>) {

    /**
     * Build a clear [GameState].
     */
    fun newClearState(): GameState {
        return GameState(deckFactory.newDeck(), deckFactory.newEmptyDeck(), newResolvedCards())
    }

    private fun newResolvedCards(): ResolvedCards {
        return ResolvedCards(Palo.values().associateWith { SinglePaloDeck(it, deckFactory.newEmptyDeck()) })
    }
}