package org.example

import java.util.Random

class ClientGenerator {
    fun generateClientList(size: Int): List<Client> {
        val clientList: MutableList<Client> = mutableListOf()
        for (i in 1..size) {
            clientList.add(createRandomClient(i))
        }
        return clientList
    }

    private fun createOrder(size: Int): List<Dish> {
        val shuffledDishes = Dish.entries.toList().shuffled()
        val newOrder = shuffledDishes.take(size)
        return newOrder
    }

    private fun createRandomClient(id: Int): Client {
        val randomizer = Random()
        val orderTime = randomizer.nextInt(1, 6)
        val dishesNum = randomizer.nextInt(1, 7)
        val order = createOrder(dishesNum)
        return Client(orderTime, order, id)
    }
}