package com.github.david312.deck.spanish.traditional

import com.github.david312.deck.spanish.SpanishDeckFactory
import com.github.david312.deck.spanish.SpanishDeckFactoryTest

class TraditionalSpanishDeckFactoryTest: SpanishDeckFactoryTest() {

    private val factory = TraditionalSpanishDeckFactory()
    private val TRADITIONAL_DECK_SIZE = 40

    override fun getInstance(): SpanishDeckFactory<*> = factory
    override fun getExpectedDeckSize(): Int = TRADITIONAL_DECK_SIZE
}