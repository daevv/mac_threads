import org.example.ClientGenerator
import kotlin.system.measureTimeMillis

suspend fun main(args: Array<String>) {

    val clientGenerator = ClientGenerator()
    val clients = clientGenerator.generateClientList(10000)


    val terminalController1 = TerminalController(name="ten-thread",10,clients.size)

    for (i in clients.indices) {
        terminalController1.serveClient(clients[i], i)
    }

    val terminalController2 = TerminalController(name="hundred-thread",100, clients.size)
    for (i in clients.indices) {
        terminalController2.serveClient(clients[i], i)
    }

//    val terminal = Terminal()
//    val executionTime = measureTimeMillis {
//        for (client in clients) {
//            terminal.serveClient(client)
//        }
//    }
//    println("Время выполнения: $timeInSeconds милисекунд")
}