class ThreadManagerUtils {
    companion object {
        /** 현재 실행중인 애플리케이션의 모든 스레드 정보 조회 */
        fun getAllThreadsInfo(): Map<String, Thread> {
            return Thread.getAllStackTraces().keys
                .associateBy { it.name }
        }

        /** 현재 실행중인 애플리케이션에서 특정 prefix로 시작하는 모든 스레드 정보 조회 */
        fun getAllThreadsInfo(threadNamePrefix: String): Map<String, Thread> {
            return Thread.getAllStackTraces().keys
                .filter { it.name.contains(threadNamePrefix) }
                .associateBy { it.name }
        }

        /** 특정 Thread Name을 가진 Thread 정보 조회 */
        fun getThreadInfo(threadName: String): Thread? {
            return Thread.getAllStackTraces().keys
                .firstOrNull { it.name == threadName }
        }
    }
}
