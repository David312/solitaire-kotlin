package com.github.david312.deck.spanish

class ExtendedSpanishDeck internal constructor(cards: List<SpanishCard>): SpanishDeck(cards) {

    companion object {
        private val ALLOWED_FIGURAS = Figura.values().toList()
    }

    override fun hasAllCardsOfPalo(palo: Palo): Boolean {
        return cards.filter { it.palo == palo }
            .map { it.figura }
            .toList()
            .containsAll(ALLOWED_FIGURAS)
    }
}
