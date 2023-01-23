package io.kr.investment.earning.crawling.wisereport.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class EarningCell(
    @JsonProperty("YYMM") val yymm: String,

    @JsonProperty("SALES") val sales: String,

    @JsonProperty("YOY") val yoy: String,

    @JsonProperty("OP") val op: String,

    @JsonProperty("NP") val np: String,

    @JsonProperty("EPS") val eps: String,

    @JsonProperty("BPS") val bps: String,

    @JsonProperty("PER") val per: String,

    @JsonProperty("PBR") val pbr: String,

    @JsonProperty("ROE") val roe: String,

    @JsonProperty("EV") val ev: String,

    @JsonProperty("MAIN") val main: String,

    @JsonProperty("TOP_ROW") val topRow: String,

    @JsonProperty("SALES_TIP") val salesTip: String,

    @JsonProperty("OP_TIP") val opTip: String,

    @JsonProperty("NP_TIP") val npTip: String
){
    fun toEarning(){

    }
}
