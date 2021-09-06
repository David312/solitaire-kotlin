package com.github.david312.deck.spanish

abstract class SpanishDeckFactory<D: SpanishDeck> {

    /**
     * Build a new [D] deck with all cards in it.
     */
    abstract fun newDeck(): D

    /**
     * Build a new [D] deck with no cards in it.
     */
    abstract fun newEmptyDeck(): D
}