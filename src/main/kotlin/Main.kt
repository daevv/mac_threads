import org.example.ClientGenerator
import kotlin.system.measureTimeMillis

suspend fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val clientGenerator = ClientGenerator()
    val clients = clientGenerator.generateClientList(10000)
    val terminalController1 = TerminalController(1)

    val executionTime1 = measureTimeMillis {
        for (client in clients) {
            terminalController1.serveClient(client)
        }
    }

    val terminal = Terminal()
    val executionTime2 = measureTimeMillis {
        for (client in clients) {
            terminal.serveClient(client)
        }
    }
    val terminalController2 = TerminalController(2)
    val executionTime3 = measureTimeMillis {
        for (client in clients) {
            terminalController2.serveClient(client)
        }
    }


    println("Время работы кода 1: ${(executionTime1 / 1000.0)} секунд")
    println("Время работы кода 2: ${(executionTime2 / 1000.0)} секунд")
    println("Время работы кода 3: ${(executionTime3 / 1000.0)} секунд")
}