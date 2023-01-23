package io.kr.investment.earning.crawling.wisereport.vo

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class EarningCell(
    @JsonProperty("YYMM") @SerializedName("YYMM") val yymm: String,

    @JsonProperty("SALES") @SerializedName("SALES") val sales: String,

    @JsonProperty("YOY") @SerializedName("YOY") val yoy: String,

    @JsonProperty("OP") @SerializedName("OP") val op: String,

    @JsonProperty("NP") @SerializedName("NP") val np: String,

    @JsonProperty("EPS") @SerializedName("EPS") val eps: String,

    @JsonProperty("BPS") @SerializedName("BPS") val bps: String,

    @JsonProperty("PER") @SerializedName("PER") val per: String,

    @JsonProperty("PBR") @SerializedName("PBR") val pbr: String,

    @JsonProperty("ROE") @SerializedName("ROE") val roe: String,

    @JsonProperty("EV") @SerializedName("EV") val ev: String,

    @JsonProperty("MAIN") @SerializedName("MAIN") val main: String,

    @JsonProperty("TOT_ROW") @SerializedName("TOT_ROW") val totRow: Int,

    @JsonProperty("SALES_TIP") @SerializedName("SALES_TIP") val salesTip: String,

    @JsonProperty("OP_TIP") @SerializedName("OP_TIP") val opTip: String,

    @JsonProperty("NP_TIP") @SerializedName("NP_TIP") val npTip: String
){
}
