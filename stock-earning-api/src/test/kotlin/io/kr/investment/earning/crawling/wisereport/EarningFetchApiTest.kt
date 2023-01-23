package io.kr.investment.earning.crawling.wisereport

import io.kr.investment.earning.crawling.wisereport.application.WisereportApiCrawler
import io.kr.investment.earning.crawling.wisereport.type.DataType
import io.kr.investment.earning.crawling.wisereport.type.PeriodType
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class EarningFetchApiTest @Autowired constructor(
    @Qualifier("wiseReportGainLossClient") val webClient: WebClient
){

    @Test
    fun FETCH_API_RESULT(){
        runBlocking {
            val crawler = WisereportApiCrawler(webClient)
            val r = crawler.fetchEarningApi(ticker = "005930", dataType = DataType.EARNING, periodType = PeriodType.QUARTER)
            println(r)
        }
    }

}