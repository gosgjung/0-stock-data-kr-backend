package io.kr.investment.earning.langtest.coroutine

import kotlinx.coroutines.delay

class HelloMessage {

    companion object{
        suspend fun en(){
            delay(1000)
            println("hello")
        }
    }
}