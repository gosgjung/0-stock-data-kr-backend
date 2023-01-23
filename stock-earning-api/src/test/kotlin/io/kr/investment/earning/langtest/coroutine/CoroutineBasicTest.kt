package io.kr.investment.earning.langtest.coroutine

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineBasicTest {

    @Test
    fun test1() {
        runBlocking {
            HelloMessage.en()
        }
    }

}