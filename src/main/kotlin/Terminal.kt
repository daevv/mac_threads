import org.example.Client

class Terminal {

    fun serveClient(client: Client) {
        println("Клиент номер ${client.id} начал обслуживание")
        for (i in 0..client.orderTime) {
            println("Обслуживается ${i + 1} секунду")
        }
        println("Клиент закончил обслуживание")
        println()
    }
}