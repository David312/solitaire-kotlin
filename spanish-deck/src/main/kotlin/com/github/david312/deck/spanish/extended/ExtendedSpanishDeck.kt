package com.github.david312.deck.spanish.extended

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.SpanishDeck

open class ExtendedSpanishDeck(cards: List<SpanishCard>): SpanishDeck(cards) {

    companion object {
        private val ALLOWED_FIGURAS = Figura.values().toList()
    }

    /**
     * Empty deck constructor.
     */
    constructor(): this(listOf())

    override fun hasAllCardsOfPalo(palo: Palo): Boolean {
        return cards.filter { it.palo == palo }
            .map { it.figura }
            .toList()
            .containsAll(ALLOWED_FIGURAS)
    }
}
