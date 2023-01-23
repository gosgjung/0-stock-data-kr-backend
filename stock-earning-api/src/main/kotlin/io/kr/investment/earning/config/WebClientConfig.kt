package io.kr.investment.earning.config

import io.kr.investment.earning.crawling.wisereport.application.EarningRequestUrl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean(name = ["wiseReportGainLossClient"])
    fun wiseReportGainLossClient() : WebClient {
        return WebClient.builder()
            .baseUrl(EarningRequestUrl.BASE_URL)
            .build()
    }
}