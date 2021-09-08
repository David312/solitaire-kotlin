package com.github.david312.deck.spanish.traditional

import com.github.david312.deck.spanish.Figura
import com.github.david312.deck.spanish.Palo
import com.github.david312.deck.spanish.SpanishCard
import com.github.david312.deck.spanish.SpanishDeck

open class TraditionalSpanishDeck(cards: List<SpanishCard>): SpanishDeck(cards) {

    companion object {
        private val FORBIDDEN_FIGURAS = listOf(Figura.OCHO, Figura.NUEVE)
        val ALLOWED_FIGURAS: List<Figura> = Figura.values().toMutableList().minus(FORBIDDEN_FIGURAS)
    }

    init {
        assertNoInvalidCardsAreInserted(cards)
    }

    /**
     * Empty deck constructor.
     */
    constructor() : this(listOf())

    private fun assertNoInvalidCardsAreInserted(cards: List<SpanishCard>) {
        cards.find { FORBIDDEN_FIGURAS.contains(it.figura) }
            ?.also { throw IllegalArgumentException("Invalid Figure ${it.figura} for a deck of type ${this::class}") }
    }

    override fun hasAllCardsOfPalo(palo: Palo): Boolean {
        return cards.filter { it.palo == palo }
            .map { it.figura }
            .toList()
            .containsAll(ALLOWED_FIGURAS)
    }

    /**
     * Add the given [card] to the top of the deck.
     * @throws IllegalArgumentException when the [card]'s [Figura] is not valid.
     */
    override fun addTop(card: SpanishCard) {
        assertCardIsAllowed(card)
        super.addTop(card)
    }

    private fun assertCardIsAllowed(card: SpanishCard) {
        if (FORBIDDEN_FIGURAS.contains(card.figura)) {
            throw IllegalArgumentException("Invalid Figure ${card.figura} for a deck of type ${this::class}")
        }
    }

    /**
     * Add the given [card] to the bottom of the deck.
     * @throws IllegalArgumentException when the [card]'s [Figura] is not valid.
     */
    override fun addBottom(card: SpanishCard) {
        assertCardIsAllowed(card)
        super.addBottom(card)
    }

    override fun copy(): SpanishDeck {
        return TraditionalSpanishDeck(this.cards)
    }
}