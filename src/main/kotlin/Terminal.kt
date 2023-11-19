import org.example.Client

class Terminal {
    var currentClient: Client? = null

    var finishClientService: (() -> Unit)? = null

    fun serveClient(client: Client, finishClientService: () -> Unit) {
        print("Клиент номер ${client.id} начал обслуживание")
        for (i in 0..client.orderTime) {
            print("Клиент номер ${client.id} обслуживается ${i} секунду")
        }
        print("Клиент номер ${client.id} закончил обслуживание")
        finishClientService()
    }
}