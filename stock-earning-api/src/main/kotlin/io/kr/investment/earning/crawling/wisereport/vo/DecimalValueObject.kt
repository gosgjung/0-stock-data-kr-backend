package io.kr.investment.earning.crawling.wisereport.vo

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

data class DecimalValueObject(
    val isExist:Boolean = true,
    val value:BigDecimal,
){
    companion object {
        fun ofExistingData(value: BigDecimal):DecimalValueObject{
            return DecimalValueObject(isExist = true, value = value)
        }

        fun ofNonExistingData(value: BigDecimal = BigDecimal.ZERO):DecimalValueObject{
            return DecimalValueObject(isExist = false, value = value)
        }

        fun parseBigDecimal(str: String): BigDecimal{
            return BigDecimal(NumberFormat.getNumberInstance(Locale.US).parse(str).toString())
        }

        fun of(str: String) : DecimalValueObject {
            return if(str == null || str.isEmpty())
                DecimalValueObject.ofNonExistingData()
            else
                DecimalValueObject.ofExistingData(parseBigDecimal(str))
        }
    }
}