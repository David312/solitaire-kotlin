package com.github.david312.deck.spanish

import com.github.david312.deck.Card

data class SpanishCard(val palo: Palo, val figura: Figura): Card {
    override fun toString(): String {
        return "Card($figura de $palo)"
    }
}
