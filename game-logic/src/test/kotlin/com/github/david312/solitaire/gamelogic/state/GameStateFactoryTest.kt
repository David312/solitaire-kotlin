package com.github.david312.solitaire.gamelogic.state

import com.github.david312.deck.spanish.traditional.TraditionalSpanishDeckFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameStateFactoryTest {
    private var factory = GameStateFactory(TraditionalSpanishDeckFactory())

    @Test
    fun `Given factory, When create new clear state, Should return a new clear game state`() {
        assertNotNull(factory.newClearState())
    }
}