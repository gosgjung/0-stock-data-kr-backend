package io.kr.investment.earning.crawling.wisereport.application

import io.kr.investment.earning.crawling.wisereport.type.DataType
import io.kr.investment.earning.crawling.wisereport.type.PeriodType
import io.kr.investment.earning.crawling.wisereport.vo.EarningResult
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class WisereportApiCrawler (
    @Qualifier("wiseReportGainLossClient") val webClient: WebClient,
){

    suspend fun fetchEarningApi(ticker: String, dataType: DataType, periodType: PeriodType): EarningResult {
        return webClient.get()
            .uri {uriBuilder -> EarningRequestUrl.of(uriBuilder, ticker, dataType, periodType) }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve().awaitBody<EarningResult>()
    }


}