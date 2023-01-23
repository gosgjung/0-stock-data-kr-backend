package io.kr.investment.earning.crawling.wisereport.vo

import java.math.BigDecimal

data class Earning(
    val yymm: String,

    val sales: DecimalValueObject,

    val yoy: DecimalValueObject,

    val op: DecimalValueObject,

    val np: DecimalValueObject,

    val eps: DecimalValueObject,

    val bps: DecimalValueObject,

    val per: DecimalValueObject,

    val pbr: DecimalValueObject,

    val roe: DecimalValueObject,

    val ev: DecimalValueObject,

    val main: String,

    val totRow: Int,

    val salesTip: DecimalValueObject,

    val opTip: DecimalValueObject,

    val npTip: DecimalValueObject
){
    companion object{
        fun of(earningCell: EarningCell): Earning{
            return Earning(
                yymm = earningCell.yymm,
                sales = DecimalValueObject.of(earningCell.sales),
                yoy = DecimalValueObject.of(earningCell.yoy),
                op = DecimalValueObject.of(earningCell.op),
                np = DecimalValueObject.of(earningCell.np),
                eps = DecimalValueObject.of(earningCell.eps),
                bps = DecimalValueObject.of(earningCell.bps),
                per = DecimalValueObject.of(earningCell.per),
                pbr = DecimalValueObject.of(earningCell.pbr),
                roe = DecimalValueObject.of(earningCell.roe),
                ev = DecimalValueObject.of(earningCell.ev),
                main = earningCell.main,
                totRow = earningCell.totRow,
                salesTip = DecimalValueObject.of(earningCell.salesTip),
                opTip = DecimalValueObject.of(earningCell.opTip),
                npTip = DecimalValueObject.of(earningCell.npTip)
            )
        }
    }
}
