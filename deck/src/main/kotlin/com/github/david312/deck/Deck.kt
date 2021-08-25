package com.github.david312.deck

interface Deck<C: Card>: Iterable<C> {
    /**
     * The size of the deck.
     */
    val size: Int

    /**
     * Check if the deck is empty.
     */
    fun isEmpty() = size == 0

    /**
     * Draw one card from the top of the deck.
     * It is the same as draw(1).
     * @throws NotEnoughCardsException when there are no cards remaining in the deck.
     */
    fun draw(): C

    /**
     * Draw the specified amount of cards from the top of the deck.
     * @throws NotEnoughCardsException when there are not enough cards to drow in the deck.
     */
    fun draw(amount: Int): List<C>

    /**
     * Draw a card from the bottom of the deck.
     * @throws NotEnoughCardsException when there are no cards remaining in the deck.
     */
    fun drawBottom(): C

    /**
     * Draw the specified amount of cards from the bottom of the deck.
     * The order of the cards drawn will be {last, last-1, last-2, ..., last-(N-1)}.
     * @throws NotEnoughCardsException when there are not enough cards to drow in the deck.
     */
    fun drawBottom(amount: Int): List<C>

    /**
     * Add a card to the top of the deck.
     */
    fun addTop(card: C)

    /**
     * Add a card to the bottom of the deck.
     */
    fun addBottom(card: C)

    /**
     * Shuffle the deck.
     */
    fun shuffle()

    /**
     * Peek the first card of the deck, if any.
     */
    fun peek(): C?

    /**
     * Peek at most the first [amount] cards of the deck.
     * @throws IllegalArgumentException if [amount] is negative.
     */
    fun peek(amount: Int): List<C>

    /**
     * Peek the last card of the deck, if any.
     */
    fun peekBottom(): C?

    /**
     * Peek at most the last [amount] cards of the deck.
     *
     * The cards peeked will follow the order as if they were drawn from the bottom
     * one by one.
     *
     * @throws IllegalArgumentException if [amount] is negative.
     */
    fun peekBottom(amount: Int): List<C>
}