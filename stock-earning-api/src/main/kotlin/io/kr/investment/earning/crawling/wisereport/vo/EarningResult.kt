package io.kr.investment.earning.crawling.wisereport.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class EarningResult(
    @JsonProperty("JsonData") val jsonData: List<EarningCell>
){
    fun toEarningList(): List<Earning>{
        return jsonData
            .map{ Earning.of(it) }
    }

}
