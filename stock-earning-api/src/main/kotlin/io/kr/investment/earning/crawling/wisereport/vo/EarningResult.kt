package io.kr.investment.earning.crawling.wisereport.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class EarningResult(
    @JsonProperty("JsonData") val jsonData: MutableList<EarningCell>
)
