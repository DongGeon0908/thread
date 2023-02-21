class ThreadLocalUtils {
    companion object {
        /** ThreadLocal에 데이터 삽입 */
        fun <T> add(data: T): ThreadLocal<T> {
            return ThreadLocal.withInitial { data }
        }

        /** ThreadLocal에 저장된 값이 Null이 될 경우 발생 */
        fun <T> get(data: ThreadLocal<T>): T? {
            return data.get()
        }

        /** ThreadLocal의 데이터를 삭제 */
        fun <T> delete(data: ThreadLocal<T>) {
            data.remove()
        }
    }
}
