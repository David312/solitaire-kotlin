package com.github.david312.deck.spanish

class SpanishDeckFactory {

    /**
     * Build a new and empty [TraditionalSpanishDeck].
     */
    fun newEmptyTraditionalDeck(): TraditionalSpanishDeck {
        return TraditionalSpanishDeck(listOf())
    }

    /**
     * Build a new [TraditionalSpanishDeck] with all cards in it.
     */
    fun newTraditionalDeck(): TraditionalSpanishDeck {
        val cards: List<SpanishCard> = Palo.values().flatMap { buildTraditionalCardsOfPalo(it) }
        return TraditionalSpanishDeck(cards)
    }

    private fun buildTraditionalCardsOfPalo(palo: Palo): List<SpanishCard> {
        return TraditionalSpanishDeck.ALLOWED_FIGURAS.map { SpanishCard(palo, it) }
    }

    fun newEmptyExtendedDeck(): ExtendedSpanishDeck {
        return ExtendedSpanishDeck(listOf())
    }

    fun newExtendedDeck(): ExtendedSpanishDeck {
        val cards: List<SpanishCard> = Palo.values().flatMap { buildExtendedCardsOfPalo(it) }
        return ExtendedSpanishDeck(cards)
    }

    private fun buildExtendedCardsOfPalo(palo: Palo): List<SpanishCard> {
        return Figura.values().map { SpanishCard(palo, it) }
    }


}