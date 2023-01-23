package io.kr.investment.earning.crawling.wisereport.vo

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class DecimalValueObjectTest {

    @Test
    fun TEST_PARSE(){
        val str1 = "3,054,876.0"
        val parsed = DecimalValueObject.of(str1)
        println("str1 = $str1, parsed = $parsed, className = ${parsed.javaClass.simpleName}")

        assertThat(parsed.value).isEqualTo(BigDecimal.valueOf(3054876))
        assertThat(parsed.isExist).isTrue()
    }
}