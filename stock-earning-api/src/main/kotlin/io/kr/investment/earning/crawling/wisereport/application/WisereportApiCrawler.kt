package io.kr.investment.earning.crawling.wisereport.application

import com.fasterxml.jackson.databind.ObjectMapper
import io.kr.investment.earning.crawling.wisereport.type.DataType
import io.kr.investment.earning.crawling.wisereport.type.PeriodType
import io.kr.investment.earning.crawling.wisereport.vo.EarningResult
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class WisereportApiCrawler (
    @Qualifier("wiseReportGainLossClient") val webClient: WebClient,
){

    suspend fun fetchEarningApi(ticker: String, dataType: DataType, periodType: PeriodType): EarningResult {
        return toEarningResult(fetchApi(ticker, dataType, periodType))
    }

    suspend fun fetchApi(ticker: String, dataType: DataType, periodType: PeriodType): String{
        return webClient.get()
            .uri {uriBuilder -> EarningRequestUrl.of(uriBuilder, ticker, dataType, periodType) }
            //.accept(MediaType.APPLICATION_JSON)   // 우리쪽에서 아무리 application/json 으로 헤더를 보내도
            .headers { it.add("Accept", "*/*") }    // 와이즈리포트에서 text/html 로 응답하기에 accept all
            .retrieve()
            .awaitBody()
    }

    suspend fun toEarningResult(str: String): EarningResult{
        return ObjectMapper().readValue(str, EarningResult::class.java)
    }

}