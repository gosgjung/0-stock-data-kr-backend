package io.kr.investment.ticker.corpcode

import io.kr.investment.ticker.corpcode.dto.CorpCodeDto
import io.kr.investment.ticker.external.dart.DartCorpCodeLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Component

@Component
class CorpCodeInitializer (
    @Qualifier("corpCodeTemplate") val corpCodeTemplate: ReactiveRedisTemplate<String, CorpCodeDto>
){

    fun init(){
        initCorpCodeList() // redis 에 티커 리스트 로딩
    }

    fun initCorpCodeList(){
        val dartCorpCodeLoader: DartCorpCodeLoader = DartCorpCodeLoader()

        runBlocking {
            dartCorpCodeLoader.readAllCorpCode()
                .map { CorpCodeDto(corpName = it.corpName, corpCode = it.corpCode, stockCode = it.stockCode) }
                .forEach {
                    withContext(Dispatchers.IO) {
                        corpCodeTemplate.opsForValue()
                            .set(it.stockCode, it)
                            .block()
                    }
                }
        }

    }
}