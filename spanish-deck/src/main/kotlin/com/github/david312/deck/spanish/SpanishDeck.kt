package com.github.david312.deck.spanish

import com.github.david312.deck.BasicDeck

abstract class SpanishDeck protected constructor(cards: List<SpanishCard>): BasicDeck<SpanishCard>(cards) {

    abstract fun hasAllCardsOfPalo(palo: Palo): Boolean
}
