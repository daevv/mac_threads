import org.example.ClientGenerator
import kotlin.system.measureTimeMillis

suspend fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val clientGenerator = ClientGenerator()
    val clients = clientGenerator.generateClientList(1000)
    val terminalController1 = TerminalController(name="one-thread",1,clients.size)


//    val terminal = Terminal()
//    val executionTime1 = measureTimeMillis {
//        for (client in clients) {
//            terminal.serveClient(client)
//        }
//    }
    for (i in clients.indices) {
        terminalController1.serveClient(clients[i], i)

    }

    val terminalController2 = TerminalController(name="two-thread",1,clients.size)
    for (i in clients.indices) {
        terminalController2.serveClient(clients[i], i)
    }


////    println("Время работы кода 1: ${(executionTime1 / 1000.0)} секунд")
//    println("Время работы кода 2: ${(executionTime2 / 1000.0)} секунд")
//    println("Время работы кода 3: ${(executionTime3 / 1000.0)} секунд")
}