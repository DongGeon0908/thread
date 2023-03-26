import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

/** 비동기 작업에 대한 종료를 보장 */
object MultiThreadUtils {
    fun syncRunJobs(jobs: List<ThreadJob>) {
        val finishedJobs = CountDownLatch(jobs.size)
        val executors = Executors.newFixedThreadPool(jobs.size)

        jobs.forEach { job ->
            executors.submit {
                job.run()
                finishedJobs.countDown()
            }
        }

        finishedJobs.await()
        executors.shutdown()
    }
}

interface ThreadJob {
    fun run()
}
