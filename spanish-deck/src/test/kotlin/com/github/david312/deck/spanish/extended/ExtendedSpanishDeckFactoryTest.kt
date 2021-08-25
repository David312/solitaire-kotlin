package com.github.david312.deck.spanish.extended

import com.github.david312.deck.spanish.SpanishDeckFactory
import com.github.david312.deck.spanish.SpanishDeckFactoryTest

class ExtendedSpanishDeckFactoryTest: SpanishDeckFactoryTest() {

    private val factory = ExtendedSpanishDeckFactory()
    private val EXTENDED_DECK_SIZE = 48

    override fun getInstance(): SpanishDeckFactory<*> = factory
    override fun getExpectedDeckSize(): Int = EXTENDED_DECK_SIZE
}