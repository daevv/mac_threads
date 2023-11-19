import kotlinx.coroutines.*
import org.example.Client
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class TerminalController(val name: String, numOfTerminals: Int, val clientsNum: Int) {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(numOfTerminals)
    private var timer: Long = 0
    private var canShotdown: Boolean = false
//    init {
//        repeat(numOfTerminals) {
////            terminals.add(GlobalScope.async { })
//            contexts.add(newSingleThreadContext("Terminal #$it"))
//            terminals.add(CoroutineScope(contexts.last()).async {  })
//        }
//    }

    suspend fun serveClient(client: Client, index: Int) {
// Find a free handler
        executorService.submit {
            makeOrderOnTerminal(client)
            if (index == 0) {
                startTimer()
            } else if (index == clientsNum - 1) {
                executorService.shutdown()
                println("ExecutorServiceShutDOwn")
                val time = stopTimer()
                println("Время работы кода ${name}: ${(time / 1000.0)} секунд")
            }
        }
    }

    private fun makeOrderOnTerminal(client: Client) {

        Thread.sleep(0,10 * client.orderTime)
    }

    fun startTimer() {
        timer = System.currentTimeMillis()
    }

    fun stopTimer(): Long {
        return System.currentTimeMillis() - timer
    }


}