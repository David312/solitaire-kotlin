package com.github.david312.deck.spanish.traditional

import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.SpanishDeckFactory

class TraditionalSpanishDeckFactory: SpanishDeckFactory<TraditionalSpanishDeck>() {

    override fun newDeck(): TraditionalSpanishDeck {
        val cards: List<SpanishCard> = Palo.values().flatMap { buildTraditionalCardsOfPalo(it) }
        return TraditionalSpanishDeck(cards)
    }

    private fun buildTraditionalCardsOfPalo(palo: Palo): List<SpanishCard> {
        return TraditionalSpanishDeck.ALLOWED_FIGURAS.map { SpanishCard(palo, it) }
    }

    override fun newEmptyDeck(): TraditionalSpanishDeck {
        return TraditionalSpanishDeck()
    }
}