package com.github.david312.deck.spanish

abstract class SpanishDeckFactory<D: SpanishDeck> {

    /**
     * Build a new [D] deck with all cards in it.
     */
    abstract fun newDeck(): D
}