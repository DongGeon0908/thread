import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {
    thread().start()
}

/**
 * Thread
 * @see java.lang.Thread
 **/
fun thread(): Thread {
    return Thread { println("hello world") }
}

/**
 * Thread Name
 **/
fun getThreadName(): String {
    return Thread.currentThread().name
}

/**
 * concurrency controller for Thread priority
 **/
fun controllerPriority() {
    val thread = thread()
    thread.priority = 5 // 1 ~ 10
    thread.priority = Thread.MAX_PRIORITY
}

/**
 * critical section by synchronized
 **/
fun lockObjectBySynchronized() {
    var name = "김동건"
    synchronized(name) {
        name = "동건"
    }
}

/**
 * Thread State
 * @see java.lang.Thread.State
 **/
fun getThreadState(): String {
    val thread = thread()
    return thread.state.name
}

/**
 * newCachedThreadPool
 **/
fun generatedThreadPoolByNewCachedThreadPool() {
    val executorService = Executors.newCachedThreadPool()
}


/**
 * newFixedThreadPool
 **/
fun generatedThreadPoolByNewFixedThreadPool() {
    val executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
}

/**
 * threadPoolExecutor
 **/
fun generatedThreadPoolExecutor() {
    val executorService = ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, SynchronousQueue())

    executorService.execute(runnableAndCallable())

    executorService.shutdown() // 남아있는 작업을 마무리하고 종료
    executorService.shutdownNow() // 강제 종료
}

fun runnableAndCallable() : Runnable {
    val task1 = Runnable {
        @Override
        fun run() {
        }
    }

    val task2 = Callable {
        @Override
        fun call(): String {
            return "happy"
        }
    }

    return task1
}
