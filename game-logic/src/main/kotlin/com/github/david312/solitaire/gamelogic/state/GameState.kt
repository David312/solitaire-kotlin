package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.SpanishDeck
import com.github.david312.deck.spanish.SpanishDeckFactory

class GameState internal constructor(
    private val hand: SpanishDeck,
    private val discarded: SpanishDeck,
    private val resolved: ResolvedCards
) {

    /**
     * Copy constructor to duplicate state.
     */
    internal constructor(other: GameState) : this(other.hand, other.discarded, other.resolved)
}