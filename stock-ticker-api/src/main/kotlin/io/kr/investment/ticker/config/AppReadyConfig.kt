package io.kr.investment.ticker.config

import io.kr.investment.ticker.corpcode.CorpCodeInitializer
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class AppReadyConfig (
    val corpCodeInitializer: CorpCodeInitializer
){

    @EventListener(ApplicationReadyEvent::class)
    fun appReady(){
        corpCodeInitializer.init()
    }

}