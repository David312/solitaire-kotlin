package com.github.david312.deck.spanish.extended

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.SpanishDeckFactory

class ExtendedSpanishDeckFactory: SpanishDeckFactory<ExtendedSpanishDeck>() {

    override fun newDeck(): ExtendedSpanishDeck {
        val cards: List<SpanishCard> = Palo.values().flatMap { buildExtendedCardsOfPalo(it) }
        return ExtendedSpanishDeck(cards)
    }

    private fun buildExtendedCardsOfPalo(palo: Palo): List<SpanishCard> {
        return Figura.values().map { SpanishCard(palo, it) }
    }
}