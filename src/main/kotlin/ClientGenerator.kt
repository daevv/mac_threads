package org.example

import java.util.Random

class ClientGenerator {
    fun generateClientList(size: Int): List<Client> {
        TODO()

    }

    private fun createOrder(size: Int): List<Number> {
        val randomizer = Random()
        val dishesNum = randomizer.nextInt(1, 7)
        TODO()

    }

    private fun createRandomClient(id: Int): Client {
        val randomizer = Random()
        val orderTime = randomizer.nextInt(1, 6)
//        val order = Order
        TODO()
    }
}