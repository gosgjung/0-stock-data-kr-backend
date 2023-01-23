package io.kr.investment.earning.crawling.wisereport.application

import io.kr.investment.earning.crawling.wisereport.code.ParameterCode
import io.kr.investment.earning.crawling.wisereport.type.DataType
import io.kr.investment.earning.crawling.wisereport.type.PeriodType
import io.kr.investment.earning.crawling.wisereport.vo.EarningResult
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.util.UriBuilder
import java.net.URI
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EarningRequestUrl (){
    companion object{
        val BASE_URL = "https://comp.wisereport.co.kr/company/ajax/c1050001_data.aspx"

        fun of(ticker: String, dataType: DataType, periodType: PeriodType):String{
            return StringBuilder(BASE_URL).append("?")
                .append(ParameterCode.DATA_TYPE.parameterName).append("=").append(dataType.code).append("&")
                .append(ParameterCode.TICKER.parameterName).append("=").append(ticker).append("&")
                .append("finGubun=MAIN").append("&")
                .append(ParameterCode.PERIOD_TYPE.parameterName).append("=").append(periodType.code).append("&")
                .append("sDT").append("=").append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))).append("&")
                .append("chartType=svg")
                .toString()
        }

        fun of(uriBuilder: UriBuilder, ticker: String, dataType: DataType, periodType: PeriodType): URI {
            val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))

            return uriBuilder
                .queryParam(ParameterCode.DATA_TYPE.parameterName, dataType.code)
                .queryParam(ParameterCode.TICKER.parameterName, ticker)
                .queryParam("finGubun", "MAIN")
                .queryParam(ParameterCode.PERIOD_TYPE.parameterName, periodType.code)
                .queryParam("sDT", today)
                .queryParam("chartType", "svg")
                .build()
        }
    }
}