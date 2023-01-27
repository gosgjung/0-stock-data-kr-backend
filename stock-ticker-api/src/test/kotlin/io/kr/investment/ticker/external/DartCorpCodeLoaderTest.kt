package io.kr.investment.ticker.external

import io.kr.investment.ticker.external.dart.DartCorpCodeEnvironment
import io.kr.investment.ticker.external.dart.DartCorpCodeLoader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DartCorpCodeLoaderTest {

    @Test
    fun ofInputStreamTest(){
        val dartCorpCodeLoader : DartCorpCodeLoader = DartCorpCodeLoader()

        val inputStream = dartCorpCodeLoader.ofInputStream(DartCorpCodeEnvironment.PATH_DART_CORP_CODE_XML)

        assertThat(inputStream).isNotEmpty
    }

    @Test
    fun readTickerNodesTest(){
        val dartCorpCodeLoader : DartCorpCodeLoader = DartCorpCodeLoader()

        val nodeList = dartCorpCodeLoader.readTickerNodes(dartCorpCodeLoader.ofInputStream(DartCorpCodeEnvironment.PATH_DART_CORP_CODE_XML))

        assertThat(nodeList).isNotNull
    }

    @Test
    fun readAllCorpCodeTest(){
        val dartCorpCodeLoader : DartCorpCodeLoader = DartCorpCodeLoader()

        val list = dartCorpCodeLoader.readAllCorpCode()

        assertThat(list).isNotEmpty
    }
}