import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.selects.select
import org.example.Client


class TerminalController(val numOfTerminals: Int) {
    private val terminals = mutableListOf<Deferred<Unit>>()
    init {
        repeat(numOfTerminals) {
            terminals.add(GlobalScope.async { })
        }
    }

    suspend fun serveClient(client: Client) {
// Find a free handler
        val freeTerminal = terminals.indexOfFirst { it.isCompleted }

        if (freeTerminal != -1) {
// If a free handler is found, launch it with the element
            terminals[freeTerminal] = GlobalScope.async { makeOrderOnTerminal(client) }
        } else {
// If no free handler is found, wait for any handler to become free
            val firstCompleted = select {
                terminals.forEach { handler ->
                    handler.onAwait { terminals.indexOf(handler) }
                }
            }

// Launch the selected handler with the element
            terminals[firstCompleted] = GlobalScope.async {
                makeOrderOnTerminal(client)
            }
        }
    }

    private suspend fun makeOrderOnTerminal(client: Client) {
        println("Клиент номер ${client.id} начал обслуживание")
        for (i in 0..client.orderTime) {
            println("Обслуживается ${i + 1} секунду")
        }
        println("Клиент закончил обслуживание")
        println()
    }


}