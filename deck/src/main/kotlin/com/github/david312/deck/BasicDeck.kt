package com.github.david312.deck

open class BasicDeck<C: Card>(cards: List<C>): Deck<C> {

    protected var cards = cards.toMutableList()

    override val size: Int get() = cards.size

    override fun draw(): C = draw(1).first()

    override fun draw(amount: Int): List<C> {
        assertThereAreEnoughCards(amount)
        val drawn = cards.take(amount)
        cards = cards.subList(amount, size)
        return drawn
    }

    private fun assertThereAreEnoughCards(amount: Int) {
        if (cards.isEmpty() || size < amount) {
            throw NotEnoughCardsException()
        }
    }

    override fun drawBottom(): C = drawBottom(1).first()

    override fun drawBottom(amount: Int): List<C> {
        assertThereAreEnoughCards(amount)
        val drawn = cards.takeLast(amount).reversed()
        cards = cards.subList(0, size - amount)
        return drawn
    }

    override fun addTop(card: C) = cards.add(0, card)

    override fun addBottom(card: C) {
        cards.add(card)
    }

    override fun shuffle() {
        cards = cards.shuffled().toMutableList()
    }
}
